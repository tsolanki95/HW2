import java.util.Scanner;

public class HotelDriver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Hotel hotel = createHotel();
		boolean done = false;
		do {
			populateHotel(hotel);
			System.out.println(hotel+"\n");
			delayFlights(hotel);
			System.out.println(hotel+"\n");
			changeNightlyRate(hotel);
			System.out.println(hotel+"\n");
			System.out.println("woudl you like to continue (yes or no)?");
			
			boolean done2 = false;
			do {
				String answer = keyboard.next();
				answer = answer.toLowerCase();
				if (answer.equals("yes")) {
					System.out.println("As you wish");
					done2 = true;
				} else if (answer.equals("no")) {
					System.out.println("Your call");
					done = true;
					done2 = true;
				} else {
					System.out.println("Incorrect input, try again. Please enter either yes"+
						" or no.");
				}
			} while (!done2);
		} while (!done);
	}

	private static Hotel createHotel() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the name of your hotel?");
		String hotelName = keyboard.nextLine();
		System.out.println("What is the starting rate?");
		double rate = keyboard.nextDouble();
		return new Hotel(hotelName, rate);
	}

	private static void populateHotel(Hotel hotel) {
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		while(!hotel.isFull()) {
			System.out.println("Enter the guest's name(or quit to continue):");
			input = keyboard.nextLine();
			if (input.toLowerCase().equals("quit")) {
				break;
			}
			System.out.println("And how many nights are you staying, "+input+"?");
			int numNights = keyboard.nextInt();
			keyboard.nextLine();
			hotel.addGuest(new Guest(input, numNights));
		}	
	}

	private static void delayFlights(Hotel hotel) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to delay the flights (yes or no)?");
		
		boolean done = false;
		do {
			String answer = keyboard.next();
			answer = answer.toLowerCase();
			if (answer.equals("yes")) {
				System.out.println("As you wish");
				hotel.delayFlights();
				done = true;
			} else if (answer.equals("no")) {
				System.out.println("Your call");
				done = true;
			} else {
				System.out.println("Incorrect input, try again. Please enter either yes"+
					" or no.");
			}
		} while (!done);
	}

	private static void changeNightlyRate(Hotel hotel) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to change the nightly rate (yes or no)?");
		
		boolean done = false;
		do {
			String answer = keyboard.next();
			answer = answer.toLowerCase();
			if (answer.equals("yes")) {
				System.out.println("What should be the new nightly rate?");
				double rate = keyboard.nextDouble();
				hotel.setRate(rate);
				done = true;
			} else if (answer.equals("no")) {
				System.out.println("Your call");
				done = true;
			} else {
				System.out.println("Incorrect input, try again. Please enter either yes"+
					" or no.");
			}
		} while (!done);
	}
}