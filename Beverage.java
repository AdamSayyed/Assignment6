 
 

public abstract class Beverage {
	 
	private String bevName;
	private TYPE type;
	private Size size;
 	private final double sizeprice = 1.0;  
	private final double baseprice = 2.0;  
	
	 
	public Beverage(String bevName, TYPE type ,Size size )
	{
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	 
	public double getBasePrice()
	{
		 
		return baseprice;
	}
	 
	public TYPE getType()
	{
		return type;
	}
	 
	public String getBevName()
	{
		return bevName;
	}
	 
	public Size getSize()
	{
		return size;
	}
	 
	public double addSizePrice()
	{
		double	price = 0;
		switch (size)
		{
			 
			case SMALL:
			 	price = baseprice;
				break;
			case  MEDIUM:
				price  = baseprice + sizeprice;
				break;
			case  LARGE:
				price  = baseprice +  2* sizeprice;
				break;
				
		}
		return price;
		
		
	}
	 
	public String toString()
	{
		return bevName + ", "  + size ;
	}
	
	 
	@Override
	public boolean equals(Object anotherBev)
	{
		if   (!( anotherBev instanceof Beverage))
			return false ;
		
		Beverage bev = (Beverage)anotherBev;
	 
		if (  this.bevName.equals(bev.bevName) &&
				this.size.equals(bev.size)   &&
				this.type.equals(bev.type)  )
			return true;
		
		return false;
	
	}

	 
 	public abstract  double calcPrice();
}
