package com.sample;

import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.CgrammarLexer;
import parser.CgrammarParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String code = "int main(void){int a = 0; if(i==0) a++;}";
		CharStream input = new ANTLRInputStream(code);
		CgrammarLexer lexer = new CgrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CgrammarParser parser = new CgrammarParser(tokens);
		ParseTreeWalker walker = new ParseTreeWalker();

		MyCgrammarListener myListener = new MyCgrammarListener(parser);

		// Parse code and generate a parse tree
		ParserRuleContext tree = parser.translation_unit();

		// Scan the parse tree
		walker.walk(myListener, tree);

		// Show PM counts
		myListener.showTokenCounts();

		// Show Complexity
		myListener.showCyclomaticComplexity();
	}
}
	
