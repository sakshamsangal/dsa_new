package com.app.design_pattern.strategy.operation;

import com.app.design_pattern.strategy.Strategy;

public class Substraction implements Strategy {

	@Override
	public void execute(int num1, int num2) {
		System.out.println(num1 - num2);
	}
}
