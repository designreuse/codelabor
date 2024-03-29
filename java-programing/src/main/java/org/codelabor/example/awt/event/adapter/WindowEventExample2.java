package org.codelabor.example.awt.event.adapter;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame("window event example");
		frame.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.out.println("closing");
						System.exit(0);
					}
				}
		);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
