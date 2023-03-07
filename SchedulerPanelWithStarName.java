import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.StarIcon;

public class SchedulerPanelWithStarName extends SchedulerPanel {
	public SchedulerPanelWithStarName() {
		Component[]	all = super.getComponents();
		//System.out.println("# of comp's" + all.length);
		List<JButton> labels = new ArrayList<JButton>();

		JButton f;
		int index = 0;
		for (Component c : all) {
			//System.out.println(c.getClass());
			if (c instanceof JButton) {
				index++;
				f = (JButton)c;
				labels.add(f);
				System.out.println(f.getText()); 
				//f.addActionListener(new StarIconDisplay(index));
				f.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String caption = e.getActionCommand();
						int starCode = lookupCodeForCaption(caption);
						
					    JOptionPane.showMessageDialog(
					            null,
					            "Hello, Star!",
					            "Message",
					            JOptionPane.INFORMATION_MESSAGE,
					            new StarIcon(starCode));
					}

					private int lookupCodeForCaption(String caption) {
						switch (caption.charAt(2)) {
							case '日':
								return 1;
							case '一':
								return 2;
							case '二':
								return 3;
							case '三':
								return 4;
							case '四':
								return 5;
							case '五':
								return 6;
							case '六':
								return 7;
						}
						return 0;
					}
					
				});
			}
		}
	}


}
