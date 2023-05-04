
public class Alcohol extends Beverage {

	
	/*
	 * Class: CMSC203 
	 * Instructor:
	 * Description: (Give a brief description for each Class)
	 * Due: MM/DD/YYYY
	 * Platform/compiler:
	 * I pledge that I have completed the programming 
	 * assignment independently. I have not copied the code 
	 * from a student or any source. I have not given my code 
	 * to any student.
	   Print your Name here: Adam Sayyed
	*/

	
	private boolean isweekend;
	private final double WEEKEND_PRICE = .6;

	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, TYPE.ALCOHOL, size);
		this.isweekend = isWeekend;
	}

	@Override
	public double calcPrice() {

		return super.addSizePrice() + (isweekend ? WEEKEND_PRICE : 0);

	}

	@Override
	public String toString() {
		return super.toString() + (isweekend ? " Weekend order, " : "") + "Price: " + calcPrice();

	}

	@Override
	public boolean equals(Object anotherBev) {
		if (!(anotherBev instanceof Alcohol))
			return false;

		Alcohol bev = (Alcohol) (anotherBev);

		if (super.equals(bev) && this.isweekend == bev.isweekend)
			return true;

		return false;

	}

}
