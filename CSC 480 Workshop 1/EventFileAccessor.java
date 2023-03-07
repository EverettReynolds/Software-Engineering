
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EventFileAccessor {
	private Map<Date, String> eventList;
	private SimpleDateFormat sdFormat = new SimpleDateFormat("M-d-yyyy");
	private String fileName;

	public EventFileAccessor(String fileName) throws Exception {
		this.fileName = fileName;
		eventList = new HashMap<Date, String>();
		String[] parts;
		Date eventDate;
		String eventText;

		Scanner input = new Scanner(new File(fileName));
		/*
		 * while (input.hasNext()) {
		 * parts = input.nextLine().split(",");
		 * eventDate = sdFormat.parse(parts[0]);
		 * eventText = parts[1];
		 * eventList.put(eventDate, eventText);
		 * System.out.println(eventText + "@" + eventDate);
		 * }
		 */
		try {
			File name = new File(fileName);
			FileReader read = new FileReader(name);
			BufferedReader buff = new BufferedReader(read);
			String ln = "";
			String[] temp;
			while ((ln = buff.readLine()) != null) {
				temp = ln.split(",");
				for (String tempStr : temp) {
					System.out.println(tempStr + " ");
				}
				System.out.println();
			}
			buff.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
		input.close();
	}

	public Map<Date, String> getEventList() {
		return this.eventList;
	}

	public static void main(String[] args) throws Exception {
		EventFileAccessor fileAccessor = new EventFileAccessor("EventsList.csv");
		System.out.println(fileAccessor.getEventList());
	}
}
