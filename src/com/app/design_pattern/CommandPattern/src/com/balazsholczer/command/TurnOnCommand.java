package com.app.design_pattern.CommandPattern.src.com.balazsholczer.command;

public class TurnOnCommand implements Command{

	private Light light;
	
	public TurnOnCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		this.light.turnOn();
	}
}
