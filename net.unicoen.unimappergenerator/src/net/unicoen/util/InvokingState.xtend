package net.unicoen.util

class InvokingState {
	private String ruleName
	private Integer state

	new(String name, int state) {
		ruleName = name
		this.state = state
	}

	public def isName(String name) {
		if (ruleName == null) {
			return false
		}
		ruleName.equals(name)
	}
	
	public def getInvokingState(){
		state
	}

	override public equals(Object o){
		if(o==null ||!(o instanceof InvokingState)){
			return false
		}
		val object = o as InvokingState
		object.ruleName.equals(ruleName) && object.state.equals(state)
	}
}