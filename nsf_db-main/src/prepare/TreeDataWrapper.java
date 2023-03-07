package prepare;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;


//This class encapsulates all relevant information for the tree that may need to be passed around and accessed throughout the program
public class TreeDataWrapper 
{
	Map<String, DefaultMutableTreeNode> generalInfoNode;
	private MeasureHash measureData;
	
	public TreeDataWrapper(Map<String, DefaultMutableTreeNode> generalInfoNode, MeasureHash measureData)
	{
		this.generalInfoNode = generalInfoNode;
		this.measureData = measureData;
	}
	
	public Map<String, DefaultMutableTreeNode> getGeneralInfoNode()
	{
		return generalInfoNode;
	}
	
	public MeasureHash getMeasureData()
	{
		return measureData;
	}
}
