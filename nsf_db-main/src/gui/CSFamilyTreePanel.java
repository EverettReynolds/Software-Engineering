package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import prepare.AnimalFamilyInfo;
import prepare.MeasureBean;
import prepare.MeasureHash;
import prepare.TreeDataWrapper;
import prepare.familytree.MatrilinealTreeOrganizer;
import prepare.familytree.PatrilinealTreeOrganizer;

public class CSFamilyTreePanel extends JPanel {
    private JTree patrilTree;
    private JTree matrilTree;
    private JTree tree;
    private DefaultMutableTreeNode patrilRoot;
    private DefaultMutableTreeNode matrilRoot;
    private JScrollPane theTreePane;
    
    private static String patrilinealMeasureFile = "data/measure.dat";
    private static TreeDataWrapper patrilinealData;
    private static TreeDataWrapper matrilinealData;
    private static TreeDataWrapper data;
    
    private  MeasurePanel measurePanel;
    private  BottomPanel bottomPanel;
    private  ImagePanel imagePanel;
    
    public CSFamilyTreePanel( MeasurePanel measurePanel, final BottomPanel bottomPanel, final ImagePanel imagePanel) {
    	this.measurePanel = measurePanel;
    	this.bottomPanel = bottomPanel;
    	this.imagePanel = imagePanel;
    	
    	MatrilinealTreeOrganizer matrilTreeOrg = new MatrilinealTreeOrganizer();
    	PatrilinealTreeOrganizer patrilTreeOrg = new PatrilinealTreeOrganizer();
    	patrilRoot = patrilTreeOrg.getRoot();
    	patrilTree = new JTree(patrilRoot);
    	addSelectionListener(patrilTree);

    	matrilRoot = matrilTreeOrg.getRoot();
    	matrilTree = new JTree(matrilRoot);
    	addSelectionListener(matrilTree);
    	
    	tree = patrilTree;

    	setLayout(new BorderLayout());
    	theTreePane = new JScrollPane(tree);
    	theTreePane.setPreferredSize(new Dimension(200, 200));
        add(theTreePane, BorderLayout.CENTER);

        //Create a MeasureHash for the patrilineal tree
        MeasureHash measureHash = new MeasureHash(patrilinealMeasureFile);
        
        //Wrap the general information of each entry with the measure data for each entry
        patrilinealData = new TreeDataWrapper(patrilTreeOrg.getGeneralInfo(), measureHash);
        matrilinealData = new TreeDataWrapper(matrilTreeOrg.getGeneralInfo(), measureHash);
        data = patrilinealData;
        
        final String[] treeTypes = {"Patrilineal", "Matrilineal"};
        JComboBox treeChooser = new JComboBox(treeTypes);
        add(treeChooser, BorderLayout.NORTH);
        
        treeChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String choice = (String)cb.getSelectedItem();			
				if (choice.equals(treeTypes[0])) {
					tree = patrilTree;
					theTreePane.setViewportView(tree);
					data = patrilinealData;
				}
				else {
					tree = matrilTree;
					theTreePane.setViewportView(tree);
					data = matrilinealData;

				}
		        tree.setCellRenderer(new AnimalNodeRenderer());
		        tree.setShowsRootHandles(true);
			}
        });
         

        tree.setCellRenderer(new AnimalNodeRenderer());
        //tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
      }

    public void addSelectionListener(final JTree tree) {
        tree.getSelectionModel().addTreeSelectionListener(
        		new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = 
                		(DefaultMutableTreeNode) 
                		tree.getLastSelectedPathComponent();
         //       String text = selectedNode.toString();
                if (selectedNode.getUserObject() instanceof AnimalFamilyInfo) {
                	AnimalFamilyInfo an = (AnimalFamilyInfo)selectedNode.getUserObject();
           //     	text = an.toString();
                	
                	//Update measure table data
                	System.out.println(an.getAnimalId());
                	if(data.getMeasureData().getMeasureHash().get(an.getAnimalId()) != null)
                		measurePanel.editTable(data.getMeasureData().getMeasureHash().get(an.getAnimalId()));
                	else
                		measurePanel.editTable(new MeasureBean(new String[24]));
                	
                	//Update general information
                	bottomPanel.editData(an);
                	
                }
            }
        });
    }
  	class AnimalNodeRenderer extends DefaultTreeCellRenderer {
          Icon nodeIcon;
          final public ImageIcon FEMALE_ICON  = new ImageIcon("images/female_icon.png");
          final public ImageIcon MALE_ICON  = new ImageIcon("images/male_icon.png");
          final public ImageIcon UNKNOWN_ICON  = new ImageIcon("images/unknown_icon.png");
          final public ImageIcon FOUNDER_ICON  = new ImageIcon("images/founder.png");

          public AnimalNodeRenderer() {
          }

          public Component getTreeCellRendererComponent(
                              JTree tree,
                              Object value,
                              boolean sel,
                              boolean expanded,
                              boolean leaf,
                              int row,
                              boolean hasFocus) {

              super.getTreeCellRendererComponent(
                              tree, value, sel,
                              expanded, leaf, row,
                              hasFocus);
              String text; 
              DefaultMutableTreeNode node =
                      (DefaultMutableTreeNode)value;
              Object userObject = node.getUserObject();
              if (userObject instanceof AnimalFamilyInfo) {
                	
              	  AnimalFamilyInfo nodeInfo = (AnimalFamilyInfo)userObject;
              	  text = nodeInfo.getUnicode();
              }
              else
            	  text = value.toString();
          	  nodeIcon = setNodeIcon(value);
              setIcon(nodeIcon);
              setToolTipText(text);
              setText(text);
              //System.out.println((value.getClass()) + "?Text to render..." + text);

              return this;
          }

          private Icon setNodeIcon(Object value) {
          	Icon retIcon;
          	
              DefaultMutableTreeNode node =
                      (DefaultMutableTreeNode)value;
              if (node.getUserObject() instanceof String)
              	retIcon = null; // handles dummy root node
              else {
            	  AnimalFamilyInfo nodeInfo =
  	                    (AnimalFamilyInfo)(node.getUserObject());
            	  //System.out.println(nodeInfo.getUnicode()  + "{" + nodeInfo.getGender().charAt(0) + "}");
            	  
  	            String gender = nodeInfo.getGender();
  	            //if (nodeInfo.getMomId().length() == 0) {
  	  	        if (nodeInfo.getMomId()==null) {
  	            	retIcon = FOUNDER_ICON;
  	            }
  	  	        // gender is "f" or "m"!!!
  	            else if (gender.charAt(1)=='f') {
  	            	retIcon = FEMALE_ICON;
  	            }
  	            else if (gender.charAt(1)=='m') {
  	            	retIcon = MALE_ICON;
  	            } else {
  	            	retIcon = UNKNOWN_ICON;
  	            } 
              }

              return retIcon;
  		}
    }


}
