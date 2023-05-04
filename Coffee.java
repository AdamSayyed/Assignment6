 
import static org.junit.Assert.assertTrue;

 
public class Coffee extends Beverage {
  
	private boolean extraShot;;
 	private boolean extraSyrup;
 	private final double  esp = .5;
 	private final double esyp = .5;
 	 
 	public Coffee(String bevName, 
	 			Size size ,
	 			boolean extraShot, 
	 			boolean extraSyrup) 
 	{
 	 
 		super(bevName, TYPE.COFFEE ,size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
 	 
	public boolean getExtraShot()
	{
		return extraShot;
	}
	 
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
 	
 	 
 	
 	public double calcPrice()
 	{
 		return super.addSizePrice() + ( extraShot ? esp : 0 ) +
 				                         (extraSyrup ?esyp :0 );
 		
 	}
	 
	@Override
	public String toString() {
		return super.toString() + (extraShot ? " with extra shot ": "" ) + 
				(extraSyrup ? " with extra syrup" : "" )+  ", Price: " + 
				calcPrice();
		
	}
	 
	@Override
	public boolean equals(Object anotherBev)
	{
		if   (!( anotherBev instanceof Coffee))
			return false ;
		
		Coffee bev = (Coffee) (anotherBev);
	 
		if (  super.equals(bev) &&
				this.extraShot == bev.extraShot &&
				this.extraSyrup == bev.extraSyrup)
			return true;
		
		return false;
	
	}

}
