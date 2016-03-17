package application;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class SimpleGUI1 implements ActionListener {
	
	JFrame frame;
	JButton button;
	MyDrawPanel myPanel;

	public static void main(String[] args) {
		
		SimpleGUI1 gui = new SimpleGUI1();
		gui.go();
	}
	
	public void go() {
		
		frame = new JFrame();
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quit app upon close window
		
		button = new JButton("Click me to change the above color gradient");
		frame.getContentPane().add(button);
		button.addActionListener(this);
		button.setBounds(0, 150, 300, 130);
		
		myPanel = new MyDrawPanel();
		frame.getContentPane().add(myPanel);
		
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent event) {
		
		frame.repaint();
	}
}
