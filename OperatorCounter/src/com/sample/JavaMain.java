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
	public static ClassList classList = new ClassList();

	public static void main(String[] args) {
		String filePath = getFilePath();
		execute(filePath);
		classList.showClassList();
	}

	public static String getFilePath() {
		System.out.print("Input target file or directory: ");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.next();
		sc.close();
		return filePath;
	}

	public static void execute(String filePath) {
		File file = new File(filePath);
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			System.out.println(file.getName() + " is a directory.");
			for (File f : children)
				execute(f.getPath());
			return;
		}
		StringBuilder builder = new StringBuilder();
		try {
			Scanner fsc = new Scanner(file);
			while (fsc.hasNextLine())
				builder.append(fsc.nextLine()).append(
						System.getProperty("line.separator"));
			fsc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			return;
		}
		CharStream input = new ANTLRInputStream(builder.toString());
		JavaLexer lexer = new JavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		parser.setErrorHandler(new JavaErrorStrategy());
		ParseTreeWalker walker = new ParseTreeWalker();

		JavaExtractor extractor = new JavaExtractor(parser);

		// Parse code and generate a parse tree
		ParserRuleContext tree = parser.compilationUnit();

		if (tree.exception == null) {
			// Scan the parse tree
			walker.walk(extractor, tree);

			// Show token counts
			// extractor.showTokenCounts();

			// Show Complexity
			// extractor.showCyclomaticComplexity();

		} else {
			System.out.println(file.getName() + " is not a Java file.");
		}
	}
}
