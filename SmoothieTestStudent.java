import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	@Test
	public void testSmoothieToString() {
		Smoothie smoothie = new Smoothie("Strawberry Banana Smoothie", Size.MEDIUM, 2, true);
		String expected = "Strawberry Banana Smoothie, MEDIUM with protien with 2 fruits added.  Price: 5.5";
		assertEquals(expected, smoothie.toString());
	}

	@Test
	public void testSmoothieCalcPrice() {
		Smoothie smoothie = new Smoothie("Mango Smoothie", Size.LARGE, 3, false);
		double expected = 5.5;
		assertEquals(expected, smoothie.calcPrice(), 0.001);
	}

	@Test
	public void testSmoothieEquals() {
		Smoothie smoothie1 = new Smoothie("Green Smoothie", Size.SMALL, 1, true);
		Smoothie smoothie2 = new Smoothie("Green Smoothie", Size.SMALL, 1, true);
		Smoothie smoothie3 = new Smoothie("Berry Smoothie", Size.SMALL, 1, true);

		assertTrue(smoothie1.equals(smoothie2));
		assertFalse(smoothie1.equals(smoothie3));
	}

}
