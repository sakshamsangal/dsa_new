package com.app.design_pattern.AbstractFactoryPattern;

public class ElectricToyota implements Car {

	@Override
	public void assemble() {
		System.out.println("Assembling a electric Toyota...");
	}
}
