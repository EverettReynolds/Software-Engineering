package prepare.familytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.DefaultMutableTreeNode;

import prepare.AnimalFamilyInfo;

public class PatrilinealTreeOrganizer {
	PatrilinealTreeGenerator ptGen = new PatrilinealTreeGenerator();
		
	// for all tree nodes, lookup by animal id
	// each node leads to a subtree starting from it
   	Map<String, DefaultMutableTreeNode> idToNodeLookup = 
   			new HashMap<String, DefaultMutableTreeNode>(); 

	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("CS Patril Trees");

	public PatrilinealTreeOrganizer()  {
		ptGen.loadData();
		buildTree();
	}

	private void buildTree() {
		DefaultMutableTreeNode dadNode, childNode;
		int chdCount;
		
		List<AnimalFamilyInfo> childrenList;
		
		for (String dadId : ptGen.chronicalSireSet) {
			chdCount = 0;
			dadNode = new DefaultMutableTreeNode(ptGen.getAnimalIdFamilyInfoLookup(dadId));
			root.add(dadNode);
			idToNodeLookup.put(dadId, dadNode);
			
			System.out.print(dadId);
			childrenList = ptGen.dadChildrenLookup.get(dadId);
			if (childrenList == null) {
				continue;
			}
			//else if (idToNodeLookup.get(dadId) == null) {
			//	dadNode = new DefaultMutableTreeNode(ptGen.getAnimalIdFamilyInfoLookup(dadId));
				
			//}
			
			// to be replaced with a recursive method to handle subtrees
				for (AnimalFamilyInfo afInfo : childrenList) {
					chdCount++;
					childNode = new DefaultMutableTreeNode(afInfo);
					dadNode.add(childNode);
					idToNodeLookup.put(afInfo.getAnimalId(), dadNode);
				}
			
			System.out.println("x" + chdCount + "==>" + dadNode.getChildCount());
		}
	}



	public DefaultMutableTreeNode getRoot() {
		// TODO Auto-generated method stub
		return root;
	}
	
	/**
	 * Gets the map of tree nodes
	 * @return idToNodeLookup map associating animalId to tree node
	 */
	public Map<String, DefaultMutableTreeNode> getGeneralInfo()
	{
		return idToNodeLookup;
	}

}
