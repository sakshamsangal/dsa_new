package com.app.design_pattern.AdapterPattern.src.com.globalsoftwaresupport;

public class Car implements Vehicle {

	@Override
	public void accelerate() {
		System.out.println("Car is accelerating...");
	}
}
