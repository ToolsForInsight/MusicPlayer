package application;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class SimpleGUI1 {
	
	JFrame frame;
	JLabel label;
	
	int topLeftX = 0;
	int topLeftY = 0;
	int animationSpeed = 1;

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
		
		while (topLeftX < 500 &&
			   topLeftY < 500 ) {
			
			myPanel.repaint();
			
			try {
				Thread.sleep(50);
			} catch (Exception ex){};
			
			topLeftX += animationSpeed;
			topLeftY += animationSpeed;
		}
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
	
	public class MyDrawPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			
			Graphics2D g2d = (Graphics2D)g;
			
			Color startColor = new Color((int)(Math.random()*256),
										 (int)(Math.random()*256),
										 (int)(Math.random()*256));
			Color endColor = new Color((int)(Math.random()*256),
					 				   (int)(Math.random()*256),
					 				   (int)(Math.random()*256));
			
			GradientPaint gradient = new GradientPaint(topLeftX,topLeftY,startColor,
													   topLeftX+40,topLeftY+40,endColor);
			g2d.setPaint(gradient);
			g2d.fillOval(topLeftX, topLeftY, 40, 40);
		}
	}
}
