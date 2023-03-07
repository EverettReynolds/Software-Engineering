package workshop3;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GregorianCalendarDay
{
	public static final int ENGLISH = 0;
	public static final int CHINESE = 1;
	public static final int JAPANESE = 2;
	public static final int KOREAN = 3;
   public static final int SPANISH = 4;
	
	private GregorianCalendar gregCal;
	private SimpleDateFormat sdFormat;

	private int preferredLanguage;
	
	private int DEFAULT_LANGUAGE = ENGLISH;
	private Locale locale = new Locale("en", "US");
	
	/**
	    Constructs a day for the given date string using a provided date pattern
	    @param dateString the String representation of a date in a certain format
	    @param datePattern a String that defines the pattern used for date string
		@throws ParseException 
	*/
	public GregorianCalendarDay(String dateString, String datePattern) 
			throws ParseException
	{
		sdFormat = new SimpleDateFormat(datePattern); 
		Date date = sdFormat.parse(dateString);
	    gregCal = new GregorianCalendar();
	    gregCal.setTime(date);
	}
		
	/**
		Constructs a day for today's date
	*/
	public GregorianCalendarDay()
	{
		gregCal = new GregorianCalendar();
	}

   /**
      Constructs a day with a given year, month, and day
      of the Julian/Gregorian calendar. The Julian calendar
      is used for all days before October 15, 1582
      @param aYear a year != 0
      @param aMonth a month between 1 and 12
      @param aDate a date between 1 and 31
   */
   public GregorianCalendarDay(int aYear, int aMonth, int aDate)
   {
	   gregCal = new GregorianCalendar(aYear, aMonth - 1, aDate);
   }

   /**
      Returns the year of this day
      @return the year
   */
   public int getYear()
   {
      return gregCal.get(GregorianCalendar.YEAR);
   }

   /**
      Returns the month of this day
      @return the month
   */
   public int getMonth()
   {
	   return gregCal.get(GregorianCalendar.MONTH) + 1;
   }

   /**
      Returns the day of the month of this day
      @return the day of the month
   */
   public int getDate()
   {
		return gregCal.get(GregorianCalendar.DATE);
   }

   /**
      Returns the day of the month of this day
      @return the day of the month
   */
   public void setPreferredLanguage(int languageCode)
   {
		switch (languageCode) {
			case GregorianCalendarDay.ENGLISH:
				locale = new Locale("en", "US");
				break;
			case GregorianCalendarDay.CHINESE:
				locale = new Locale("zh", "cn");
				break;
			case GregorianCalendarDay.JAPANESE:
				locale = new Locale("ja", "jp");
				break;
			case GregorianCalendarDay.KOREAN:
				locale = new Locale("ko", "kr");
				break;
         case GregorianCalendarDay.SPANISH:
            locale = new Locale("es", "sp");
            break;
			default:
				locale = new Locale("en", "US");
				break;
		}

   }

   /**
      Returns the day of the week of this day
      @return the day of the week in 1 - 7 for Sunday through Saturday
   */
   public int getDayOfWeek()
   {
		return gregCal.get(GregorianCalendar.DAY_OF_WEEK);
   }

   /**
      Returns the day of the week of this day in full spell
      @return the day of the week in the preferred language
   */
   public String getDayOfWeekInFullName()
   {
	   //Locale locale = new Locale("zh", "cn");
		//System.out.println(locale);
	   DateFormatSymbols symbols = new DateFormatSymbols(locale);
	   String[] dayNames = symbols.getWeekdays();

		return dayNames[gregCal.get(GregorianCalendar.DAY_OF_WEEK)];
   }
   
   public String getMonthFullName() {
	   DateFormatSymbols symbols = new DateFormatSymbols(locale);
	   String[] monthNames = symbols.getMonths();
	   return monthNames[gregCal.get(GregorianCalendar.MONTH)];
   }

   /**
      Returns a day that is a certain number of days away from
      this day
      @param n the number of days, can be negative
      @return a day that is n days away from this one
   */
   public GregorianCalendarDay addDays(int n)
   {
	   gregCal.add(GregorianCalendar.DATE, n);
       return this;
   }

   /**
      Returns the number of days between this day and another
      day
      @param other the other day
      @return the number of days that this day is away from 
      the other (>0 if this day comes later)
   */
   public int daysFrom(GregorianCalendarDay other)
   {
      int n = (int)Duration.between(this.gregCal.toInstant(), 
    		  other.gregCal.toInstant()).toDays();
      return n;
   }
   
   public String toString() {
	   if (sdFormat == null) {
		   sdFormat = new SimpleDateFormat();
	   }
	   return sdFormat.format(gregCal.getTime());
   }
}