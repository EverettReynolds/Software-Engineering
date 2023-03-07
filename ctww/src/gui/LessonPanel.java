package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class LessonPanel extends JComponent {
	String background = "images\\bg_town.jpg";
	String teachImage = "images\\xu_wei.png";
	String canvasImage = "images\\canvas.png";
	String charImage = "images\\char1complete.png";
	Image bkImg, thImg, cvImg, ziImg; 
	int strokeNo = 0;
	
	LessonPanel() {
		bkImg = new ImageIcon(background).getImage();
		thImg = new ImageIcon(teachImage).getImage();
		cvImg = new ImageIcon(canvasImage).getImage();
		ziImg = new ImageIcon(charImage).getImage();
		this.setMaximumSize(new Dimension(1900, 950));
		this.setMinimumSize(new Dimension(1900, 950));
		this.setPreferredSize(new Dimension(1900, 950));
		//this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bkImg, 0, 0, null);
		g.drawImage(thImg, 900, 100, null);
		g.drawImage(cvImg, 100, 100, null);
		g.drawImage(ziImg, 100, 100, null);
		
	}
	
	public void updateImage() {
		if (strokeNo < 6) {
			strokeNo++;
		    System.out.println(strokeNo);
			charImage = "images\\char1stroke" + strokeNo + ".png";
			//ziImg = new ImageIcon(charImage).getImage();
		}
		else {
			charImage = "images\\char1complete.png";
		}
		ziImg = new ImageIcon(charImage).getImage();
		//if (strokeNo == 6) resetImage();
		repaint();
	}
	
	public void resetImage() {
		strokeNo = 0;
		charImage = "images\\char1complete.png";
	}
}
