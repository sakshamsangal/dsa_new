package com.app.design_pattern.VisitorPatternSolution.src.com.globalsoftwaresupport;

public interface Visitor {
	public void visitCircle(Circle circle);
	public void visitTriangle(Triangle triangle);
	public void visitRectangle(Rectangle rectangle);	
}
