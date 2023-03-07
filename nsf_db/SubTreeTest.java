package tree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

public class SubTreeTest extends JFrame {
    private JTree tree;

    public SubTreeTest() {
    	super("Subtree Test");
    	
    	CSFamilyTreeViewer viewer = new CSFamilyTreeViewer();
    	tree = new JTree(viewer.getTree("003"));
        add(new JScrollPane(tree), BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SubTreeTest();
            }
        });
    }       
}
