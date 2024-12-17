package com.app.design_pattern.InterfaceSegregationPrincipleExample.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		ICEO ceo = new CEO();
		
		ceo.addBonus();
		ceo.salary();
		ceo.makeDecisions();
		ceo.addStocks();
		
	}
}
