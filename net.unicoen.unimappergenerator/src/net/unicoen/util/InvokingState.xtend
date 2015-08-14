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
}