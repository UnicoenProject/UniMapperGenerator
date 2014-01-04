package com.sample;

import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.ExpressionLexer;
import parser.ExpressionParser;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String code = "(1 + 2 + 3) * 4";
    CharStream input = new ANTLRInputStream(code);
    ExpressionLexer lexer = new ExpressionLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExpressionParser parser = new ExpressionParser(tokens);
    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    MyExpressionListener myListener = new MyExpressionListener(parser);

    // Parse code and generate a parse tree
    ParserRuleContext tree = parser.expression();

    // Scan the parse tree
    walker.walk(myListener, tree);

    // Show PM counts
    myListener.showTokenCounts();

    // Show parse tree
    System.out.println(tree.toStringTree(Arrays.asList(ExpressionParser.ruleNames)));
  }
}
