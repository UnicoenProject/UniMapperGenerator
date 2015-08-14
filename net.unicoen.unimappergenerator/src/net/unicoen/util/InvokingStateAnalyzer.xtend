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
			val pos = code.indexOf('''«ruleName»() throws''')
			val list = new ArrayList<InvokingState>
			rule.eAllContents.filter(Element).forEach [ element |
				if (element.op == null) {
					return
				}
				val body = (element.body as Atom).body
				if (body instanceof RuleRef) {
					val refName = body.reference.name
					val i = code.indexOf(refName, pos)
					val start = code.lastIndexOf('(', i)
					val last = code.indexOf(')', start)
					val state = Integer.valueOf(code.substring(start + 1, last))
					list.add(new InvokingState(body.reference.name, state))
				}
			]
			invokingStates.put(ruleName, list)
		]
	}

	public def getInvokingState(ParserRule rule, Element element) {
		val atom = element.body
		if (atom instanceof Atom) {
			val ref = atom.body
			if (ref instanceof RuleRef) {
				val ruleName = rule.name
				val states = invokingStates.get(ruleName)
				val refName = ref.reference.name
				for(state:states){
					if(state.isName(refName)){
						return state.invokingState
					}
				}
			}
		}
	}
}