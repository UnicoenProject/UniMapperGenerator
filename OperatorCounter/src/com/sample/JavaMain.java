package com.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.JavaParser;
import parser.JavaLexer;

public class JavaMain {

	public static void main(String[] args) {
		System.out.print("Input target file: ");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.next();
		sc.close();
		File file = new File(filePath);
		StringBuilder builder = new StringBuilder();
		try {
			Scanner fsc = new Scanner(file);
			while (fsc.hasNextLine())
				builder.append(fsc.nextLine()).append(
						System.getProperty("line.separator"));
			fsc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found!");
			return;
		}
		CharStream input = new ANTLRInputStream(builder.toString());
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
