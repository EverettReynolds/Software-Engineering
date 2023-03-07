package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import prepare.MeasureBean;
import prepare.MeasureHash;

import java.util.Scanner;

public class MeasurePanel extends JPanel
{
	private JTable table;
	private JScrollPane sp;
	
	private String[] rowHeaders;
	private String[][] columnData;
	private String[] colHeaders;
	
	/**
	 * Constructs an information panel that consists of a JTable with information about the selected entry
	 */
	public MeasurePanel()
	{
		//Headers for each row in the table
		rowHeaders = new String[]{"Zy-Zy", "Ba-Br", "Eu-Eu", "GI-Op","Go-Co", "Go-Go", "Po-GO", "AI-MxF sut", "HL", "HPML", "HPAP", "HDML", "HDAP", "RL", "RPML", "RPAP", "RDML", "RDAP", "UL", "FL", "FHL", "FHSI", "FPAP", "FPML" };
		//Data fields for each cell in the table
		columnData = new String[24][2];

		//Array used to form column headers, which are not displayed unless a scroll panel is used.
		colHeaders = new String[]{"Data Type", "Data Value"};
		
		//Instantiates the table with the proper values from the file
		table = new JTable(columnData, colHeaders);
		
		//Add the table to a scroll panel
		sp = new JScrollPane(table);
		add(sp);


	}
	
	public void editTable(MeasureBean measureBean)
	{
		int counter = 0;
		
		String[] measureData = measureBean.getMeasureData();
		
		while(counter < columnData.length)
		{
			columnData[counter][0] = rowHeaders[counter];
			columnData[counter][1] = measureData[counter];
			
			counter++;
		}
		
		table = new JTable(columnData, colHeaders);
		remove(sp);
		sp = new JScrollPane(table);
		add(sp);
	}
	
}
