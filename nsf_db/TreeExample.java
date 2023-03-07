package tree;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class TreeExample extends JFrame
{
    private JTree tree;
    private JLabel selectedLabel;
    
    public TreeExample()
    {
    	buildTree();
        add(new JScrollPane(tree));
        
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);

        tree.getSelectionModel().addTreeSelectionListener(
        		new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = 
                		(DefaultMutableTreeNode) 
                		tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.toString());
                //selectedLabel.setText(e.getPath().toString());
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
    }
     
    private void buildTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = 
        		new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
        DefaultMutableTreeNode fruitNode = 
        		new DefaultMutableTreeNode("Fruits");
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        //create the root node
        ImageIcon imageIcon = new ImageIcon("image/leaf.png");
        /*
        JOptionPane.showConfirmDialog(null, "See it?", "Test", 
        		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        		imageIcon);
        */
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);
        tree.setCellRenderer(renderer);

        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
	}

	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeExample();
            }
        });
    }       
}