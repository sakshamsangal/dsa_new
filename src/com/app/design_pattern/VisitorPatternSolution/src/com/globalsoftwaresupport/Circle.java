package com.app.design_pattern.VisitorPatternSolution.src.com.globalsoftwaresupport;

public class Circle implements Shape {

	@Override
	public void accept(Visitor visitor) {
		visitor.visitCircle(this);
	}
}
