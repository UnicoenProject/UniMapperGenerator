package net.unicoen.util

import net.unicoen.uniMapperGenerator.Grammar
import net.unicoen.uniMapperGenerator.ParserRule
import java.util.List
import net.unicoen.uniMapperGenerator.Atom
import net.unicoen.uniMapperGenerator.Element
import java.util.HashMap
import net.unicoen.uniMapperGenerator.RuleRef
import java.util.ArrayList

class InvokingStateAnalyzer {
	private val invokingStates = new HashMap<String, List<Integer>>
	private val invokingStateIndexes = new HashMap<String, Integer>

	public new(String code, Grammar g) {
		g.eAllContents.filter(ParserRule).forEach [ rule |
			if (rule.type == null) {
				return
			}
			val ruleName = rule.name
			var pos = code.indexOf('''«ruleName»() throws''')
			val list = new ArrayList<Integer>
			for (element : rule.eAllContents.filter(Element).toList) {
				val atom = element.body
				if (atom instanceof Atom) {
					val ruleRef = atom.body
					if (ruleRef instanceof RuleRef) {
						val refName = ruleRef.reference.name
						pos = code.indexOf('''«refName»()''', pos)
						val start = code.lastIndexOf('(', pos)
						val last = code.indexOf(')', start)
						val str = code.substring(start + 1, last)
						val state = Integer.parseInt(str)
						list.add(state)
						pos++
					}
				}
			}
			invokingStates.put(ruleName, list)
			invokingStateIndexes.put(ruleName, 0)
		]
	}

	public def getInvokingState(ParserRule rule, Element element) {
		val body = element.body
		if (body instanceof Atom) {
			val b = body.body
			if (b instanceof RuleRef) {
				val ruleName = rule.name
				val states = invokingStates.get(ruleName)
				if (!states.isEmpty) {
					val index = invokingStateIndexes.get(ruleName)
					invokingStateIndexes.put(ruleName, (index + 1) % states.length)
					return states.get(index)
				}
			}
		}
		throw new Exception("Cannot use getInvokingState for not RuleRef objects")
	}
}
