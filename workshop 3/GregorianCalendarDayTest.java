package test.workshop3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import workshop3.GregorianCalendarDay;

import java.text.ParseException;

public class GregorianCalendarDayTest {
	private GregorianCalendarDay day = new GregorianCalendarDay(2022,9,23); 

	@Before
	public void setUp() throws Exception {
		day = new GregorianCalendarDay(2022,9,23); 
		day.setPreferredLanguage(GregorianCalendarDay.CHINESE);
	}

	@Test(expected = ParseException.class)
	public void testGregorianCalendarDayStringString() throws ParseException {
		new GregorianCalendarDay("2022/9/23", "yyyy-mm-dd");
	}

	@Test
	public void testGregorianCalendarDayIntIntInt() {
		day = new GregorianCalendarDay(2022,9,23); 
        Assert.assertEquals(day.getMonth(), 9);				
	}

	@Test
	public void testGetDayOfWeek() {
		//day.setPreferredLanguage(GregorianCalendarDay.CHINESE);
		Assert.assertThat(day.getDayOfWeek(), equalTo(6)); // TODO
	}

	/**
	 * 
	 */
	@Test
	public void testGetDayOfWeekInFullName() {
		//day.setPreferredLanguage(GregorianCalendarDay.CHINESE);
		//System.out.println(day.getMonthFullName());
		Assert.assertThat(day.getMonthFullName(), is(""));
	}

	@Test
	public void testAddDays() {
		day.addDays(-5); // TODO
		Assert.assertTrue(day.getDate() == 18);
	}

	@After
	public void tearDown() throws Exception {
	}

}
