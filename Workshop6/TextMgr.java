//package mgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

//import dao.CtWWDAO;
//import dao.FileDAO;

public class TextMgr extends CtWWLessonMgr {
	TextBean textBean;
	/*CtWWDAO*/ FileDAO dao = new FileDAO();// hard coded for now

	@Override
	public TextBean prepareBean() {
		// hard coded with a default bean
		// textBean = new TextBean();
		String textFilePath = dao.getFilePath();
		System.out.println(textFilePath);
		try {
			String text = new Scanner(new File(textFilePath + "/data/Lesson-1.txt")).nextLine();
			ImageIcon ill = new ImageIcon(textFilePath + "images/xu_wei.png");
			textBean = new TextBean(text, ill);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return textBean;
	}

}
