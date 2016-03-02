package net.unicoen.util

import java.util.HashMap
import java.util.List
import net.unicoen.uniMapperGenerator.Atom
import net.unicoen.uniMapperGenerator.Element
import net.unicoen.uniMapperGenerator.Grammar
import net.unicoen.uniMapperGenerator.ParserRule
import net.unicoen.uniMapperGenerator.RuleRef

class InvokingStateAnalyzer {
	private val invokingStates = new HashMap<String, List<Integer>>
	private val invokingStateIndexes = new HashMap<String, Integer>

	public new(String code, Grammar g) {
		g.eAllContents.filter(ParserRule).forEach [ rule |
			if (rule.hasNoAnnotations) {
				return
			}
			val ruleName = rule.name
			var pos = code.indexOf('''«ruleName»() throws''')
			val list = newArrayList
			val trypos = code.indexOf("try", pos)
			val hasLeftRecursion = code.substring(pos, trypos).contains("enterRecursionRule")
			var recursionState = -1;
			if (hasLeftRecursion) {
				val start = code.indexOf("int _startState = ", pos)
				val last = code.indexOf(";", start)
				val str = code.substring(start + 18, last)
				recursionState = Integer.parseInt(str)
			}
			for (element : rule.eAllContents.filter(Element).toList) {
				val atom = element.body
				if (atom instanceof Atom) {
					val ref = atom.body
					if (ref instanceof RuleRef) {
						if (ref.reference == rule && hasLeftRecursion) {
							list.add(recursionState)
						} else {
							val refName = ref.reference.name
							pos = code.indexOf('''«refName»(''', pos)
							val start = code.lastIndexOf("setState(", pos)
							val last = code.indexOf(')', start)
							val str = code.substring(start + 9, last)
							val state = Integer.parseInt(str)
							list.add(state)
							pos++
						}
					}
				}
			}
			invokingStates.put(ruleName, list)
			invokingStateIndexes.put(ruleName, 0)
		]
	}

	public def getInvokingState(ParserRule rule) {
		val ruleName = rule.name
		val states = invokingStates.get(ruleName)
		if (!states.isEmpty) {
			val index = invokingStateIndexes.get(ruleName)
			invokingStateIndexes.put(ruleName, (index + 1) % states.size)
			return states.get(index)
		}
		throw new Exception("Cannot use getInvokingState for not RuleRef objects")
	}

	private def hasNoAnnotations(ParserRule rule) {
		rule.type == null && rule.eAllContents.filter(Element).findFirst[it.op != null] == null
	}
}
