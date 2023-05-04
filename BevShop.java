 

/**
 * Represent a Beverage shop
 */
import java.util.ArrayList;

public class BevShop implements BevShopInterface {

	private int numOfAlcoholDrink;
	public ArrayList<Order> orders;

	/**
	 * default Constructor Initializes a BevShop Object
	 */

	public BevShop() {
		orders = new ArrayList<Order>();
		numOfAlcoholDrink = 0;
	}

	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * 
	 * @param time
	 *            time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean validTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}

	/**
	 * returns the constant value for the minimum age for offering Alcohol drink
	 * 
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMaxNumOfFruits() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * returns the constant value for the Maximum age for offering Alcohol drink
	 * 
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 * 
	 * @param numOfFruits
	 *            number of fruits
	 * @return true if the passed parameter exceeds the MAXIUM number of fruits
	 *         allowed for the SMOTHIE drink, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}

	/**
	 * returns constant maximum number of alcohol beverages/per order offered by
	 * the beverage shop
	 * 
	 * @return constant maximum number of alcohol beverages/per order offered by
	 *         the beverage shop
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * checks if the number of alcohol beverages for the current order has
	 * reached the maximum
	 * 
	 * @return true if number of alcohol drinks for the current order has
	 *         reached the maximum , false otherwise
	 */
	public boolean eligibleForMore() {

		if (numOfAlcoholDrink == MAX_ORDER_FOR_ALCOHOL)
			return false;
		return true;

	}

	/**
	 * returns the number of alcohol drinks for the current order
	 * 
	 * @return returns the number of alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}

	/**
	 * check the valid age for the alcohol drink
	 * 
	 * @param age
	 *            the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	public boolean validAge(int age) {
		return (age > MIN_AGE_FOR_ALCOHOL);
	}

	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 * 
	 * @param time
	 *            time of the order
	 * @param day
	 *            day of the order of type DAY
	 * @param customerName
	 *            customer name
	 * @param customerAge
	 *            customer age
	 */

	public void startNewOrder(int time, Day day, String customerName, int customerAge)

	{
		numOfAlcoholDrink = 0;
		Customer customer = new Customer(customerName, customerAge);

		Order newOrder = new Order(time, day, customer);

		orders.add(newOrder);

	}

	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 * 
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Order order = orders.get(orders.size() - 1);
		order.addNewBeverage(bevName, size, extraShot, extraSyrup);

	}

	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 * 
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size) {

		Order order = orders.get(orders.size() - 1);

		order.addNewBeverage(bevName, size);

		numOfAlcoholDrink++;

	}

	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 * 
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtien
	 *            true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtien) {
		Order order = orders.get(orders.size() - 1);
		order.addNewBeverage(bevName, size, numOfFruits, addProtien);

	}

	/**
	 * locate an order based on the order number
	 * 
	 * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++)
			if ((orders.get(i).getOrderNo()) == orderNo)
				return i;
		return -1;
	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 * 
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
		int n = findOrder(orderNo);
		return orders.get(n).calcOrderTotal();
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * 
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double total = 0;
		for (Order o : orders)

			total += o.calcOrderTotal();
		return total;

	}

	/**
	 * returns total numbers of orders within the month
	 * 
	 * @returns total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {

		return orders.size();
	}

	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 * 
	 * @return the current order
	 */
	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}

	/**
	 * returns Order in the list of orders at the index Notes: this method
	 * returns the shallow copy of the order
	 * 
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders()

	{

		int min, size;
		Order temp;
		size = orders.size();
		for (int index = 0; index < size; index++) {
			min = index;
			for (int scan = index + 1; scan < size; scan++)
				if (orders.get(scan).compareTo(orders.get(min)) < 0)
					min = scan;

			// Swap the values
			temp = orders.get(min);
			orders.set(min, orders.get(index));

			orders.set(index, temp);
		}

	}

	/**
	 * returns the string representation of all the orders and the total monthly sale
	 * 
	 * @return returns the information of all the orders
	 */
	public String toString() {
		String s = "";
		int i = 1;
		for (Order o : orders) {

			s += i + ")" + o.toString() + "\n\n";
			i++;
		}

		s += "Totlal Monthly sale : " + totalMonthlySale();
		return s;
	}
}
