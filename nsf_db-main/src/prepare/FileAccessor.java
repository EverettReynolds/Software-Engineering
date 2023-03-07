package prepare;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileAccessor {
		
	/**
	 * Gets the measure data of the specified entry in the tree from a file
	 * @param fileName name of the file to pull from
	 * @return data Returns the file contents as a string separated by new line characters
	 */
	public static String getData(String fileName)
	{
		String data = "";
		
		//try/catch that handles reading from a text file
		try 
		{
			//Read file into scanner
			Scanner input = new Scanner(new File(fileName));
		
			while (input.hasNextLine())
			{
				data += input.nextLine() + "\n";
			}
			
			return data;
		
		}
		//File not found exceptions
		catch(IOException e)
		{
			System.out.println("Invalid File!");
			e.printStackTrace();
		}
		
		return "Entry Not found!";
	}
	
}
