import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;
/* * 
 * 		This class allows you to read in a file for descriptions of celestial objects
 * 		@author Everett Reynolds
 * 		@version 1.0
 * 		
 * 	
 *
 */

	
public class FileRead {

	public static String[] getDescription(SolarSystemStarEnum sse) throws FileNotFoundException
	{
		String[] strArr = new String[11];
		int count = 0;
		try {
		      File myObj = new File("SolarSystemStarDescriptions.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        strArr[count] = data;
		        count++;
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return strArr;
		/*File file = new File("SolarSystemStarDescriptions.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		 while ((st = br.readLine()) != null)
		 {
			 if(sse == 0)
			 {
				 
			 }*/
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SolarSystemStarEnum sse = SUN;
		
		//getDescription(sse);
	}

}
