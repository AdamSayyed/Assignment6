import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTestStudent {

	
	
	
	
	
	
	
	 @Test
	    public void testAddNewBeverage() {
	        Order order = new Order(10, Day.MONDAY, new Customer("John" ,44));

	        // Add a new coffee beverage
	        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
	        assertEquals(1, order.getTotalItems());

	        // Add a new alcohol beverage
	        order.addNewBeverage("Beer", Size.LARGE);
	        assertEquals(2, order.getTotalItems());

	        // Add a new smoothie beverage
	        order.addNewBeverage("Fruit Smoothie", Size.SMALL, 3, true);
	        assertEquals(3, order.getTotalItems());
	    }
	 @Test
	    public void testCalcOrderTotal() {
	        Order order = new Order(18, Day.SATURDAY, new Customer("Jane",44));

	        // Add a few beverages to the order
	        order.addNewBeverage("Cappuccino", Size.LARGE, false, true);
	        order.addNewBeverage("Margarita", Size.SMALL);
	        order.addNewBeverage("Banana Smoothie", Size.MEDIUM, 2, false);

	        // Calculate the total cost of the order
	        double total = order.calcOrderTotal();
	        assertEquals(11.1, total, 0.01);
	    }
}
