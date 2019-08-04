package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class BackgroundImage extends JDesktopPane{
	
	protected void paintComponent(Graphics g) {

		Image img = new ImageIcon(this.getClass().getResource("afb95706e77169b2aa46941418c8d0f0.jpg")).getImage();
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
		Date date = new Date();
				
		g.drawImage(img, 0, 0, this);

		g.setFont(new Font("Verdana", Font.BOLD, 50));
		g.setColor(Color.WHITE);
		g.drawString(date.toString(), (int) d.getWidth() / 4, (int) d.getHeight() / 2);
		
		repaint();
	}
}
