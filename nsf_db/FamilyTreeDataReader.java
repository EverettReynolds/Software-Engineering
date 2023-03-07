package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class FamilyTreeDataReader {

	private Map<String, List<AnimalNode>> matrilTrees = 
			new HashMap<String, List<AnimalNode>>();
			
	public static void main(String[] args) {
		FamilyTreeDataReader reader = new FamilyTreeDataReader();
		System.out.println(reader.matrilTrees.keySet().size());
	}
	
	public FamilyTreeDataReader() {
		Scanner input = null;
		try {
			input = new Scanner(new File("data/MatrilTreeEntries77Founders.csv"));
			//input = new Scanner(new File("data/test2.csv"));
			//input = new Scanner(new File("data/treetest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = input.nextLine();
		System.out.println(line);
		String[] parts;
		AnimalNode node;
		
		List<AnimalNode> animalsInMatrilLine = new LinkedList<AnimalNode>(); 
		
		while(input.hasNextLine()) {
			line = input.nextLine();
			System.out.println(line);
			
			//parts = line.split("\\t");
			parts = line.split(",");
			node = new AnimalNode(parts);
			animalsInMatrilLine.add(node);
		}
		
		matrilTrees.put("3", animalsInMatrilLine);
	}
	
	public List<AnimalNode> getTreeByMatrilId(String matrilId) {
		return matrilTrees.get(matrilId);
	}
}

class AnimalNode {
	String animalId;
	char gender;
	Date dob;
	String momId;
	String sireGenetic;
	String matrilId;
	int pedigree;
	boolean isFounder;
	
	DateFormat format = new SimpleDateFormat("m/d/yyyy", Locale.ENGLISH);

	public AnimalNode(String[] parts) {
		animalId = parts[0];
		gender = parts[1].charAt(0);
		try {
			dob = format.parse(parts[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		momId = parts[3];
		sireGenetic = parts[4];
		matrilId = parts[5];
		pedigree = Integer.parseInt(parts[6]);
		this.isFounder = parts[3] == null;
	}
	
	public String toString() {
		return animalId + " (" + format.format(dob) + ")";
	}
	
	public String toStringFullForm() {
		return animalId + " (" + format.format(dob) + ") " + 
				momId + "=" + 
				(sireGenetic.length()>0?sireGenetic:"") + 
				" {" + matrilId + "-"  + pedigree + "}";
	}
}

