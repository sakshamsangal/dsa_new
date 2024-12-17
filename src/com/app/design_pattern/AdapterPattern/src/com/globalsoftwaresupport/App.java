package com.app.design_pattern.AdapterPattern.src.com.globalsoftwaresupport;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		String[] names = {"Adam", "Kevin", "Ana", "Joe"};
		
		List<String> namesList = Arrays.asList(names);
		
		for(String s : namesList)
			System.out.println(s);
		
		/* Vehicle bus = new Bus();
		Vehicle car = new Car();
		Vehicle bicycle = new BicycleAdapter(new Bicycle());
		
		bus.accelerate();
		car.accelerate();
		bicycle.accelerate(); */
	}
}
