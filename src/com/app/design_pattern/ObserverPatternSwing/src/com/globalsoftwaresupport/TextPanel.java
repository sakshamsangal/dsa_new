package com.app.design_pattern.ObserverPatternSwing.src.com.globalsoftwaresupport;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		add(textArea, BorderLayout.CENTER);
	}

	public void addText() {
		textArea.append("Button clicked!\n");
	}
}
