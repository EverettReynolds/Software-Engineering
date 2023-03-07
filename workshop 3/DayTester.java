package workshop3;

import java.text.ParseException;
import java.util.Date;

public class DayTester extends GregorianCalendarDay{
	  String zi = "字";

	public static void main(String[] args) {
		GregorianCalendarDay day = new GregorianCalendarDay();
		Date date = new Date();
		GregorianCalendarDay bday = null;
		try {
			bday = new GregorianCalendarDay("1965-06-19", 
					"yyyy-mm-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(day);
		System.out.println(bday);
		
		System.out.println(day.daysFrom(bday));
		System.out.println(bday.getDayOfWeek());
		
		for (int i=0; i<7; i++) {
			System.out.println(day + "==>" + day.getDayOfWeekInFullName());
			day.addDays(1);
		}
		bday.setPreferredLanguage(GregorianCalendarDay.JAPANESE);
		System.out.println(bday.getDayOfWeekInFullName());
		day.setPreferredLanguage(GregorianCalendarDay.KOREAN);
		System.out.println(day.getDayOfWeekInFullName());
		System.out.println(bday.getMonthFullName());
	}

}
