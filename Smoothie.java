
import java.util.ArrayList;

public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean addProtien;
	private final double proteinprice = 1.5;
	private final double fruitprice = .5;

	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtien) {

		super(bevName, TYPE.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtien = addProtien;

	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getAddProtien() {
		return addProtien;
	}

	@Override
	public String toString() {
		return super.toString() + (addProtien ? " with protien" : "") + " with " + numOfFruits + " fruits added.  "
				+ "Price: " + calcPrice();

	}

	@Override
	public double calcPrice() {
		return super.addSizePrice() + numOfFruits * fruitprice + (addProtien ? proteinprice : 0);

	}

	@Override
	public boolean equals(Object anotherBev) {
		if (!(anotherBev instanceof Smoothie))
			return false;

		Smoothie bev = (Smoothie) (anotherBev);

		if (super.equals(bev) && this.numOfFruits == bev.numOfFruits && this.addProtien == bev.addProtien)
			return true;

		return false;

	}

}
