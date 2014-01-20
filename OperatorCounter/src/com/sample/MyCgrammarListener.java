package com.sample;

import java.util.HashMap;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import parser.CgrammarBaseListener;
import parser.CgrammarLexer;
import parser.CgrammarParser;

public class MyCgrammarListener extends CgrammarBaseListener {
  private CgrammarParser _parser;
  private HashMap<String, Integer> _map;

  public MyCgrammarListener(CgrammarParser parser) {
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
  public void visitTerminal(TerminalNode node) {
    System.out.println("*** visitTerminal ***");
    Token token = node.getSymbol();
    String tokenName = CgrammarLexer.ruleNames[token.getType() - 1];
    System.out.println(tokenName + ": " + token.getText());

    // Count tokens
    Integer value = _map.get(tokenName);
    value = value == null ? 0 : value;
    _map.put(tokenName, value + 1);
  }

}
