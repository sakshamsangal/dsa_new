package com.app.design_pattern.AbstractFactoryPattern;

public class PetrolToyota implements Car {

	@Override
	public void assemble() {
		System.out.println("Assembling an petrol Toyota...");
	}
}
