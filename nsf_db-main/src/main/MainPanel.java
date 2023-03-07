package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.BottomPanel;
import gui.CSFamilyTreePanel;
import gui.ImagePanel;
import gui.MeasurePanel;

public class MainPanel {
	public static void main(String[] args) {
	JFrame f = new JFrame("CS Family Tree Viewer");
	f.setLayout(new GridBagLayout());
	
	//Instantiate information/image panels and set their constraints
	MeasurePanel mPanel = new MeasurePanel();
	GridBagConstraints measureC = new GridBagConstraints();
	measureC.fill = GridBagConstraints.BOTH;
	measureC.anchor = GridBagConstraints.NORTHWEST;
	measureC.weightx = 0.0;
	measureC.weighty = 1.0;
	measureC.gridx = 1;
	measureC.gridy = 0;
	/////////////////////////////////////////////////////////////////////
	BottomPanel bPanel = new BottomPanel();
	GridBagConstraints bottomC = new GridBagConstraints();
	bottomC.fill = GridBagConstraints.HORIZONTAL;
	bottomC.anchor = GridBagConstraints.NORTHWEST;
	bottomC.weightx = 0.0;
	bottomC.weighty = 0.0;
	bottomC.gridx = 0;
	bottomC.gridy = 1;
	/////////////////////////////////////////////////////////////////////
	ImagePanel iPanel = new ImagePanel();
	GridBagConstraints imageC = new GridBagConstraints();
	imageC.fill = GridBagConstraints.HORIZONTAL;
	imageC.anchor = GridBagConstraints.NORTHWEST;
	imageC.weightx = 0.0;
	imageC.weighty = 0.0;
	imageC.gridx = 1;
	imageC.gridy = 1;
	/////////////////////////////////////////////////////////////////////
	CSFamilyTreePanel treePanel = new CSFamilyTreePanel(mPanel, bPanel, iPanel);
	GridBagConstraints treeC = new GridBagConstraints();
	treeC.fill = GridBagConstraints.BOTH;
	treeC.anchor = GridBagConstraints.NORTHWEST;
	treeC.weightx = 1.0;
	treeC.weighty = 1.0;
	treeC.gridx = 0;
	treeC.gridy = 0;

    
    //Add panels to frame
    f.add(treePanel, treeC);
    f.add(mPanel, measureC);
    f.add(bPanel, bottomC);
    f.add(iPanel, imageC);

	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.pack();
    f.setVisible(true);
}

}
