
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class BevShopTest {

	public BevShop bevShop = new BevShop();

	@Before
	public void setUp() {
		bevShop = new BevShop();
	}

	@Test
	public void testValidTime() {
		assertTrue(bevShop.validTime(8));
		assertTrue(bevShop.validTime(12));
		assertTrue(bevShop.validTime(23));
		assertFalse(bevShop.validTime(7));
		assertFalse(bevShop.validTime(24));
	}

	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(21, bevShop.getMaxNumOfFruits());
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(21, bevShop.getMinAgeForAlcohol());
	}

	@Test
	public void testIsMaxFruit() {

		assertTrue(bevShop.isMaxFruit(22));
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(3, bevShop.getMaxOrderForAlcohol());
	}

	@Test
	public void testEligibleForMore() {
		assertTrue(bevShop.eligibleForMore());

		assertTrue(bevShop.eligibleForMore());
	}

	@Test
	public void testValidAge() {
		assertFalse(bevShop.validAge(20));
		assertFalse(bevShop.validAge(21));
		assertTrue(bevShop.validAge(30));
	}

	@Test
	public void testStartNewOrder() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
		ArrayList<Order> orders = bevShop.orders;
		assertEquals(1, orders.size());
		Order order = orders.get(0);
		assertEquals(10, order.getOrderTime());
		assertEquals(Day.MONDAY, order.getDay());
		assertEquals("John", order.getCustomer().getName());
		assertEquals(25, order.getCustomer().getAge());

	}

}
