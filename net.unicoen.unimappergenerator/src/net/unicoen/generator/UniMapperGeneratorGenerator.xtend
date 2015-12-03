/*
 * generated by Xtext
 */
package net.unicoen.generator

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import net.unicoen.node.UniNode
import net.unicoen.uniMapperGenerator.Atom
import net.unicoen.uniMapperGenerator.Element
import net.unicoen.uniMapperGenerator.Grammar
import net.unicoen.uniMapperGenerator.LexerRule
import net.unicoen.uniMapperGenerator.ParserRule
import net.unicoen.uniMapperGenerator.RuleRef
import net.unicoen.uniMapperGenerator.Terminal
import net.unicoen.util.InvokingStateAnalyzer
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class UniMapperGeneratorGenerator implements IGenerator {
	private String _grammarName
	private InvokingStateAnalyzer _analyzer;

	override def doGenerate(Resource resource, IFileSystemAccess fsa) {
		val g4Generator = new ANTLRGrammarGenerator(fsa)
		val testGenerator = new MapperTestGenerator(fsa)
		resource.allContents.filter(Grammar).forEach [
			_grammarName = it.name.toCamelCase
			val parserCode = g4Generator.generate(_grammarName, it)
			_analyzer = new InvokingStateAnalyzer(parserCode, it)
			fsa.generateFile(_grammarName + "Mapper.xtend", it.generateMapper)
			testGenerator.generate(_grammarName, it)
		]
	}

	def generateImports() '''
		package net.unicoen.mapper
		
		import java.io.FileInputStream
		import java.util.ArrayList
		import java.util.List
		import net.unicoen.node.*
		import net.unicoen.parser.«_grammarName»Lexer
		import net.unicoen.parser.«_grammarName»Parser
		import net.unicoen.parser.«_grammarName»BaseVisitor
		import org.antlr.v4.runtime.ANTLRInputStream
		import org.antlr.v4.runtime.CharStream
		import org.antlr.v4.runtime.CommonTokenStream
		import org.antlr.v4.runtime.ParserRuleContext
		import org.antlr.v4.runtime.RuleContext
		import org.antlr.v4.runtime.tree.ParseTree
		import org.antlr.v4.runtime.tree.RuleNode
		import org.antlr.v4.runtime.tree.TerminalNode
		import org.eclipse.xtext.xbase.lib.Functions.Function1
	'''

	def generateMapper(Grammar g) '''
		«generateImports»
		
		class «_grammarName»Mapper extends «_grammarName»BaseVisitor<Object> {
			var _isDebugMode = false
		
			new(boolean isDebugMode) {
				_isDebugMode = isDebugMode
			}
		
			def parse(String code) {
				parseCore(new ANTLRInputStream(code));
			}
		
			def parseFile(String path) {
				val inputStream = new FileInputStream(path);
				try {
					parseCore(new ANTLRInputStream(inputStream));
				} finally {
					inputStream.close();
				}
			}
		
			def parseCore(CharStream chars) {
				parseCore(chars, [parser|parser.compilationUnit()])
			}
		
			def parse(String code, Function1<«_grammarName»Parser, ParseTree> parseAction) {
				parseCore(new ANTLRInputStream(code), parseAction);
			}
		
			def parseFile(String path, Function1<«_grammarName»Parser, ParseTree> parseAction) {
				val inputStream = new FileInputStream(path);
				try {
					parseCore(new ANTLRInputStream(inputStream), parseAction);
				} finally {
					inputStream.close();
				}
			}
		
			def parseCore(CharStream chars, Function1<«_grammarName»Parser, ParseTree> parseAction) {
				val lexer = new «_grammarName»Lexer(chars);
				val tokens = new CommonTokenStream(lexer);
				val parser = new «_grammarName»Parser(tokens);
				val tree = parseAction.apply(parser) // parse
				«IF g.rules.size > 0»
					tree.visit
      			«ENDIF»
			}

			override public visitChildren(RuleNode node) {
				val n = node.childCount;
				(0 ..< n).fold(defaultResult) [ acc, i |
					if (!node.shouldVisitNextChild(acc)) {
						acc
					} else {
						val c = node.getChild(i)
						val childResult = c.visit
						acc.aggregateResult(childResult)
					}
				]
			}
		
			override public visit(ParseTree tree) {
				if (_isDebugMode) {
					if (!(tree instanceof ParserRuleContext)) {
						return visitTerminal(tree as TerminalNode)
					}
					val ruleName = «_grammarName»Parser.ruleNames.get((tree as ParserRuleContext).ruleIndex)
					println("*** visit" + ruleName + " ***")
					println(tree.text)
					val ret = tree.accept(this)
					println("returned: " + ret)
					ret
				} else {
					tree.accept(this)
				}
			}
			«FOR r : g.rules.filter(ParserRule)»
				«IF r.type != null»

					«IF r.type.list.bind.endsWith("Literal")»
						«r.makeLiteralMethod»
					«ELSE»
						«r.makeVisitMethod»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		}
	'''

	def toCamelCase(String str) {
		Character.toUpperCase(str.charAt(0)) + str.substring(1)
	}

	def makeVisitMethod(ParserRule r) {
		val ruleName = r.name.toCamelCase
		val typeName = r.type.list.bind
		'''
			override public visit«ruleName»(«_grammarName»Parser.«ruleName»Context ctx) {
				«IF typeName.startsWith("Uni")»
					«val fullTypeName = UniNode.package.name + '.' + typeName»
					«r.makeMethodBody(Class.forName(fullTypeName))»
				«ELSEIF typeName.startsWith("List")»
					«val itemClassName = typeName.substring(typeName.indexOf('<') + 1, typeName.indexOf('>'))»
					«r.makeListMethodBody(itemClassName)»
				«ELSEIF typeName == "String"»
					«r.makeStringMethodBody»
				«ELSE»
					«die("Unknown Class Name: " + typeName)»
				«ENDIF»
			}
		'''
	}

	def makeCaseStatement(ParserRule r, Element obj, String fieldTypeName, String fieldName, String returnType) {
		val rule = obj.eAllContents.filter(RuleRef).head
		if (rule == null) {
			die("rule must not to be null.")
		}
		val ruleName = rule.reference.name.toCamelCase
		'''
			«IF fieldTypeName.startsWith("java.util.List")»
				«val refType = obj.referenceReturnType»
				«IF refType == null»
					«die("Rule " + ruleName + " does not have return type.")»
				«ENDIF»
				«IF refType.startsWith("List")»
					if (bind.«fieldName» == null) {
						bind.«fieldName» = it.visit as «fieldTypeName»
					} else {
						bind.«fieldName» += it.visit as «fieldTypeName»
					}
				«ELSE»
					if (bind.«fieldName» == null) {
						bind.«fieldName» = new ArrayList<«refType»>
					}
					bind.«fieldName» += it.visit as «refType»
				«ENDIF»
			«ELSE»
				bind.«fieldName» = it.visit as «fieldTypeName»
			«ENDIF»
		'''
	}

	def makeMethodBody(ParserRule r, Class<?> clazz) '''
		val bind = new «r.type.list.bind»
		«IF r.type.list.ret != null»
			val ret = new «r.type.list.ret»
		«ENDIF»
		for (it : ctx.children) {
			if (it instanceof RuleContext) {
				switch it.invokingState {
					«FOR it : r.eAllContents.filter(Element).toList»
						«val atom = it.body»
						«IF atom instanceof Atom»
							«val ref = atom.body»
							«IF ref instanceof RuleRef»
								«val invokingState = r.getInvokingState(it)»
								«IF it.op != null»
									case «invokingState»: {
										«IF it.op == "MERGE"»
											«IF r.type.list.bind != it.referenceReturnType»
												«die("Expected return type: " + r.type.list.bind + " actual type: " + it.referenceReturnType)»
											«ENDIF»
											val child = it.visit as «r.type.list.bind»
											bind.merge(child)
										«ELSEIF it.op == "RETURN"»
											bind = it.visit as «r.type.list.ret»
										«ELSE»
											«try {
												val field = clazz.getField(it.op)
												val fieldTypeName = field.genericType.typeName
												r.makeCaseStatement(it, fieldTypeName, it.op, r.type.list.bind)
											} catch (NoSuchFieldException e) {
												die("No such Field: " + it.op)
											}»
										«ENDIF»
									}
								«ENDIF»
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				}
			} else if (it instanceof TerminalNode) {
				«var firstIf = true»
				«FOR it : r.eAllContents.filter(Element).toList»
					«val atom = it.body»
					«IF atom instanceof Atom»
						«val ref = atom.body»
						«IF ref instanceof Terminal»
							«IF it.op != null»
								«try {
									clazz.getField(it.op)
									'''
									«if (firstIf) {firstIf = false; ""} else "else "»if (it.symbol.type == «_grammarName»Parser.«it.terminalName») {
										bind.«it.op» = it.text
									}
									'''
								} catch (NoSuchFieldException e) {
									die("No such Field: " + it.op)
								}»
							«ENDIF»
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			}
		}
		«IF r.type.list.ret != null»
			if (ret != null) {
				return ret
			}
		«ENDIF»
		bind
	'''

	def getReferenceReturnType(Element r) {
		val ref = (r.body as Atom).body
		if (ref instanceof RuleRef) {
			if (ref.reference.type != null) {
				ref.reference.type.list.bind
			}
		}
	}

	def getTerminalName(Element r) {
		val ref = (r.body as Atom).body
		if (ref instanceof Terminal) {
			(ref.reference as LexerRule).name
		}
	}

	def getTypeName(Type type) {
		switch type {
			Class<?>:
				return type.name
			ParameterizedType: {
				val sb = new StringBuilder
				sb.append(type.typeName).append('<')
				var isFirst = true
				for (Type arg : type.actualTypeArguments) {
					if (!isFirst) {
						sb.append(',')
					}
					sb.append(arg.typeName)
				}
				sb.append('>')
				return sb.toString
			}
			default:
				die("Unknown type:" + type.toString)
		}
	}

	def makeListMethodBody(ParserRule r, String itemClassName) '''
		val list = new ArrayList<«itemClassName»>
		«IF r.hasItemClassField(itemClassName)»
			val tNode = new «itemClassName»
		«ENDIF»
		if (ctx.children != null) {	// required
			for (it : ctx.children) {
				if (it instanceof RuleContext) {
					switch it.invokingState {
						«FOR it : r.eAllContents.filter(Element).toList»
							«val atom = it.body»
							«IF atom instanceof Atom»
								«val ref = atom.body»
								«IF ref instanceof RuleRef»
									«val invokingState = r.getInvokingState(it)»
									«IF it.op != null»
										case «invokingState»: {
											«IF it.op == "ADD"»
												«val refType = it.referenceReturnType»
												«IF refType != null»
													list += it.visit as «refType»
												«ELSE»
													val ret = it.visit
													if (ret instanceof «itemClassName») {
														list += ret as «itemClassName»
													} else {
														list += ret as List<«itemClassName»>
													}
												«ENDIF»
											«ELSEIF r.hasItemClassField(itemClassName)»
												«try {
													val clazz = Class.forName(UniNode.package.name + '.' + itemClassName)
													val field = clazz.getField(it.op)
													val fieldTypeName = field.genericType.typeName
													'''
													tNode.«field.name» = it.visit as «fieldTypeName»
													'''
												} catch (NoSuchFieldException e) {
													die("No such Field: " + it.op)
												} catch (ClassNotFoundException e) {
													die("No such class: " + itemClassName)
												}»
											«ENDIF»
										}
									«ENDIF»
								«ENDIF»
							«ENDIF»
						«ENDFOR»
					}
				}
			}
		}
		«IF r.hasItemClassField(itemClassName)»
			list.forEach [
				it.merge(tNode)
			]
		«ENDIF»		
		list
	'''

	def makeStringMethodBody(ParserRule r) '''
		ctx.text
	'''


	def makeLiteralMethod(ParserRule r) '''
		«val methodName = "visit" + r.name.toCamelCase»
		override public «methodName»(«_grammarName»Parser.«r.name.toCamelCase»Context ctx) {
			val text = ctx.children.findFirst[
				if (it instanceof TerminalNode) {
					«FOR it : r.eAllContents.filter(Element).toList»
						«IF it.op != null»
							«IF it.op == "value"»
								if (it.symbol.type == «_grammarName»Parser.«it.terminalName») {
									return true;
								}
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				}
				return false;
			].text
			«IF r.type.list.bind == "UniIntLiteral"»
				return new UniIntLiteral(Integer.parseInt(text))
			«ELSEIF r.type.list.bind == "UniBoolLiteral"»
				return new UniBoolLiteral("true" == text)
			«ELSEIF r.type.list.bind == "UniDoubleLiteral"»
				return new UniDoubleLiteral(Double.parseDouble(text))
			«ELSEIF r.type.list.bind == "UniStringLiteral"»
				return new UniStringLiteral(text.substring(1, text.length - 1))
			«ELSE»
				throw new RuntimeException("Unimplemented Method: «methodName»")
			«ENDIF»
		}
	'''

	def die(String message) {
		throw new RuntimeException(message)
	}

	def getInvokingState(ParserRule r, Element obj) {
		_analyzer.getInvokingState(r, obj)
	}

	def hasItemClassField(ParserRule r, String itemClassName) {
		val list = r.eAllContents.filter(Element).toIterable
		for (elem : list) {
			if (itemClassName.hasField(elem.op)) {
				return true
			}
		}
		return false
	}

	def hasField(String itemClass, String fieldName) {
		try {
			val clazz = Class.forName(UniNode.package.name + '.' + itemClass)
			clazz.getField(fieldName)
		} catch (Exception e) {
			return false
		}
		return true
	}

}
