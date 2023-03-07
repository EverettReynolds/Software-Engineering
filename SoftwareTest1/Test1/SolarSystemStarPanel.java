

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SolarSystemStarPanel extends JPanel {
	List<JButton> stars = new ArrayList<JButton>();
	
	public SolarSystemStarPanel() {
		SolarSystemStarIcon icon;
	    JButton btn;
		for (SolarSystemStarEnum e : SolarSystemStarEnum.values()) {
			icon = new SolarSystemStarIcon(e);
			System.out.println(e.toString() + ": " + icon.getRatio()); 
			//+ e.ordinal() / 4 + "," + (e.ordinal() % 4));
			//JOptionPane.showMessageDialog(null, e.toString(), 
			//"Star World", 0, icon);
			btn = new JButton(icon);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			stars.add(btn);
			add(btn);
		}
	}
	
	public static void main(String[] args) {
		JFrame solarSystemFrame = new JFrame("Star World");
		solarSystemFrame.setIconImage(new ImageIcon(
				"WriteIcon.png").getImage());
		SolarSystemStarPanel schP = new SolarSystemStarPanel();
		solarSystemFrame.add(schP, BorderLayout.SOUTH);
		
		JLabel solarSystemLabel = new JLabel(new ImageIcon(
				"order-of-planets-in-the-solar-system.jpg"));
		solarSystemFrame.add(solarSystemLabel, BorderLayout.CENTER);
		solarSystemFrame.pack();
		solarSystemFrame.setVisible(true);
		solarSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
