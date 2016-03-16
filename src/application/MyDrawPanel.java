package application;

import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {

	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		Color startColor = new Color((int)(Math.random()*256),
									 (int)(Math.random()*256),
									 (int)(Math.random()*256));
		Color endColor = new Color((int)(Math.random()*256),
				 				   (int)(Math.random()*256),
				 				   (int)(Math.random()*256));
		
		GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, 300, 150);
	}
}
