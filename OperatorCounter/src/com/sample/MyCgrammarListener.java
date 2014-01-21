package com.sample;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.CgrammarBaseListener;
import parser.CgrammarLexer;
import parser.CgrammarParser;

public class MyCgrammarListener extends CgrammarBaseListener {
	private CgrammarParser _parser;
	private HashMap<String, Integer> _map;
	private Set<String> ruleElementSet;
	private Set<String> terminalElementSet;

	public MyCgrammarListener(CgrammarParser parser) {
		_parser = parser;
		_map = new HashMap<String, Integer>();
		ruleElementSet = new HashSet<String>();
		terminalElementSet = new HashSet<String>();
		File countElementsFile = new File("dat\\CountElements.dat");
		try {
			Scanner scanner = new Scanner(countElementsFile);
			while (scanner.hasNext()) {
				String element = scanner.next();
				if (Character.isLowerCase(element.charAt(0)))
					ruleElementSet.add(element);
				if (Character.isUpperCase(element.charAt(0)))
					terminalElementSet.add(element);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		Token token = node.getSymbol();
		String tokenName = CgrammarLexer.ruleNames[token.getType() - 1];
		if (terminalElementSet.contains(tokenName)) {
			System.out.println("*** visitTerminal ***");
			System.out.println(tokenName + ": " + token.getText());

			// Count tokens
			Integer value = _map.get(tokenName);
			value = value == null ? 0 : value;
			_map.put(tokenName, value + 1);
		}
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		String ruleName = CgrammarParser.ruleNames[ctx.getRuleIndex()];
		if (ruleElementSet.contains(ruleName)) {
			System.out.println("*** visitRule ***");
			System.out.println(ruleName + ": " + ctx.getText());

			Integer value = _map.get(ruleName);
			value = value == null ? 0 : value;
			_map.put(ruleName, value + 1);
		}
	}
}
