package prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MeasureHash 
{
	//Hash map that associates entry ids with measure data
	private HashMap<String, MeasureBean> measureHash = new HashMap();
	
	public MeasureHash(String fileName)
	{
		fillMap(fileName);
	}
	
	
	/**
	 * This method fills a hash map with measure data from a file, associating it with an id value
	 * @param fileName name of the file to pull measure data from
	 */
	private void fillMap(String fileName)
	{
		//Get the contents of the file
		String data = FileAccessor.getData(fileName);
		
		//Parse through the file, delimiting each entry with a new line
		Scanner scanner = new Scanner(data);
		scanner.useDelimiter("\n");
 
		while (scanner.hasNext()) 
		{
			//Split the line of data into an array
			String[] entryData = scanner.next().split(",", 25);
			
			//Copy the values after the id into an array and create a MeasureBean object from this array
			MeasureBean mBean = new MeasureBean(Arrays.copyOfRange(entryData, 1, entryData.length));
			
			//Add the key-value pair consisting of the entry id as key and the MeasureData bean as value into the hash map
			measureHash.put(entryData[0], mBean);
		
		}

	}
	/**
	 * Gets the measure data hash map
	 * @return measureHash HashMap of measure data
	 */
	public HashMap<String, MeasureBean> getMeasureHash()
	{
		return measureHash;
	}
}
