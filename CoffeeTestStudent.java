import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
 
 

class CoffeeTestStudent {
	
	
	
	
	
	
	
	
	
	

	  @Test
	public void testCalcPrice() {
         Coffee c1 = new Coffee("Small coffee", Size.SMALL, false, false);
        assertEquals(2.0, c1.calcPrice(), 0.0);

         Coffee c2 = new Coffee("Medium coffee", Size.MEDIUM, true, false);
        assertEquals(3.5, c2.calcPrice(), 0.0);

         Coffee c3 = new Coffee("Large coffee", Size.LARGE, true, true);
        assertEquals(5.0, c3.calcPrice(), 0.0);
    }
}
