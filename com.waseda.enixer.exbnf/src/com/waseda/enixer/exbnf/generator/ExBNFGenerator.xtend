/*
 * generated by Xtext
 */
package com.waseda.enixer.exbnf.generator

import com.waseda.enixer.exbnf.exBNF.ElementWithDollar
import com.waseda.enixer.exbnf.exBNF.Grammar
import com.waseda.enixer.exbnf.exBNF.ParserRule
import com.waseda.enixer.exbnf.exBNF.RuleRef
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import java.lang.reflect.Type
import java.lang.reflect.ParameterizedType
import net.unicoen.node.UniNode
import com.waseda.enixer.exbnf.exBNF.Atom
import com.waseda.enixer.exbnf.exBNF.Terminal
import java.util.regex.Pattern
import java.io.File

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class ExBNFGenerator implements IGenerator {
	private String _grammarName
	private int _indent;
	private File file = new File("../Junicoen/src/main/java/net/unicoen/parser/Java8Parser.java")

	override def doGenerate(Resource resource, IFileSystemAccess fsa) {
		val g4Generator = new ANTLRGrammarGenerator(fsa)
		val testGenerator = new MapperTestGenerator(fsa)
		resource.allContents.filter(Grammar).forEach [
			_grammarName = it.name.toCamelCase
			g4Generator.generate(_grammarName, it);
			fsa.generateFile(_grammarName + "Mapper.xtend", it.generateMapper)
			testGenerator.generate(_grammarName, it)
		]
	}

	def generateImports() '''package net.unicoen.mapper

import java.io.FileInputStream
import java.util.ArrayList
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode
import net.unicoen.parser.«_grammarName»Lexer
import net.unicoen.parser.«_grammarName»Parser
import net.unicoen.parser.«_grammarName»BaseVisitor
import net.unicoen.node.*
'''

	def generateMapper(Grammar g) {
		val sb = new StringBuilder
		sb.nl(generateImports)
		_indent = 0;

		sb.nl('''class «_grammarName»Mapper extends «_grammarName»BaseVisitor<Object> {''')
		sb.nl('''var _isDebugMode = false''')
		sb.nl
		sb.nl('''new(boolean isDebugMode) {''')
		sb.nl('''_isDebugMode = isDebugMode''')
		sb.nl('''}''')
		sb.nl
		sb.nl('''def parseFile(String path) {''')
		sb.nl('''val inputStream = new FileInputStream(path)''')
		sb.nl('''try {''')
		sb.nl('''parseCore(new ANTLRInputStream(inputStream))''')
		sb.nl('''} finally {''')
		sb.nl('''inputStream.close''')
		sb.nl('''}''')
		sb.nl('''}''')
		sb.nl
		sb.nl('''def parse(String code) {''')
		sb.nl('''parseCore(new ANTLRInputStream(code))''')
		sb.nl('''}''')
		sb.nl
		sb.nl('''def parseCore(CharStream chars) {''')
		sb.nl('''val lexer = new «_grammarName»Lexer(chars)''')
		sb.nl('''val tokens = new CommonTokenStream(lexer)''')
		sb.nl('''val parser = new «_grammarName»Parser(tokens)''')
		if (g.rules.size > 0) {
			sb.nl('''val tree = parser.«IF g.root != null»«g.root.root.name»«ELSE»«g.rules.get(0).name»«ENDIF»''')
			sb.nl
			sb.nl('''tree.visit''')
		}
		sb.nl('''}''')
		sb.nl
		sb.nl('''override public visitChildren(RuleNode node) {''')
		sb.nl('''val n = node.childCount;''')
		sb.nl('''(0 ..< n).fold(defaultResult) [ acc, i |''')
		sb.nl('''if (!node.shouldVisitNextChild(acc)) {''')
		sb.nl('''acc''')
		sb.nl('''} else {''')
		sb.nl('''val c = node.getChild(i)''')
		sb.nl('''val childResult = c.visit''')
		sb.nl('''acc.aggregateResult(childResult)''')
		sb.nl('''}''')
		sb.nl(''']''')
		sb.nl('''}''')
		sb.nl
		sb.nl('''override public visit(ParseTree tree) {''')
		sb.nl('''if (_isDebugMode) {''')
		sb.nl('''if (!(tree instanceof ParserRuleContext)) {''')
		sb.nl('''return visitTerminal(tree as TerminalNode)''')
		sb.nl('''}''')
		sb.nl('''val ruleName = «_grammarName»Parser.ruleNames.get((tree as ParserRuleContext).ruleIndex)''')
		sb.nl('''println("*** visit" + ruleName + " ***")''')
		sb.nl('''println(tree.text)''')
		sb.nl('''val ret = tree.accept(this)''')
		sb.nl('''println("returned: " + ret)''')
		sb.nl('''ret''')
		sb.nl('''} else {''')
		sb.nl('''tree.accept(this)''')
		sb.nl('''}''')
		sb.nl('''}''')
		sb.nl
		g.rules.filter(ParserRule).forEach [
			if (it.type != null) {
				if (it.type.list.bind.endsWith("Literal")) {
					sb.append(it.makeLiteralMethod)
				} else {
					sb.append(it.makeVisitMethod)
				}
			}
		]
		sb.nl('}')
		sb.toString
	}

	def toCamelCase(String str) {
		Character.toUpperCase(str.charAt(0)) + str.substring(1)
	}

	def makeVisitMethod(ParserRule r) {
		val sb = new StringBuilder
		val ruleName = r.name.toCamelCase
		sb.nl('''override public visit«ruleName»(«_grammarName»Parser.«ruleName»Context ctx) {''')
		val typeName = r.type.list.bind
		if (typeName.startsWith("Uni")) {
			val packagePrefix = UniNode.package.name + '.'
			sb.append(r.makeMethodBody(Class.forName(packagePrefix + typeName)))
		} else if (typeName.startsWith("List")) {
			val itemClassName = typeName.substring(typeName.indexOf('<') + 1, typeName.indexOf('>'))
			sb.append(r.makeListMethodBody(itemClassName))
		} else if (typeName.equals("String")) {
			sb.append(r.makeStringMethodBody)
		} else {
			die("Unknown Class Name: " + typeName)
		}
		sb.nl('''}''')
		sb.nl
		sb
	}

	def makeCaseStatement(ElementWithDollar obj, String fieldTypeName, String fieldName, StringBuilder sb,
		String returnType) {
		if (!obj.isAtom) {
			die("Internal error: " + obj.body.body)
		}
		val rule = obj.eAllContents.filter(RuleRef).head
		if (rule != null) {
			val ruleName = rule.reference.name.toCamelCase
			if (fieldTypeName.contains("List")) {
				sb.nl('''case «_nonTerminalId»: {''')
				val refType = obj.referenceReturnType
				if (refType == null) {
					die("Rule " + ruleName + " does not have return type.")
				}
				if (refType.contains("List")) {
					sb.nl('''if (bind.«fieldName» == null) {''')
					sb.nl('''bind.«fieldName» = it.visit as «fieldTypeName»''')
					sb.nl('''} else {''')
					sb.nl('''bind.«fieldName» += it.visit as «fieldTypeName»''')
					sb.nl('''}''')
				} else {
					sb.nl('''if (bind.«fieldName» == null) {''')
					sb.nl('''bind.«fieldName» = new ArrayList<«refType»>''')
					sb.nl('''}''')
					sb.nl('''bind.«fieldName» += it.visit as «fieldTypeName»''')
				}
				sb.nl('''}''')
			} else {
				sb.nl('''case «_nonTerminalId»: {''')
				sb.nl('''bind.«fieldName» = it.visit as «fieldTypeName»''')
				sb.nl('''}''')
			}
			return
		}
		die("Unreach")
	}

	def makeMethodBody(ParserRule r, Class<?> clazz) {
		val sb = new StringBuilder
		sb.nl('''val bind = new «r.type.list.bind»''')
		if (r.type.list.ret != null) {
			sb.append('''val ret = new «r.type.list.ret»''')
		}
		sb.nl('''ctx.children.forEach [''')
		sb.nl('''if (it instanceof RuleContext) {''')
		sb.nl('''switch (it as RuleContext).invokingState {''')
		val list = r.eAllContents.filter(ElementWithDollar)
		list.forEach [
			if (it.op == null) {
				return
			}
			if (it.op.equals("MERGE")) {
				if (!r.type.list.bind.equals(it.referenceReturnType)) {
					die("Expected return type: " + r.type.list.bind + " actual type: " + it.referenceReturnType)
				}
				sb.nl('''case «r.getInvokingState(it)»: {''')
				sb.nl('''val child = it.visit as «r.type.list.bind»''')
				sb.nl('''bind.merge(child)''')
				sb.nl('''}''')
				return
			}
			if (it.op.equals("RETURN")) {
				sb.nl('''case «_nonTerminalId»: {''')
				sb.nl('''bind = it.visit as «r.type.list.ret»''')
				sb.nl('''}''')
				return
			}
			try {
				val field = clazz.getField(it.op)
				val fieldTypeName = field.genericType.typeName
				it.makeCaseStatement(fieldTypeName, it.op, sb, r.type.list.bind)
			} catch (NoSuchFieldException e) {
				die("No such Field: " + it.op)
			}
		]
		sb.nl('''}''')
		sb.nl('''}''')
		sb.nl(''']''')
		if (r.type.list.ret != null) {
			sb.nl('''if (ret != null) {''')
			sb.nl('''return ret''')
			sb.nl('''}''')
		}
		sb.nl('''bind''')
	}

	def getReferenceReturnType(ElementWithDollar r) {
		if (r.body.body instanceof Atom) {
			val atom = r.body.body as Atom
			if (atom.body instanceof RuleRef) {
				val ref = atom.body as RuleRef
				if (ref.reference.type != null) {
					ref.reference.type.list.bind
				}
			}
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
		val sb = new StringBuilder
		sb.nl('''val list = new ArrayList<«itemClassName»>''')
		sb.nl('''if (ctx.children != null) {''')
		sb.nl('''ctx.children.forEach [''')
		sb.nl('''switch (it) {''')
		val list = r.eAllContents.filter(ElementWithDollar)
		list.forEach [
			if (it.op == null) {
				return
			}
			if (it.op.equals("ADD")) {
				sb.nl('''case «_nonTerminalId»: {''')
				sb.nl('''list += it.visit as «itemClassName»''')
				sb.nl('''}''')
				return
			}
			if (it.op.equals("APPEND")) {
				if (!r.type.list.bind.equals(it.referenceReturnType)) {
					die("Expected return type: " + r.type.list.bind + " actual type: " + it.referenceReturnType)
				}
				sb.nl('''case «_nonTerminalId»: {''')
				sb.nl('''if (ret == null) {''')
				sb.nl('''ret = it.visit as «r.type.list.bind»''')
				sb.nl('''} else {''')
				sb.nl('''ret += it.visit as «r.type.list.bind»''')
				sb.nl('''}''')
				sb.nl('''}''')
			}

		]
		sb.nl('''}''')
		sb.nl(''']''')
		sb.nl('''}''')
		sb.nl('''list''')
		sb
	}

	def makeStringMethodBody(ParserRule r) {
		val sb = new StringBuilder
		sb.nl('''ctx.text''')
		sb.toString
	}

	def makeLiteralMethod(ParserRule r) {
		val sb = new StringBuilder
		val methodName = "visit" + r.name.toCamelCase
		sb.nl('''override public «methodName»(«_grammarName»Parser.«r.name.toCamelCase»Context ctx) {''')
		sb.nl('''throw new RuntimeException("Unimplemented Method: «methodName»")''')
		sb.nl('''}''')
		sb.nl
		sb.toString
	}

	def die(String message) {
		throw new RuntimeException(message)
	}

	def nl(StringBuilder sb, CharSequence contents) {
		if (Pattern.compile("[}\\]]").matcher(contents).find) {
			_indent--;
		}
		for (var i = 0; i < _indent; i++) {
			sb.append('\t')
		}
		if (Pattern.compile("[{\\[]").matcher(contents).find) {
			_indent++;
		}
		sb.append(contents)
		sb.nl
	}

	def nl(StringBuilder sb) {
		sb.append(System.lineSeparator)
	}

	def isAtom(ElementWithDollar obj) {
		return obj.body.body instanceof Atom
	}
	
	def getInvokingState(ParserRule r, ElementWithDollar e){
		
	}

}
