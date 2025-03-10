package com.app.design_pattern.ObserverPatternSwing.src.com.globalsoftwaresupport;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {		
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

				new MainFrame();
			}
		});
	}
}
