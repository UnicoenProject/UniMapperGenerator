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
import com.google.common.collect.Sets

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

		import com.google.common.collect.Lists
		import com.google.common.collect.Maps
		import java.io.FileInputStream
		import java.util.List
		import java.util.Map
		import net.unicoen.node.*
		import net.unicoen.parser.«_grammarName»BaseVisitor
		import net.unicoen.parser.«_grammarName»Lexer
		import net.unicoen.parser.«_grammarName»Parser
		import org.antlr.v4.runtime.ANTLRInputStream
		import org.antlr.v4.runtime.CharStream
		import org.antlr.v4.runtime.CommonTokenStream
		import org.antlr.v4.runtime.ParserRuleContext
		import org.antlr.v4.runtime.RuleContext
		import org.antlr.v4.runtime.tree.ParseTree
		import org.antlr.v4.runtime.tree.RuleNode
		import org.antlr.v4.runtime.tree.TerminalNode
		import org.antlr.v4.runtime.tree.TerminalNodeImpl
		import org.eclipse.xtext.xbase.lib.Functions.Function1
		import java.lang.reflect.ParameterizedType
	'''

	def generateMapper(Grammar g) '''
		«generateImports»
		
		class «_grammarName»Mapper extends «_grammarName»BaseVisitor<Object> {
			val boolean _isDebugMode
		
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
				val list = Lists.newArrayList()
				(0 ..< n).forEach [ i |
					val c = node.getChild(i)
					val childResult = c.visit
					list += childResult
				]
				list
			}
		
			override public visit(ParseTree tree) {
				if (_isDebugMode) {
					if (!(tree instanceof ParserRuleContext)) {
						return visitTerminal(tree as TerminalNode)
					}
					val ruleName = Java8Parser.ruleNames.get((tree as ParserRuleContext).ruleIndex)
					println("enter " + ruleName + " : " + tree.text)
					val ret = tree.accept(this)
					println("exit " + ruleName + " : " + ret)
					ret
				} else {
					tree.accept(this)
				}
			}

			override public visitTerminal(TerminalNode node) {
				println("visit TERMINAL : " + node.text)
				node.text
			}
		
			private def Object flatten(Object obj) {
				if (obj instanceof List<?>) {
					if (obj.size == 1) {
						return obj.get(0).flatten
					}
					val ret = Lists.newArrayList
					obj.forEach [
						ret += it.flatten
					]
					return ret
				}
				if (obj instanceof Map<?,?>) {
					if (obj.size == 1) {
						return obj.get(obj.keySet.get(0)).flatten
					}
					val ret = Maps.newHashMap
					obj.forEach [ key, value |
						ret.put(key, value.flatten)
					]
					return ret
				}
				obj
			}
		
			public def <T> List<T> castToList(Object obj, Class<T> clazz) {
				val temp = obj.flatten
				val ret = Lists.newArrayList
				if (temp instanceof Map<?, ?>) {
					val add = temp.containsKey("add")
					temp.forEach [ key, value |
						switch key {
							case "add": {
								ret += value.castToList(clazz)
							}
							default: {
								if (!add) {
									ret += value.castToList(clazz)
								}
							}
						}
					]
				} else if (temp instanceof List<?>) {
					temp.forEach [
						ret += it.castToList(clazz)
					]
				} else {
					ret += temp.castTo(clazz)
				}
				ret
			}
		
			public def <T> T castTo(Object obj, Class<T> clazz) {
				val temp = obj.flatten
				if (temp instanceof Map<?,?>) {
					if (String.isAssignableFrom(clazz)) {
						val builder = new StringBuilder
						temp.forEach [ key, value |
							builder.append(value.castTo(clazz))
						]
						return clazz.getConstructor(StringBuilder).newInstance(builder)
					}
					val instance = clazz.newInstance
					val fields = clazz.fields
					val fieldsName = Lists.newArrayList
					fields.forEach[fieldsName.add(it.name)]
					temp.forEach [ key, value |
						if (fieldsName.contains(key)) {
							val field = fields.get(fieldsName.indexOf(key))
							field.set(instance,
								if (List.isAssignableFrom(field.type)) {
									value.castToList(
										(field.genericType as ParameterizedType).actualTypeArguments.get(0) as Class<?>)
								} else {
									value.castTo(field.type)
								})
						}
					]
					return instance
				}
				if (temp instanceof List<?>) {
					if (String.isAssignableFrom(clazz)) {
						val builder = new StringBuilder
						temp.forEach [
							builder.append(it.castTo(clazz))
						]
						return clazz.getConstructor(StringBuilder).newInstance(builder)
					}
					val first = temp.findFirst[clazz.isAssignableFrom(it.class)]
					return if (first == null) {
						if (clazz != UniExpr) clazz.newInstance else null
					} else
						first.castTo(clazz)
				}
				clazz.cast(temp)
			}
		
			«FOR r : g.rules.filter(ParserRule)»
				«IF r.type != null && r.type.name.endsWith("Literal")»
					«r.makeLiteralMethod»
				«ELSEIF r.type != null && r.eAllContents.filter(Element).findFirst[it.op != null] != null»
					«r.makeVisitMethod»
				«ENDIF»
			«ENDFOR»
		}
	'''

	def toCamelCase(String str) {
		Character.toUpperCase(str.charAt(0)) + str.substring(1)
	}

	def makeVisitMethod(ParserRule r) {
		val ruleName = r.name.toCamelCase
		val typeName = if (r.type != null) {
			r.type.name
		} else {
			new String
		}
		'''
			override public visit«ruleName»(«_grammarName»Parser.«ruleName»Context ctx) {
				«IF typeName.startsWith("Uni")»
					«val fullTypeName = UniNode.package.name + '.' + typeName»
					«r.makeMethodBody(Class.forName(fullTypeName))»
				«ELSEIF typeName.startsWith("List")»
					«val itemClassName = typeName.substring(typeName.indexOf('<') + 1, typeName.indexOf('>'))»
					«r.makeListMethodBody(itemClassName)»
				«ELSE»
					«r.makeStringMethodBody»
				«ENDIF»
			}
			
		'''
	}

	def makeMethodBody(ParserRule r, Class<?> clazz) {
		val annotationList = Sets.newHashSet
		val elementList = r.eAllContents.filter(Element).toList
		val hasMerge = elementList.findFirst[ it.op != null && it.op == "MERGE" ] != null
		val hasReturn = elementList.findFirst[ it.op != null && it.op == "RETURN" ] != null
		elementList.forEach[
			if(it.op != null){
				annotationList += it.op
			}
		]
	'''
		val map = Maps.newHashMap
		val none = Lists.newArrayList
		map.put("none", none)
		«FOR it : annotationList»«IF it != "MERGE" && it != "RETURN"»
		val «if (it == "ADD") it.toLowerCase else it» = Lists.newArrayList
		map.put("«if (it == "ADD") it.toLowerCase else it»", «if (it == "ADD") it.toLowerCase else it»)
		«ENDIF»«ENDFOR»
		«IF hasMerge»
		val merge = Lists.newArrayList
		«ENDIF»
		«IF hasReturn»for(it : ctx.children) {«ELSE»ctx.children.forEach [«ENDIF»
			if (it instanceof RuleContext) {
				switch it.invokingState {
					«FOR it : elementList»
						«val atom = it.body»
						«IF atom instanceof Atom»
							«val ref = atom.body»
							«IF ref instanceof RuleRef»
								«val invokingState = r.getInvokingState(it)»
								«IF it.op != null»
									case «invokingState»: {
										«IF it.op == "RETURN"»
											return it.visit
										«ELSE»
											«if(it.op == "MERGE") it.op.toLowerCase else it.op» += it.visit
										«ENDIF»
									}
								«ENDIF»
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				}
			} else if (it instanceof TerminalNode) {
				«var firstIf = true»
				«FOR it : elementList»
					«val atom = it.body»
					«IF atom instanceof Atom»
						«val ref = atom.body»
						«IF ref instanceof Terminal»
							«IF it.op != null»
								«try {
									clazz.getField(it.op)
									'''
									«if (firstIf) {firstIf = false; ""} else "else "»if (it.symbol.type == «_grammarName»Parser.«it.terminalName») {
										«it.op» += it.text
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
		«IF hasReturn»}«ELSE»]«ENDIF»
		«IF hasMerge»val node = «ENDIF»map«IF r.type != null».castTo(«r.type.name»)«ENDIF»
		«IF hasMerge»
		merge.forEach[node.merge(it.castTo(«r.type.name»))]
		node
		«ENDIF»
	'''}

	def getReferenceReturnType(Element r) {
		val ref = (r.body as Atom).body
		if (ref instanceof RuleRef) {
			if (ref.reference.type != null) {
				ref.reference.type.name
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

	def makeListMethodBody(ParserRule r, String itemClassName) {
		val annotationList = Sets.newHashSet
		val elementList = r.eAllContents.filter(Element).toList
		val hasMerge = elementList.findFirst[ it.op != null && it.op == "MERGE" ] != null
		val hasReturn = elementList.findFirst[ it.op != null && it.op == "RETURN" ] != null
		elementList.forEach[
			if(it.op != null){
				annotationList += it.op
			}
		]
		
	'''
		val map = Maps.newHashMap
		val none = Lists.newArrayList
		map.put("none", none)
		«FOR it : annotationList»«IF it != "MERGE" && it != "RETURN"»
		val «if (it == "ADD") it.toLowerCase else it» = Lists.newArrayList
		map.put("«if (it == "ADD") it.toLowerCase else it»", «if (it == "ADD") it.toLowerCase else it»)
		«ENDIF»«ENDFOR»
		«IF hasMerge»
		val merge = Lists.newArrayList
		«ENDIF»
		if (ctx.children != null) {
			«IF hasReturn»for (it : ctx.children) {«ELSE»ctx.children.forEach [«ENDIF»
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
											«if(it.op == "ADD" || it.op == "MERGE") it.op.toLowerCase else it.op» += it.visit
										}
									«ENDIF»
								«ENDIF»
							«ENDIF»
						«ENDFOR»
					}
				}
			«IF hasReturn»}«ELSE»]«ENDIF»
		}
		«IF hasMerge»val node = «ENDIF»map«IF r.type != null».castTo«IF !hasMerge»List«ENDIF»(«itemClassName»)«ENDIF»
		«IF hasMerge»
		merge.castToList(«itemClassName»).forEach[it.merge(node)]
		merge
		«ENDIF»
	'''
	}

	def makeStringMethodBody(ParserRule r) '''
		val map = Maps.newHashMap
		val none = Lists.newArrayList
		map.put("none", none)
		if (ctx.children != null) {
			ctx.children.forEach [
				none += it.visit
			]
		}
		map
	'''


	def makeLiteralMethod(ParserRule r) '''
		«val methodName = "visit" + r.name.toCamelCase»
		override public «methodName»(«_grammarName»Parser.«r.name.toCamelCase»Context ctx) {
			val text = ctx.children.findFirst[
				if (it instanceof TerminalNodeImpl) {
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
			«IF r.type.name == "UniIntLiteral"»
				return new UniIntLiteral(Integer.parseInt(text))
			«ELSEIF r.type.name == "UniBoolLiteral"»
				return new UniBoolLiteral(Boolean.parseBoolean(text))
			«ELSEIF r.type.name == "UniDoubleLiteral"»
				return new UniDoubleLiteral(Double.parseDouble(text))
			«ELSEIF r.type.name == "UniStringLiteral"»
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
