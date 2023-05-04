import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
 
	@Test
    public void testCalcPrice() {
        Alcohol a1 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol a2 = new Alcohol("Wine", Size.LARGE, true);

        double expected1 = 3.0;  
        double expected2 = 4.6;  
        assertEquals(expected1, a1.calcPrice(), 0.01);
        assertEquals(expected2, a2.calcPrice(), 0.01);
    }
  @Test
    public void testToString() {
        Alcohol a1 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol a2 = new Alcohol("Wine", Size.LARGE, true);

        String expected1 = "Beer, MEDIUMPrice: 3.0";
        String expected2 = "Wine, LARGE Weekend order, Price: 4.6";

        assertEquals(expected1, a1.toString());
        assertEquals(expected2, a2.toString());
    }

    @Test
    public void testEquals() {
        Alcohol a1 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol a2 = new Alcohol("Wine", Size.LARGE, true);
        Alcohol a3 = new Alcohol("Beer", Size.MEDIUM, false);

        assertTrue(a1.equals(a3));
        assertFalse(a1.equals(a2));
    }
}
