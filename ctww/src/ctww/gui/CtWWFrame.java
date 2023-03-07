package ctww.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.CtWWLessonPanel;
import gui.MulanLessonPanel;

public class CtWWFrame extends JFrame {
	private JTabbedPane ctwwWindow;

	public CtWWFrame() {
		super("Chinese the WRITE Way");
		this.setIconImage(new ImageIcon("images/icon.png").getImage());
		Container mainPanel = this.getContentPane();
		mainPanel.setLayout(new GridLayout(1, 1));
	    
		ctwwWindow = new JTabbedPane();
	    Dimension dim = new Dimension(1350, 850);
	    ctwwWindow.setPreferredSize(dim);
	    mainPanel.add(ctwwWindow);
	    addTab(null, null, null);
	    
	    // hard coded for now
	    JPanel panel1 = new JPanel();
	    addButtons(panel1);
	    addTab(panel1, "Mulan", null);
	}
	
	private void addButtons(JPanel panel1) {
		// add 10 buttons, one for a lesson
		JButton btn;
		
		ActionListener alAddTextPane = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addTextPane();
				
			}

			private void addTextPane() {
				MulanLessonPanel textPanel = new MulanLessonPanel();
				ImageIcon icon =  new ImageIcon("images/xu_wei_icon.png");
				ctwwWindow.addTab("第一课", icon, textPanel, "Lesson 1");
				ctwwWindow.setSelectedIndex(1);
				repaint();
			}
			
		};
		for (int i=1; i<=10; i++) {
			btn = new JButton("Lesson " + i);
			btn.addActionListener(alAddTextPane);
			panel1.add(btn);
		}
	}

	public void addTab(JPanel pane, String title, Icon icon) {
	    if (pane == null) {
	    	pane = new JPanel();
		    String background = "images\\md_town.jpg";
		    title = "Welcome";
		    System.out.println(background);
		    pane.add(new JLabel(new ImageIcon(background)));		    
	    }
	    ctwwWindow.addTab(title, null, pane, "Default");
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
		CtWWFrame frame = new CtWWFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        //frame.add(new CtWWLessonPanel(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		        UIManager.put("swing.boldMetal", Boolean.FALSE);
		        createAndShowGUI();
            }
       });
	}
	
}
