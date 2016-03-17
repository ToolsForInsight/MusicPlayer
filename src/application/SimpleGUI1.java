package application;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class SimpleGUI1 {
	
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		
		SimpleGUI1 gui = new SimpleGUI1();
		gui.go();
	}
	
	public void go() {
		
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quit app upon close window
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		label = new JLabel("I'm a label");
		
		MyDrawPanel myPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.CENTER, myPanel);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		
		frame.setVisible(true);
		frame.repaint();
	}
	
	class ColorListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			frame.repaint();
		}
	}
	
	class LabelListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			label.setText("Ouch!");
		}
	}
}
