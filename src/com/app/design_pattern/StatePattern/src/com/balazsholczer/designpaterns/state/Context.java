package com.app.design_pattern.StatePattern.src.com.balazsholczer.designpaterns.state;

public class Context {

	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
