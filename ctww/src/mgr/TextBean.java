package mgr;

import javax.swing.ImageIcon;

public class TextBean extends LessonPanelBean {
	private String text;// = "我叫徐文长。";
	ImageIcon pixIcon;

	public TextBean(String text, ImageIcon pixIcon) {
		this.text = text;
		this.pixIcon = pixIcon;
	}
	
	public TextBean() {
		pixIcon = new ImageIcon("images/xu_wei.png");
	}
	
	public String getText() {
		return text;
	}
	
	public ImageIcon getImage() {
		return pixIcon;
	}
}
