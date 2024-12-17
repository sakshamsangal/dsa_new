package com.app.design_pattern.VisitorPattern;

public interface ShoppingItem {
	public double accept(ShoppingCartVisitor visitor);
}
