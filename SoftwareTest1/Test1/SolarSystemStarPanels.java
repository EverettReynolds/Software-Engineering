/**
 *  This class creates a gui which allows you to view stars & their attributes
 *  @author Everett Reynolds
 *  @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * This class is the main class which creates the solar system panels needed to see the stars which are desired
 * 
 */
public class SolarSystemStarPanels extends JPanel {
	
	private static final long serialVersionUID = 1L;
	List<JButton> stars = new ArrayList<JButton>();
	/**
	 * This constructor both sets the layout of our GUI & creates the UI which is seen on the screen
	 * 
	 */
	public SolarSystemStarPanels() throws IOException {
		setLayout(new BorderLayout());
		createUI();
	}

	/**
	 * This class is a random number chooser which picks a star to focus on
	 * 
	 */
	  public static SolarSystemStarEnum randomChooseStar() {
	    	Random r = new Random(System.currentTimeMillis());
	    	int index = r.nextInt(SolarSystemStarEnum.values().length);
	    	return SolarSystemStarEnum.values()[index];
	    }
	  /**
		 * This class creates an area which you can see the name of the star which was chosen to be focused on
		 * 
		 */
	public static SolarSystemStarEnum solarTime()
    {
    	JFrame frame = new JFrame();
    	//JTextArea text = new JTextArea();
    	//String decky;
    	SolarSystemStarEnum star = randomChooseStar();
    	//System.out.println(star);
    	//SolarSystemStarEnum star;
    	//SolarSystemStarEnum star = SUN;
        final int FIELD_WIDTH = 20;
        final JTextField textField = new JTextField(FIELD_WIDTH);
        frame.setLayout(new FlowLayout());
        frame.add(textField);

        ActionListener listener = event -> {
          /*Date now = new Date();
          textField.setText(now.toString());*/
        	//SolarSystemStarEnum star = randomChooseStar();
        	//decky = description(star);
        	textField.setText(star.toString());
        };
        final int DELAY = 1000;
        // Milliseconds between timer ticks
        Timer t = new Timer();
        //((Object) t).start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //System.out.println(star);
        String starry = star.toString();
        JTextArea text = new JTextArea(starry);
        //text.add(starry);
		return star;
       // decky = description(star);
       //return decky;

    }	
	/**
	 * This class loads the columns of a JTable of descriptions to properly label which data is what
	 * 
	 */
	   private static String[] loadColumn() {
	    	String[] returnValue = {"Star Name","Mass (KG)","Radius (M)"}; 
			return returnValue;
		}
	   /**
		 * This class loads the rows of data which are present within our information about our stars
		 * 
		 */
		private static String[][] loadData() {
	    	String[][] returnValue = { {"Sun","1.989e+30","6.960e8"},    
		                          {"MERCURY","3.303e+23","2.4397e6"},    
		                          {"VENUS","4.869e+24","6.0518e6"},
		                          {"EARTH","5.976e+24","6.37814e6"},
		                          {"MARS","6.421e+23", "3.3972e6"},
		                          {"JUPITER","1.9e+27",   "7.1492e7"},
		                          {"SATURN","5.688e+26", "6.0268e7"},
		                          {"NEPTUNE","4.869e+24","6.0518e6"},
		                          {"PLUTO","1.2e+22", "1.185e6"},
		                          {"MOON","7.346e+22", "1.736e6"},
		                          {"ASTEROID","1.0e+5", "1.0e2"}};    
			return returnValue;
		}
		/**
		 * This class puts together a JTable full of information on our stars
		 * 
		 */
    public static JScrollPane solarSystemFr() {   
    	JFrame frame = new JFrame();
    	JTable jt;
    	JPanel panel = new JPanel();
        String[][] data = loadData();
	    String[] column = loadColumn();         
	    jt=new JTable(data,column);    
	    //jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);
	    return sp;
	   // panel.add(sp);
	   // frame.add(panel);
	    //frame.setSize(550, 400);
	     // frame.setVisible(true);
	    //jt.add(sp);
    
    }
    /**
	 * This is a hard coded version of our description table for purposes which cannot be directly relayed from a file
	 * @param celestial An enum relating to a name of a star
	 */
    public static String description(SolarSystemStarEnum celestial) {
    	String desc = "to be added";
    	//System.out.println(celestial);
    	switch (celestial) {
    	case SUN:
    		desc = " The Sun is the star at the center of the Solar System";
    		break;
    	case MERCURY:
    		desc = "Mercury is the smallest planet in the Solar System and the closest to the Sun ";
    		break;
    	case VENUS:
    		desc = "Venus is the second planet from the Sun. It is sometimes called Earth's \"sister\" or \"twin\" planet as it is almost as large and has a similar composition. ";
    		break;
    	case EARTH:
    		desc = "Earth is the third planet from the Sun and the only astronomical object known to harbor life. ";
    		break;
    	case MARS:
    		desc = "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System, being larger than only Mercury. ";
    		break;
    	case JUPITER:
    		desc = "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass more than two and a half times that of all the other planets in the Solar System combined, but slightly less than one-thousandth the mass of the Sun. Jupiter is the third brightest natural object in the Earth's night sky after the Moon and Venus, and it has been observed since prehistoric times ";
    		break;
    	case SATURN:
    		desc = "Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter. It is a gas giant with an average radius of about nine and a half times that of Earth.[23][24] It has only one-eighth the average density of Earth; however, with its larger volume, Saturn is over 95 times more massive.";
    		break;
    	case URANUS:
    		desc = "Uranus is the seventh planet from the Sun. ";
    		break;
    	case NEPTUNE:
    		desc = "Neptune is the eighth planet from the Sun and the farthest known solar planet. In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet, and the densest giant planet. ";
    		break;
    	case PLUTO:
    		desc = "Pluto (minor-planet designation: 134340 Pluto) is a dwarf planet in the Kuiper belt, a ring of bodies beyond the orbit of Neptune. It is the ninth-largest and tenth-most-massive known object to directly orbit the Sun. ";
    		break;
    	case MOON:
    		desc = "The Moon is Earth's only natural satellite. Its diameter is about one-quarter the diameter of the Earth (comparable to the width of Australia). ";
    		break;
    	case ASTEROID:
    		desc = "An asteroid is a minor planet of the inner Solar System. Sizes and shapes of asteroids vary significantly, ranging from 1-meter rocks to a dwarf planet almost 1000 km in diameter; they are rocky, metallic or icy bodies with no atmosphere. ";
    		break;
    	default: 
    		;
    	}
    	return desc;
}
    /**
	 * This class puts together our descriptions for our GUI
	 * 
	 */
    public static JTextArea descriptionMaker() {
    	JFrame frame = new JFrame();
    	//solarSystemFrame(); 
    	SolarSystemStarEnum starry = solarTime();
    	//System.out.println(starry);
    	JTextArea area=new JTextArea(description(starry));
    	area.setLineWrap(true);
    	return area;
    	//System.out.println(description(starry));
    	//area.setBounds(100,300,120,30);
    	//frame.add(area);
    	//frame.setSize(550, 400);
	      //frame.setVisible(true); 
    }
    /**
	 * This class puts together all previous elements and properly constructs our UI
	 * 
	 */
    private void createUI() throws IOException {		
		JLabel solarSystemLabel = new JLabel(new ImageIcon(
				"images/order-of-planets-in-the-solar-system.jpg"));
    	
		
		JPanel controlPanel = new JPanel();
		JPanel posPanel = new JPanel();
		JLabel label = new JLabel();
		JTextArea area = new JTextArea();
		SolarSystemStarIcon icon;
	    JButton btn;
		for (SolarSystemStarEnum e : SolarSystemStarEnum.values()) {
			icon = new SolarSystemStarIcon(e);
			//System.out.println(e.toString() + ": " + icon.getRatio()); 
			btn = new JButton(icon);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			stars.add(btn);
			controlPanel.add(btn);
		}
		JScrollPane sp = solarSystemFr();
		SolarSystemStarEnum se = solarTime();
		area = descriptionMaker();
		//label.add(se);
		//Component star = (Component) (se);
		add(controlPanel, BorderLayout.PAGE_END);
		
		add(solarSystemLabel, BorderLayout.CENTER);
		posPanel.add(sp, BorderLayout.LINE_START);
		posPanel.add(area, BorderLayout.CENTER);
		add(posPanel,BorderLayout.LINE_END);
	
	}
    /**
	 * Our main which puts together the finishing touches on our GUI
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		
		JFrame solarSystemFrame = new JFrame("Everett's Nightly Starry Sky");
		JLabel label = new JLabel();
		JLabel labe = new JLabel();
		JLabel solar = new JLabel();
		JScrollPane j;
		solarSystemFrame.setIconImage(new ImageIcon("cover.jpg").getImage());
		SolarSystemStarPanels schP = new SolarSystemStarPanels();
		solarSystemFrame.add(schP, BorderLayout.PAGE_END);
		
		BufferedImage bufferedImage = ImageIO.read(new File("cover.jpg"));
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
		solarSystemFrame.add(label,BorderLayout.PAGE_START);
		
        BufferedImage buffImage = ImageIO.read(new File("order-of-planets-in-the-solar-system.jpg"));
        Image imag = buffImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(imag);
        labe.setIcon(ico);
		solarSystemFrame.add(labe,BorderLayout.CENTER);
		
		JLabel solarSystemLabel = new JLabel(new ImageIcon(
				"order-of-planets-in-the-solar-system.jpg"));
		solarSystemFrame.add(solarSystemLabel,BorderLayout.CENTER); 
		j = solarSystemFr();
		solar.add(solarSystemFr());
		solarSystemFrame.add(solar,BorderLayout.LINE_END);
		
		solarSystemFrame.pack();
		solarSystemFrame.setVisible(true);
		solarSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
