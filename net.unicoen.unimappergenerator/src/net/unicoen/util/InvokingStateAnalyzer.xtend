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
	private val invokingStates = new HashMap<String, List<InvokingState>>

	public new(String code, Grammar g) {
		g.eAllContents.filter(ParserRule).forEach [ rule |
			if (rule.type == null) {
				return
			}
			val ruleName = rule.name
			var pos = code.indexOf('''«ruleName»() throws''')
			val list = new ArrayList<InvokingState>
			for (element : rule.eAllContents.filter(Element).toList) {
				if (element.op != null) {
					val body = (element.body as Atom).body
					if (body instanceof RuleRef) {
						val refName = body.reference.name
						pos = code.indexOf('''«refName»()''', pos)
						val start = code.lastIndexOf('(', pos)
						val last = code.indexOf(')', start)
						val str = code.substring(start + 1, last)
						val state = Integer.parseInt(str)
						list.add(new InvokingState(body.reference.name, state))
						pos++
					}
				}
			}
			invokingStates.put(ruleName, list)
		]
	}

	public def getInvokingState(ParserRule rule, Element element) {
		val body = element.body
		if (body instanceof Atom) {
			val b = body.body
			if (b instanceof RuleRef) {
				val ruleName = rule.name
				val states = invokingStates.get(ruleName)
				for (state : states) {
					if (state.isName(b.reference.name)) {
						states.remove(state)
						return state.invokingState
					}
				}
			}
		}
	}
}