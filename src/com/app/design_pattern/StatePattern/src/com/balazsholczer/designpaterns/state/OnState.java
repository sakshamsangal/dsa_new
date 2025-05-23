package com.app.design_pattern.StatePattern.src.com.balazsholczer.designpaterns.state;

public class OnState implements State{

	@Override
	public void doAction(Context context) {
		System.out.println("This is on state...");
		context.setState(this);
	}

	@Override
	public String toString() {
		return "On state...";
	}
}
