package application;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1 implements ActionListener {
	
	JButton button;

	public static void main(String[] args) {
		
		SimpleGUI1 gui = new SimpleGUI1();
		gui.go();
	}
	
	public void go() {
		
		JFrame frame = new JFrame();
		
		button = new JButton("click me");
		
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quit app upon close window
		frame.getContentPane().add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		button.setText("I've been clicked!");
	}
}
