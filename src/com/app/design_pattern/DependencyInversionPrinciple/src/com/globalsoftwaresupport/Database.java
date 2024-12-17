package com.app.design_pattern.DependencyInversionPrinciple.src.com.globalsoftwaresupport;

// this is the abstract layer
public interface Database {
	public void connect();
	public void disconnect();
}
