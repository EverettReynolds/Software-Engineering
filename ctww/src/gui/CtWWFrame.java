package gui;

import javax.swing.JFrame;

public class CtWWFrame {
	public static void main(String[] args) {
		LessonPanel canvas = new LessonPanel();		
		JFrame test = new JFrame("Lesson Test");
		test.add(canvas);
		test.pack();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

}
