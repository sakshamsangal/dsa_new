package com.app.design_pattern.VisitorPattern;

public interface ShoppingCartVisitor {
	public double visit(Table table);
	public double visit(Chair chair);
}
