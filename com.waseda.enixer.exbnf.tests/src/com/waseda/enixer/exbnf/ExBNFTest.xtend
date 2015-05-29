package com.waseda.enixer.exbnf

import org.eclipse.xtext.junit4.XtextRunner
import com.waseda.enixer.exbnf.ExBNFInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import com.waseda.enixer.exbnf.exBNF.Grammar
import org.junit.Test
import static org.junit.Assert.*

@InjectWith(ExBNFInjectorProvider)
@RunWith(XtextRunner)
class ExBNFTest {
	@Inject
	ParseHelper<Grammar> parser

	@Test
	def void parseExtendedExpression() {
		val grammar = parser.parse("grammar Expression;

program => UniClassDec:
	classModifiers$modifiers CLASS name$className LEFTBRACE
	methodDeclaration*$members RIGHTBRACE EOF;

classModifiers => List<String>:
	classVisibility? abs? stat?;

classVisibility => String:
	PUBLIC | PRIVATE;

abs => String:
	ABSTRACT;

stat => String:
	STATIC;

methodDeclaration => UniMethodDec:
	methodModifiers$modifiers type$returnType name$methodName LEFTPAREN
	methodArguments?$args RIGHTPAREN methodBody$block;

methodModifiers => List<String>:
	methodVisibility? fin? abs? stat?;

fin => String:
	FINAL;

methodVisibility => String:
	PUBLIC | PROTECTED | PACKAGE | PRIVATE;

methodArguments => List<UniArg>:
	methodArgument ( COMMA methodArgument )*;

methodArgument => UniArg:
	type$type name$name;

methodBody => UniBlock:
	LEFTBRACE statement* RIGHTBRACE;

name => String:
	ID*;

type => String:
	VOID | INT | DOUBLE;

statement:
	ifStatement | variableDeclaration | whileStatement;

variableDeclaration => UniVariableDecWithValue:
	type$type name$name EQUAL normalExp$value SEMICOLON;

ifStatement => UniIf:
	IF LEFTPAREN compareExp$cond RIGHTPAREN LEFTBRACE statement*$trueBlock RIGHTBRACE ( ELSE
	LEFTBRACE statement*$falseBlock RIGHTBRACE )?;

whileStatement => UniWhile:
	WHILE LEFTPAREN compareExp$cond RIGHTPAREN LEFTBRACE statement*$block RIGHTBRACE;

expression:
	compareExp | normalExp;

compareExp => UniBinOp:
	normalExp$left compareOp$op normalExp$right;

compareOp:
	LARGER | LARGEROREQUALS | EQUALS | SMALLEROREQUALS | SMALLER;

normalExp => UniBinOp:
	term$left ( addSubOp$op term$right )*;

term => UniBinOp:
	factor$left ( mulDivOp$op factor$right )*;

factor:
	number | LEFTPAREN normalExp RIGHTPAREN;

number:
	integer | decimal;

integer => UniIntLiteral:
	ZERO | NONZERODIGIT digit*;

decimal => UniDoubleLiteral:
	NONZERODIGIT digit* DOT digit* | ZERO DOT digit*;

mulDivOp:
	MUL | DIV;

addSubOp:
	ADD | SUB;

digit:
	ZERO | NONZERODIGIT;

LEFTPAREN:
	'(';

RIGHTPAREN:
	')';

ZERO:
	'0';

NONZERODIGIT:
	'1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';

ADD:
	'+';

SUB:
	'-';

MUL:
	'*';

DIV:
	'/';

DOT:
	'.';

LARGER:
	'>';

LARGEROREQUALS:
	'>=';

EQUALS:
	'==';

SMALLEROREQUALS:
	'<=';

SMALLER:
	'<';

IF:
	'if';

ELSE:
	'else';

LEFTBRACE:
	'{';

RIGHTBRACE:
	'}';

ID:
	[a-zA-Z];

SEMICOLON:
	';';

CLASS:
	'class';

VOID:
	'void';

EQUAL:
	'=';

INT:
	'int';

DOUBLE:
	'double';

PUBLIC:
	'public';

PRIVATE:
	'private';

ABSTRACT:
	'abstract';

PROTECTED:
	'protected';

PACKAGE:
	'package';

STATIC:
	'static';

FINAL:
	'final';

COMMA:
	',';

WHILE:
	'while';

WS:
	[ \t\r\n\u000C]+ -> skip;

		")
		val name = grammar.rules.get(0).name
		assertEquals(name, "program")
	}

}