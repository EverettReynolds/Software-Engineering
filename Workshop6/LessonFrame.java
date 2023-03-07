//package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LessonFrame {

	public static void main(String[] args) {
		LessonPanel canvas = new LessonPanel();		
		JFrame test = new JFrame("Lesson Test");
		JButton jbtnNext = new JButton("Next");

		test.add(canvas);
		test.add(jbtnNext);
		
		/* Task 5.a
		 * comment out the last statement, and uncomment this block */
		Container c = test.getContentPane();
		c.add(canvas, BorderLayout.CENTER);
		JPanel control = new JPanel();
		control.add(jbtnNext);
		c.add(control, BorderLayout.SOUTH);
		/**/
		
		/* Task 5.b
		 * uncomment this block*/
		class InnerButtonHandler 
	    implements ActionListener {

		@Override
			public void actionPerformed(ActionEvent e) {
				canvas.updateImage();			
			}			
		}

		jbtnNext.addActionListener(new InnerButtonHandler());
		/**/
		
		/* Task 5.d
		 * uncomment this block to add a Reset button
		 */
		JButton jbtnReset = new JButton("Reset");
		control.add(jbtnReset);
		jbtnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.resetImage();
                test.repaint();
			}
			
		});
		/**/
		
		/* Task 5.c
		 * uncomment this block to add a Play button to update image automatically*/

        JButton jbtnPlay = new JButton("Play");
        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
            	canvas.updateImage();
                test.repaint();
            }
        }

        jbtnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TimerListener tl = new TimerListener();
                int delay = 1000;
                Timer t = new Timer(delay, tl);
                t.start();
            }
        });
		control.add(jbtnPlay);
		/**/

		test.pack();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

}
