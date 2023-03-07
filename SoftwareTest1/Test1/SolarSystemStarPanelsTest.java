import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolarSystemStarPanelsTest
	{
		private SolarSystemStarPanels star;
		private SolarSystemStarEnum stars;
		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testolarSystemFr() {
		star.solarSystemFr();
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRandomChooseStar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDescription() {
		
		star.description(stars);
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testMain() throws IOException {
		star.main(null);
		fail("Not yet implemented"); // TODO
	}

}
