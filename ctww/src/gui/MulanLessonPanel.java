package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mgr.TextBean;
import mgr.TextMgr;

public class MulanLessonPanel extends JPanel {
	String background = "images\\md_town.jpg";
	private TextBean textBean;
	private TextMgr textMgr;
	private JTextArea textPane = new JTextArea(36, 24);
	private JLabel illustraion = new JLabel();

	public MulanLessonPanel() {
		this.setMaximumSize(new Dimension(1344, 840));
		this.setMinimumSize(new Dimension(1344, 840));
		this.setPreferredSize(new Dimension(1344, 840));
		//this.addMouseListener(this);
		//this.setLayout(new GridLayout(2 ,2));
		loadPanel();
		
		/*
		this.setFont(new Font("", Font.BOLD, 36));
		this.add(this.textPane);
		this.add(new JLabel("木兰教我"));
		this.add(new JLabel("学中文"));
		this.add(this.illustraion);
		*/
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(null);
		
		JLabel bkgrd = new JLabel(new ImageIcon("images\\md_town.jpg"));
		add(bkgrd);
		textPane.getLineWrap();
		textPane.setLineWrap(true);
		add(textPane);
		add(illustraion);
		 
        Insets insets = this.getInsets();
        Dimension size = /*bkgrd.getPreferredSize();
        bkgrd.setBounds(0 + insets.left, 0 + insets.top,
                size.width, size.height);*/
        
        size = textPane.getPreferredSize();
        textPane.setBounds(50 + insets.left, 50 + insets.top,
                     size.width, size.height);
        textPane.setFont(new Font("", Font.BOLD, 36));
        size = illustraion.getPreferredSize();
        illustraion.setBounds(455 + insets.left, 40 + insets.top,
                     size.width, size.height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bkImg = new ImageIcon("images\\md_town.jpg").getImage();
		g.drawImage(bkImg, 0, 0, null);
		
		if (textBean != null) {
			
		}
		
	}
	
	//command method
	public void loadPanel() {
		textMgr = new TextMgr();
		this.textBean = (TextBean) textMgr.prepareBean();
		
		this.textPane.setText(textBean.getText());
		this.illustraion.setIcon(textBean.getImage());
		//repaint();
	}
}
