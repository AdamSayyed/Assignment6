import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerStudentTest {

	 @Test
	    public void testGettersAndSetters() {
	        Customer customer = new Customer("John", 30);

	        assertEquals("John", customer.getName());
	        assertEquals(30, customer.getAge());

	        customer.setName("Jane");
	        customer.setAge(35);

	        assertEquals("Jane", customer.getName());
	        assertEquals(35, customer.getAge());
	    }@Test
	    public void testCopyConstructor() {
	        Customer customer = new Customer("John", 30);
	        Customer copy = new Customer(customer);

	        assertEquals("John", copy.getName());
	        assertEquals(30, copy.getAge());
	    }

	    @Test
	    public void testToString() {
	        Customer customer = new Customer("John", 30);

	        assertEquals("name: John, age: 30", customer.toString());
	    }
}
