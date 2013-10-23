import java.text.NumberFormat;

public class Hotel {

	private final String NAME;
	private double nightlyRate;
	private Guest[] guests;
	private int guestsPointer;
	private int numberOfGuests;

	public Hotel(String name, double nightlyRate) {
		this.NAME = name;
		setRate(nightlyRate);
		guests = new Guest[5];
		guestsPointer = 0;
	}

	public String getName() {
		return this.NAME;
	}

	public double getRate() {
		return this.nightlyRate;
	}

	public int getPointer() {
		return this.guestsPointer;
	}

	public void setRate(double nightlyRate) {
		this.nightlyRate = nightlyRate;
		kickGuests();
	}

	private void kickGuests() {
		if (guestsPointer>0) {
			int stopper = guests.length;
			for(int i = 0;i < stopper;i++) {
				if (guests[i].costOfStay(getRate()) > guests[i].getMoney()) {
					System.out.println(guests[i]+" does not have enough money to stay. He's leaving");
					guests[i].setIsStaying(false);
				}
			}
		}
	}

	public void addGuest(Guest newGuest) {
		if(guestsPointer != guests.length) {
			guests[guestsPointer] = newGuest;
			guestsPointer++;
		} else {

			kickGuests();

			int counter = getPointer()-1;
			boolean done = false;
			while(counter >= 0&&!done) {
				if(!guests[counter].isStaying()) {
					System.out.println(guests[counter].getName()+" is being replaced by "+
						newGuest.getName()+".");
					guests[counter] = newGuest;
					done = true;
				} else {
					counter--;
				}
			}

			if(counter == -1) {
				System.out.println("Sorry, the hotel is booked.");
			}
		}
	}

	public boolean isFull() {
		if(guestsPointer != 5) {
			return false;
		} else {
			for(int i = 0;i < 5;i++) {
				if(!guests[i].isStaying()) {
					return false;
				}
			}
		}
		return true;
	}

	public double getProfit() {
		double profit = 0.0;
		for(int i = 0;i < guestsPointer;i++) {
			if(guests[i].isStaying()) {
				profit += guests[i].costOfStay(getRate());
			}
		}

		return profit;
	}

	public void delayFlights() {
		System.out.println("All flights have been delayed.");
		for(int i = 0;i < guestsPointer;i++) {
			guests[i].incrementNumNights();
		}
		kickGuests();
	}

	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String toStr = "Hotel["+getName()+"]. Current rate of "+formatter.format(getRate())+
			" per night.\n"+getName()+" will currently make "+formatter.format(getProfit())+
			" per night. "+guestsPointer+" guests:\n";
		for(int i = 0;i < guestsPointer; i++) {
			toStr += guests[i]+"\n";
		}
		return toStr;
	}

}