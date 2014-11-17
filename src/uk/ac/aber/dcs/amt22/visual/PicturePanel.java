package uk.ac.aber.dcs.amt22.visual;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	private BufferedImage pirateShip;

	public PicturePanel() {
		try {
			this.pirateShip = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("res/pirate0.png")); //TODO try and allow a number of images
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * paint the image
	 */
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(pirateShip, 0, 0, this); //throw picture at 0, 0 position
	}
}
