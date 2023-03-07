

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;

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
    PLUTO	(1.2e+22, 1.185e6),
    MOON	(7.346e+22, 1.736e6),
    ASTEROID(1.0e+5, 1.0e2);
	
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
     
    // to be modified to retrieve desc from a file
    // using a file accessor class, without using a switch stmt
    public static String description(SolarSystemStarEnum celestial) throws FileNotFoundException {
    	String desc = "to be added";
    	String[] reading;
    	//FileReader read = new FileReader();
    	//System.out.println(celestial);
    	reading = FileRead.getDescription(SUN);
    	switch (celestial) {
    	case SUN:
    		desc = reading[0];
    		break;
    	case MERCURY:
    		desc = reading[1];
    		break;
    	case VENUS:
    		desc = reading[2];
    		break;
    	case EARTH:
    		desc = reading[3];
    		break;
    	case MARS:
    		desc = reading[4];
    		break;
    	case JUPITER:
    		desc = reading[5];
    		break;
    	case SATURN:
    		desc = reading[6];
    		break;
    	case URANUS:
    		desc = reading[7];
    		break;
    	case NEPTUNE:
    		desc = reading[8];   		
    		break;
    	case PLUTO:
    		desc = reading[9];
    		break;
    	case MOON:
    		desc = reading[10];
    		break;
    	case ASTEROID:
    		desc = reading[11];
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
}
