package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import afm.TabbedFrameTest;

public class CtWWLessonPanel  extends JPanel {
	JTabbedPane tabbedPane;
    ImageIcon icon ;
	
	public CtWWLessonPanel() {
	    super(new GridLayout(1, 1));
	    
	    tabbedPane = new JTabbedPane();
	    Dimension dim = new Dimension(1350, 850);
		tabbedPane.setPreferredSize(dim );
	    
	    JPanel panel1 = new JPanel();
	    tabbedPane.addTab("Mulan", null, panel1,
	            "Default");
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_H);
	    
	    addLessonButtons(panel1);
	    
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	private void addLessonButtons(JPanel panel1) {
		// add 10 buttons, one for a lesson
		JButton btn;
		
		ActionListener alAddTextPane = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addTextPane();
				
			}

			private void addTextPane() {
				MulanLessonPanel textPanel = new MulanLessonPanel();
				icon =  new ImageIcon("images/xu_wei_icon.png");
				tabbedPane.addTab("第一课", icon, textPanel, "Lesson 1");
				tabbedPane.setSelectedIndex(1);
				repaint();
			}
			
		};
		for (int i=1; i<=10; i++) {
			btn = new JButton("Lesson " + i);
			btn.addActionListener(alAddTextPane);
			panel1.add(btn);
		}
	}

	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Learn Chinese with MULAN");
        Image image = new ImageIcon("images/icon.png").getImage();

        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new CtWWLessonPanel(), BorderLayout.CENTER);
         
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
