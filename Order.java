 
  
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface , Comparable<Order>{
	private int orderno;
	private int ordertime;
	private Day orderDay; 
	private Customer customer;
	 
	
	private ArrayList<Beverage> beverages;
	
	 
	public Order(int orderTime, 
				Day orderDay,
				Customer cust)
	{
		 
		this.orderno = generateOrder();;
		this.ordertime = orderTime;
		this.orderDay = orderDay;
		customer = new Customer(cust);
		beverages = new ArrayList<Beverage>();
		 
	}
	
	
	 
	public int generateOrder()
	{
		
		Random r = new Random();
		return r.nextInt(900000) + 10000;
		 
	}
	     public int getOrderNo()
    {
    	return orderno;
    }
     
    public int getOrderTime()
    {
    	return ordertime;
    }
     
     public Day getOrderDay()
     {
      	return orderDay;
     }
    
     
    public Customer getCustomer()
    {
    	return new Customer(customer);
     
    }
    
    public Day getDay()
    {
    	return orderDay;
    }
     
	 public boolean isWeekend()
	 {
		 return (orderDay.equals(Day.SATURDAY ) ||  orderDay.equals(Day.SUNDAY ));
	 }

	 
	public Beverage getBeverage(int itemNo) 
	{
		if (beverages.size() == 0)
			return null;
		return beverages.get(itemNo);
	}
	 
	public int getTotalItems() 
	{
		 
		return beverages.size();
	}
	 
	public void  addNewBeverage(
				String bevName,
 				Size size,
				boolean extraShot,
				boolean extraSyrup)
	
	{
		Beverage beverage=null;
		
		 beverage = new Coffee (bevName, 
								size, 
								extraShot,
								extraSyrup );
		beverages.add(beverage);
		
	}
	 
	public void  addNewBeverage( String bevName,
									Size size)		 

	{
		Beverage beverage=null;
		beverage = new Alcohol (bevName, 
								size, 
								isWeekend());
	
		beverages.add(beverage);
	
	}
	 
	public void  addNewBeverage( String bevName,
				Size size,
				int numOfFruits,
				boolean addProtien)		 
	
	{
		Beverage beverage=null;
		beverage = new Smoothie (bevName, 
					size, 
					numOfFruits,
					addProtien);
		
		beverages.add(beverage);
	
	}
	 
	public double calcOrderTotal()
	{
		double total = 0;
		for (Beverage b: beverages)
			total +=b.calcPrice();
		
		return total;
	}
	 
	public int findNumOfBeveType(TYPE type)
	{
		int total = 0;
		for (Beverage b : beverages)
		{
			if (b.getType().equals(type))
				total++;
		}
		return total;
		
	}
	 	 
	 
	public String toString()
	{
		 
		String s =  "Order : " + orderno +
				    ", Time : " + ordertime+
				    ", Day : "  + orderDay +
				    ", Customer " + customer + "\n" ;
		int i = 1;
		for (Beverage b :beverages)
		{
			s += "  " +i + "-" + b + " \n";
			i++;
		}
		s += "\n\nTotal Price on this order: " + calcOrderTotal();
		
		return s;
	}


	@Override
	 
	public int compareTo(Order anotherOrder) {
		if (this.orderno == anotherOrder.orderno)
			return 0;
		
		return ( (this.orderno > anotherOrder.orderno )? 1 : -1 );
	
	}
	 
}
