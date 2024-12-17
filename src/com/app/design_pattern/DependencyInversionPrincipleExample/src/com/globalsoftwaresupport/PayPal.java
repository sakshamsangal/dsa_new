package com.app.design_pattern.DependencyInversionPrincipleExample.src.com.globalsoftwaresupport;

//low level modules
public class PayPal implements PaymentMethod {

	@Override
	public void pay() {
		System.out.println("Paying with PayPal...");
	}
}
