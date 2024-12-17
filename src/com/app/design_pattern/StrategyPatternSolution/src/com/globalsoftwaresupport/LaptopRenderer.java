package com.app.design_pattern.StrategyPatternSolution.src.com.globalsoftwaresupport;

public class LaptopRenderer implements Renderer {
	
	@Override
	public void showImage() {
		System.out.println("Showing an image on laptop...");
	}
}
