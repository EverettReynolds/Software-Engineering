package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import prepare.AnimalFamilyInfo;
import prepare.GeneralBean;



public class BottomPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private String[] dataNames = {"subjId:", "momId:", "dadId:", "sex:", "founderId:", "pedigree:", "siblingNo:","dob:","bGroup:","unicode:"};
	private JLabel[] data = new JLabel[10]; 

	public BottomPanel() {
		this.setLayout(new GridLayout(2,10));
		JLabel dataLabel;
		JLabel aCell;
		int i = 0;
		for (String name : dataNames) {
			dataLabel = new JLabel(name, JLabel.CENTER);
			dataLabel.setOpaque(true);
			dataLabel.setForeground(Color.black);
			//dataLabel.setBorder(blackline);
			// add the cell to the JPanel
			this.add(dataLabel);
			
			aCell = new JLabel();
			//aCell.setEditable(false);
			data[i] = aCell;
			i++;
			this.add(aCell);
		}
		
	}
	
	public void editData(String[] newdata) {
		for(int i = 0; i < 10; i++) {
			data[i].setText(newdata[i]);
		}
		
	}
	public void editData(AnimalFamilyInfo newdata)
	{
		//Create a new GeneralBean from the AnimalFamilyInfo
		GeneralBean gBean = new GeneralBean(newdata);
		
		String[] beanData = gBean.getGeneralInfo();
		
		for(int i = 0; i < beanData.length; i ++)
		{
			data[i].setText(beanData[i]);
		}
	}
		
	
}
