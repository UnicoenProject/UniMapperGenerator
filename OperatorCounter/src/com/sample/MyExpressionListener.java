package com.sample;

import java.util.HashMap;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import parser.ExpressionBaseListener;
import parser.ExpressionLexer;
import parser.ExpressionParser;
import parser.ExpressionParser.AtomContext;
import parser.ExpressionParser.ExpressionContext;
import parser.ExpressionParser.IntegerContext;
import parser.ExpressionParser.MatomContext;
import parser.ExpressionParser.TermContext;

public class MyExpressionListener extends ExpressionBaseListener {
  private ExpressionParser _parser;
  private HashMap<String, Integer> _map;

  public MyExpressionListener(ExpressionParser parser) {
    _parser = parser;
    _map = new HashMap<String, Integer>();
  }

  public void showTokenCounts() {
    System.out.println("*** showTokenCounts ***");
    for (Entry<String, Integer> nameAndCount : _map.entrySet()) {
      String name = nameAndCount.getKey();
      int count = nameAndCount.getValue();
      System.out.println(name + ": " + count);
    }
  }

  @Override
  public void enterExpression(ExpressionContext ctx) {
    System.out.println("*** enterExpression ***");
    if (ctx.getChildCount() > 1) {
      // if expression is term PM expression

      // term (Non-terminal)
      TermContext term = (TermContext) ctx.getChild(0);
      String termName = ExpressionParser.ruleNames[term.getRuleIndex()];
      System.out.print(termName + ": " + term.getText() + ", ");

      // PM (Terminal)
      TerminalNodeImpl pm = (TerminalNodeImpl) ctx.getChild(1);
      Token pmToken = pm.symbol;
      String tokenName = ExpressionLexer.ruleNames[pmToken.getType() - 1];
      System.out.print(tokenName + ": " + pmToken.getText() + ", ");

      // expression (Non-terminal)
      ExpressionContext expression = (ExpressionContext) ctx.getChild(2);
      String expressionName = ExpressionParser.ruleNames[expression.getRuleIndex()];
      System.out.print(expressionName + ": " + expression.getText() + ", ");
      System.out.println();
    } else {
      // if expression is term
    }
  }

  @Override
  public void visitTerminal(TerminalNode node) {
    System.out.println("*** visitTerminal ***");
    Token token = node.getSymbol();
    String tokenName = ExpressionLexer.ruleNames[token.getType() - 1];
    System.out.println(tokenName + ": " + token.getText());

    // Count tokens
    Integer value = _map.get(tokenName);
    value = value == null ? 0 : value;
    _map.put(tokenName, value + 1);
  }

  @Override
  public void exitExpression(ExpressionContext ctx) {
    // TODO Auto-generated method stub
    super.exitExpression(ctx);
  }

  @Override
  public void enterAtom(AtomContext ctx) {
    // TODO Auto-generated method stub
    super.enterAtom(ctx);
  }

  @Override
  public void exitAtom(AtomContext ctx) {
    // TODO Auto-generated method stub
    super.exitAtom(ctx);
  }

  @Override
  public void enterInteger(IntegerContext ctx) {
    // TODO Auto-generated method stub
    super.enterInteger(ctx);
  }

  @Override
  public void exitInteger(IntegerContext ctx) {
    // TODO Auto-generated method stub
    super.exitInteger(ctx);
  }

  @Override
  public void enterTerm(TermContext ctx) {
    // TODO Auto-generated method stub
    super.enterTerm(ctx);
  }

  @Override
  public void exitTerm(TermContext ctx) {
    // TODO Auto-generated method stub
    super.exitTerm(ctx);
  }

  @Override
  public void enterMatom(MatomContext ctx) {
    // TODO Auto-generated method stub
    super.enterMatom(ctx);
  }

  @Override
  public void exitMatom(MatomContext ctx) {
    // TODO Auto-generated method stub
    super.exitMatom(ctx);
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    // TODO Auto-generated method stub
    super.enterEveryRule(ctx);
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    // TODO Auto-generated method stub
    super.exitEveryRule(ctx);
  }

  @Override
  public void visitErrorNode(ErrorNode node) {
    // TODO Auto-generated method stub
    super.visitErrorNode(node);
  }

}
