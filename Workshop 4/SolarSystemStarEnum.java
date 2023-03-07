import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public enum SolarSystemStarEnum {
//	Sun, Mercury, Venus, Earth, Mars, Jupiter, Neptune, Saturn, Uranus, Pluto, Moon, Asteroid;
	SUN		(1.989e+30, 6.960e8),
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    NEPTUNE (1.024e+26, 2.4746e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    Pluto	(1.2e+22, 1.185e6),
    Moon	(7.346e+22, 1.736e6),
    Asteroid(1.0e+5, 1.0e2);
	
    private final double mass;   // in kilograms
    private final double radius; // in meters
    SolarSystemStarEnum(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    
    public double mass() { 
    	return mass; 
    }
    
    public double radius() { 
    	return radius; 
    }
     
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
    	case Pluto:
    		desc = "Pluto (minor-planet designation: 134340 Pluto) is a dwarf planet in the Kuiper belt, a ring of bodies beyond the orbit of Neptune. It is the ninth-largest and tenth-most-massive known object to directly orbit the Sun. ";
    		break;
    	case Moon:
    		desc = "The Moon is Earth's only natural satellite. Its diameter is about one-quarter the diameter of the Earth (comparable to the width of Australia). ";
    		break;
    	case Asteroid:
    		desc = "An asteroid is a minor planet of the inner Solar System. Sizes and shapes of asteroids vary significantly, ranging from 1-meter rocks to a dwarf planet almost 1000 km in diameter; they are rocky, metallic or icy bodies with no atmosphere. ";
    		break;
    	default: 
    		;
    	}
    	return desc;
}
    
    public static SolarSystemStarEnum randomChooseStar() {
    	Random r = new Random(System.currentTimeMillis());
    	int index = r.nextInt(SolarSystemStarEnum.values().length);
    	return SolarSystemStarEnum.values()[index];
    }
    private static String[] loadColumn() {
    	String[] returnValue = {"Star Name","Mass (KG)","Radius (M)"}; 
		return returnValue;
	}

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

    public static void solarFrame()
    {
    	JFrame frame = new JFrame();
    	final int FIELD_WIDTH = 20;
    	JTextField textField = new JTextField(FIELD_WIDTH);
    
    	 JButton helloButton = new JButton("Say Hello");
    	 helloButton.addActionListener(event -> 
    	 			textField.setText("Hello, World!"));

    	     JButton goodbyeButton = new JButton("Say Goodbye");
    	 goodbyeButton.addActionListener(event -> 
    	 			textField.setText("Goodbye, World!"));


        textField.setText("Click a button!");

        frame.setLayout(new FlowLayout());

        frame.add(helloButton);
        frame.add(goodbyeButton);
        frame.add(textField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
    public static SolarSystemStarEnum solarTime()
    {
    	JFrame frame = new JFrame();
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
        Timer t = new Timer(DELAY, listener);
        t.start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //System.out.println(star);
		return star;
       // decky = description(star);
       //return decky;

    }
    
    public static void solarSystemFrame() {   
    	JFrame frame = new JFrame();
    	JTable jt;
    	JPanel panel = new JPanel();
        String[][] data = loadData();
	    String[] column = loadColumn();         
	    jt=new JTable(data,column);    
	    //jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);  
	    panel.add(sp);
	    frame.add(panel);
	    frame.setSize(550, 400);
	      frame.setVisible(true);
	    //jt.add(sp);
    
    }
    
    public static void descriptionMaker() {
    	JFrame frame = new JFrame();
    	solarSystemFrame(); 
    	SolarSystemStarEnum starry = solarTime();
    	//System.out.println(starry);
    	JTextArea area=new JTextArea(description(starry));
    	area.setLineWrap(true);
    	System.out.println(description(starry));
    	//area.setBounds(100,300,120,30);
    	frame.add(area);
    	frame.setSize(550, 400);
	      frame.setVisible(true); 
    }
    public static void main(String[] args) {
		
		/*for (SolarSystemStarEnum sse : SolarSystemStarEnum.values()) {
			System.out.println(sse + "=" + sse.name() + "@" + sse.ordinal());
			System.out.println("\t" + sse.toString() + "=" + SolarSystemStarEnum.EARTH
					 + ":" + sse.equals(SolarSystemStarEnum.EARTH));
		}*/
    	
    	descriptionMaker();
    	//JFrame frame = new JFrame();
    	//JPanel panel=new JPanel();  
    	
    	//System.out.println(randomChooseStar());
    	//solarSystemFrame(); 
    	//SolarSystemStarEnum starry = solarTime();
    	//System.out.println(starry);
    	//JTextArea area=new JTextArea(description(starry));
    	//System.out.println(description(starry));
    	//area.setBounds(100,300,120,30);
    	//frame.add(area);
    	// frame.setSize(300,300);  
        // frame.setLayout(null);  
         //frame.setVisible(true);  
    	//panel.add(description(starry));
    	//solarFrame();
    	/*JPanel f = new JPanel();
    	JTable jt;
        String[][] data = loadData();
	    String[] column = loadColumn();         
	    jt=new JTable(data,column);           
	    JScrollPane sp=new JScrollPane(jt);  
    	f.add(sp);
    	f.setSize(550, 400);
        f.setVisible(true);*/
    	
	}
}


