package com.app.design_pattern.DecoratorPattern.src.com.balazsholczer.decorator;

public class PlainBeverage implements Beverage {

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "";
	}
}
