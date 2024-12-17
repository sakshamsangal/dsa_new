package com.app.design_pattern.VisitorPatternSolution.src.com.globalsoftwaresupport;

public class Rectangle implements Shape {

	@Override
	public void accept(Visitor visitor) {
		visitor.visitRectangle(this);
	}
}
