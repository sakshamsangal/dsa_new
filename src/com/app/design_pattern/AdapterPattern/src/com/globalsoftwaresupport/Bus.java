package com.app.design_pattern.AdapterPattern.src.com.globalsoftwaresupport;

public class Bus implements Vehicle {

	@Override
	public void accelerate() {
		System.out.println("Bus is accelerating...");
	}
}
