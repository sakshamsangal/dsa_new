package com.app.design_pattern.strategy;

import com.app.design_pattern.strategy.operation.Multiplication;

public class App {

	public static void main(String[] args) {
		
		OperationManagerBAD manager = new OperationManagerBAD();
		manager.execute(new Multiplication(), 10, 5);
		
	}
}
