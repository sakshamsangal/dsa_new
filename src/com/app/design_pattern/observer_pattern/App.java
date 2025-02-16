package com.app.design_pattern.observer_pattern;

import com.app.design_pattern.observer_pattern.listner.EmailListener;
import com.app.design_pattern.observer_pattern.subject.Subject;
import com.app.design_pattern.observer_pattern.subject.Movie;

public class App {

	public static void main(String[] args) {
		Subject subject = new Movie();
		subject.addListener(new EmailListener());
	}
}

