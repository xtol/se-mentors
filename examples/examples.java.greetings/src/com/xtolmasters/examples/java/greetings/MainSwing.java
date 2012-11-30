package com.xtolmasters.examples.java.greetings;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MainSwing {

	public static final String WINDOW_TITLE = "Greetings";
	
	public static void main(String[] args) {
		JOptionPane pane = new JOptionPane(MainConsole.MESSAGE);
		JDialog dialog = pane.createDialog(WINDOW_TITLE);
		dialog.setVisible(true);
	}

}
