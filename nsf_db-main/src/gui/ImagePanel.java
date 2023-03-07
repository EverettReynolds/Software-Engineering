package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	JLabel label = new JLabel();
	
	public ImagePanel() {
		
		try {
			BufferedImage image = ImageIO.read(new File("images/MeasureImage.png"));
			label.setIcon(new ImageIcon(image));
			this.add(label);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public void updateLabel(String address) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(address));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label.setIcon(new ImageIcon(image));

	}
}
