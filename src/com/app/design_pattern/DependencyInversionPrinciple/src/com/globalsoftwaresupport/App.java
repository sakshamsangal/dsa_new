package com.app.design_pattern.DependencyInversionPrinciple.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		DatabaseController controller = new DatabaseController(new OracleDatabase());
		controller.connect();
		controller.disconnect();
		
	}
}
