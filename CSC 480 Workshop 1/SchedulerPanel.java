import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SchedulerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea[][] cells;
	String[] weekdayNames = { "Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat" }; // "日", "一", "二", "三", "四", "五", "六"
	String weekdayNamePrefix = ""; // 星期

	public SchedulerPanel() {
		this.setLayout(new GridLayout(7, 7));
		cells = new JTextArea[6][7];
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JLabel weekdayLabel;
		int num = 0;
		for (String name : weekdayNames) {
			weekdayLabel = new JLabel(weekdayNamePrefix + name, JLabel.CENTER);
			weekdayLabel = new JLabel(weekdayNamePrefix + weekdayNames[num], JLabel.CENTER);
			weekdayLabel.setOpaque(true);
			weekdayLabel.setBackground(new Color(51, 227, 255));
			weekdayLabel.setForeground(Color.RED);
			weekdayLabel.setBorder(blackline);
			this.add(weekdayLabel);
			num++;
		}

		JTextArea aCell;
		int date = 1;
		GregorianCalendar calendar = new GregorianCalendar(2022,8,1);
		System.out.println(calendar.get(GregorianCalendar.MONTH));
		//calendar.set(GregorianCalendar.MONTH, 8);
		//calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		//calendar.set(GregorianCalendar.DAY_OF_WEEK, 1);
		calendar.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, 1);
		Scanner scn;
		System.out.println(calendar.get(GregorianCalendar.DAY_OF_WEEK));
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length+1; j++) {
				System.out.println(date);
				if (date > 31) {
					break;
				}

				aCell = new JTextArea(3, 15);
				aCell.setText(8 + "-" + date + "\n");
				aCell.setBorder(blackline);
				this.add(aCell);
				// this.add(aCell);
				date++;
				System.out.println(date);
			}
			
			/*aCell = new JTextArea(3, 15);
			aCell.setText("\n");
			aCell.setBorder(blackline);
			this.add(aCell);*/
			
		}
		/*aCell = new JTextArea(3, 15);
		aCell.setText("\n");
			aCell.setBorder(blackline);
			this.add(aCell);*/

	}

	public static void main(String[] args) throws Exception {
		JFrame schFrame = new JFrame("Monthly Planner"); //月度计划
		schFrame.add(new SchedulerPanel());
		EventFileAccessor fileAccessor = new EventFileAccessor("EventsList.csv");
		System.out.println(fileAccessor.getEventList());
		schFrame.pack();
		schFrame.setVisible(true);
		schFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}