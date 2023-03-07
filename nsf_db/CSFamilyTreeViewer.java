package tree;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CSFamilyTreeViewer extends JFrame
{
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("CS Root");
    private JTree tree = new JTree(root);
    private JLabel selectedLabel;
    
    private JScrollPane theTreePane;
    
    private List<AnimalNode> nodesInTree; // for now
    
    public CSFamilyTreeViewer()
    {
    	FamilyTreeDataReader reader = new FamilyTreeDataReader();
    	nodesInTree = reader.getTreeByMatrilId("3"); // hard-coded for now
		System.out.println(nodesInTree.size());
		//buildTestTree();
    	buildTree();
    	theTreePane = new JScrollPane(tree);
        add(theTreePane, BorderLayout.CENTER);
        
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);
        
        JComboBox matrilFamilyList = new JComboBox(getFounders());
        add(matrilFamilyList, BorderLayout.NORTH);
        matrilFamilyList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String founder = (String)cb.getSelectedItem();			
				updateTree(founder);
			}
        });

        tree.getSelectionModel().addTreeSelectionListener(
        		new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = 
                		(DefaultMutableTreeNode) 
                		tree.getLastSelectedPathComponent();
                String text = selectedNode.toString();
                if (selectedNode.getUserObject() instanceof AnimalNode) {
                	AnimalNode an = (AnimalNode)selectedNode.getUserObject();
                	text = an.toStringFullForm();
                }
                selectedLabel.setText(text);
                //selectedLabel.setText(e.getPath().toString());
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CS Family Tree Viewer");       
        this.pack();
        this.setVisible(true);
    }

	private void updateTree(String founder) {
		tree = new JTree(getTree(founder));
	       tree.setCellRenderer(new AnimalNodeRenderer());
		//this.removeAll();
		theTreePane.setVisible(false);
		theTreePane = new JScrollPane(tree);
        add(theTreePane, BorderLayout.CENTER);		
        add(selectedLabel, BorderLayout.SOUTH);

        tree.getSelectionModel().addTreeSelectionListener(
        		new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = 
                		(DefaultMutableTreeNode) 
                		tree.getLastSelectedPathComponent();
                String text = selectedNode.toString();
                if (selectedNode.getUserObject() instanceof AnimalNode) {
                	AnimalNode an = (AnimalNode)selectedNode.getUserObject();
                	text = an.toStringFullForm();
                }
                selectedLabel.setText(text);
                //selectedLabel.setText(e.getPath().toString());
            }
        });

        this.revalidate();
        repaint();
	}
	 
    private String[] getFounders() {
		String[] founders = new String[root.getChildCount() + 1]; 
		founders[0] = "CS Root";
		for (int i = 1; i < root.getChildCount(); i++) {
			founders[i] = root.getChildAt(i).toString().split(" ")[0];
		}
		return founders;
	}

	public DefaultMutableTreeNode getTree() {
    	return root;
    }
    
    public DefaultMutableTreeNode getTree(String name) {
    	if (name.equals("CS Root"))
    	    	return getTree();
    	return getSubTree(root, name);
    }
    
    private DefaultMutableTreeNode getSubTree(DefaultMutableTreeNode curRoot, String name) {
    	System.out.println(">>>subtree" + curRoot.toString().split(" ")[0]);
    	if ((curRoot.toString().split(" ")[0]).equals(name))
            return curRoot;
		DefaultMutableTreeNode node =  null;
         for (int i = 0; i < curRoot.getChildCount(); i++) {
             node = getSubTree((DefaultMutableTreeNode)curRoot.getChildAt(i), name);
             if (node != null)
                 break;
         }
         return node;
    }
    
    private void buildTestTree() {
	   	DefaultMutableTreeNode curNode, parentNode = null;
	   	Map<String, DefaultMutableTreeNode> idToNodeLookup = 
	   			new HashMap<String, DefaultMutableTreeNode>(); 
	   	for (int i=0; i<5; i++) {
	   		if (i==0) {
	   			parentNode = new DefaultMutableTreeNode(nodesInTree.get(i));
	   	        tree = new JTree(parentNode);
	   	        idToNodeLookup.put(nodesInTree.get(i).animalId, parentNode);
	   		}
	   		else {
	   			curNode = new DefaultMutableTreeNode(nodesInTree.get(i));
	   	        idToNodeLookup.put(nodesInTree.get(i).animalId, curNode);
	   			parentNode.add(curNode);
	   			parentNode = curNode;
	   		}
	   		System.out.println(nodesInTree.get(i));
	   	}
       tree.setCellRenderer(new AnimalNodeRenderer());

       //tree.setRootVisible(false);
       tree.setShowsRootHandles(true);
	}
   
  private void buildTree() {
	  int noParentCount = 0;
	  List<AnimalNode> misplacedNodes = new LinkedList<AnimalNode>();
	  //List<String> misplacedNodes = new LinkedList<String>();
  	DefaultMutableTreeNode curNode, parentNode = null;
  	Map<String, DefaultMutableTreeNode> idToNodeLookup = 
  			new HashMap<String, DefaultMutableTreeNode>(); 
  	for (AnimalNode node : nodesInTree) {
  		System.out.println(node.animalId + "[" + node.momId +"]");
  		curNode = new DefaultMutableTreeNode(node);
  		if (node.momId.length() == 0) {
  			root.add(curNode);
  		}
  		else {
  			parentNode = idToNodeLookup.get(node.momId);
  			if (parentNode == null) {
  				misplacedNodes.add(node);
  				//misplacedNodes.add(node.toStringFullForm());
  				noParentCount++;
  				continue;
  			}
  			parentNode.add(curNode);
  		}
  	        
  		idToNodeLookup.put(node.animalId, curNode);
  		System.out.println(node.animalId);
  	}
      tree.setCellRenderer(new AnimalNodeRenderer());

      //tree.setRootVisible(false);
      tree.setShowsRootHandles(true);
		System.out.println("Misplaced nodes: " + misplacedNodes.size());
		
		DefaultMutableTreeNode momNode;
		for (AnimalNode node : misplacedNodes) {
			System.out.println(node.toStringFullForm());
			///* try again to merge the founder tree file with the missing nodes
			//reenter the missing nodes in JTree
			curNode = new DefaultMutableTreeNode(node);
			momNode = idToNodeLookup.get(node.momId);
			momNode.add(curNode);
			System.out.println("Nodes " + curNode + "==>" + momNode);
	  		idToNodeLookup.put(node.animalId, curNode);
	  		System.out.println(node.animalId);
	  		//*/
		}
    	
    }

	class AnimalNodeRenderer extends DefaultTreeCellRenderer {
        Icon nodeIcon;
        final public ImageIcon FEMALE_ICON  = new ImageIcon("image/female_icon.png");
        final public ImageIcon MALE_ICON  = new ImageIcon("image/male_icon.png");
        final public ImageIcon UNKNOWN_ICON  = new ImageIcon("image/unknown_icon.png");
        final public ImageIcon FOUNDER_ICON  = new ImageIcon("image/founder.png");

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
        	nodeIcon = setNodeIcon(value);
            setIcon(nodeIcon);
            setToolTipText(value.toString());

            return this;
        }

        private Icon setNodeIcon(Object value) {
        	Icon retIcon;
        	
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)value;
            if (node.getUserObject() instanceof String)
            	retIcon = null; // handles dummy root node
            else {
	            AnimalNode nodeInfo =
	                    (AnimalNode)(node.getUserObject());
	            char gender = nodeInfo.gender;
	            if (nodeInfo.momId.length() == 0) {
	            	retIcon = FOUNDER_ICON;
	            }
	            else if (gender == 'F') {
	            	retIcon = FEMALE_ICON;
	            }
	            else if (gender == 'M') {
	            	retIcon = MALE_ICON;
	            } else {
	            	retIcon = UNKNOWN_ICON;
	            } 
            }

            return retIcon;
		}
    }

	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CSFamilyTreeViewer();
            }
        });
    }       
}