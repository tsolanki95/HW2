import java.util.Random;

public class Guest {

	private final String NAME;
	private int numNights;
	private double money;
	private boolean isStaying;

	public Guest(String name, int numNights) {
		this.NAME = name;
		this.numNights = numNights;
		Random generator = new Random();
		money = ((generator.nextDouble()*200.0)+50.0);
		isStaying = true;
	}

	public String getName() {
		return this.NAME;
	}

	public int getNumNights() {
		return this.numNights;
	}

	public double getMoney() {
		return this.money;
	}

	public void incrementNumNights() {
		numNights++;
	}

	public double costOfStay(double nightlyRate) {
		double cost = (nightlyRate * getNumNights());
		return cost;
	}

	public boolean isStaying() {
		return this.isStaying;
	}

	public void setIsStaying(boolean isStaying) {
		this.isStaying = isStaying;
	}

	public String toString() {
		return "Guest['"+getName()+"'] staying["+isStaying()+"] "+getNumNights()
			+" nights.";
	}

}