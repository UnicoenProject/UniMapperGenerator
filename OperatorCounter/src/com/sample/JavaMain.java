package com.sample;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.JavaParser;
import parser.JavaLexer;

public class JavaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String code = "int main(void){int a = 0; if(i==0) a++;}";
		CharStream input = new ANTLRInputStream(code);
		JavaLexer lexer = new JavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParseTreeWalker walker = new ParseTreeWalker();

		JavaExtractor extractor = new JavaExtractor(parser);

		// Parse code and generate a parse tree
		ParserRuleContext tree = parser.compilationUnit();

		// Scan the parse tree
		walker.walk(extractor, tree);

		// Show PM counts
		extractor.showTokenCounts();

		// Show Complexity
		extractor.showCyclomaticComplexity();
	}
}
	
