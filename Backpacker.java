package hw1;

public class Backpacker {
	
	

	private String journal;
	private int firstmoney;
	private City cityname;
	private int nightsintrainstation;
	private int numberpostcardssent;
	public static final int SYMPATHY_FACTOR = 30;
	// the amount of money received is this constant multiplied by the number of postcards the 
	//Backpacker has sent home (since the last time she called home for money). 
	 
	

	
	
	/**
	 * Constructs a Backpacker starting out with the given amount of money in the given city. 
	 * 	The journal is initially a string consisting of "cityname(start)", where cityname is the name of the starting city
	 * @param initialFunds the initial money
	 * @param initialCity the first city
	 */

	public Backpacker(int initialFunds, City initialCity) {
		firstmoney = initialFunds;
		cityname = initialCity;
		journal = cityname.getCityName() + "(start)";
		nightsintrainstation = 0;
		numberpostcardssent = 0;
	}
	
	
	
	/**
	 * Returns the name of the Backpacker's current city. 
	 * @return cityname.getCityName();
	 */
	public String getCurrentCity() {
		return cityname.getCityName();
	}
	
	
	
    /**
     * Returns the amount of money the Backpacker currently has.
     * @return firstmoney;
     */
	public int getCurrentMoney() {
	    return firstmoney;	 
	}
	 
	
	
	
	/**
	 * 	form cityname(number_of_nights) containing the cities visited by the Backpacker,
	 *in the order visited, along with the number of nights spent in each. 
	 *The first value always has the form cityname(start) for the starting city.  
	 *for example, if a Backpacker starts in Paris, spends 5 nights in Rome, and then spends
	 *2 nights in Prague, the journal string would be: 
	 *Paris(start),Rome(5),Prague(2). 
	 * Returns the Backpacker's journal. The journal is a string of comma-separated values of the
	 * @return journal
	 */

	public String getJournal() {
		return journal;
	}
	 
	
	
	/**
	 * Returns true if Backpacker doesn’t have enough money to send postcard from the current city. 
	 * @return fucked 
	 */
	public boolean isSOL() {
		
		
		
		return firstmoney < cityname.postcardCost();
		
	}
	 
	/**
	 *returns the number of nights the Backpacker has spent in a train station when visiting a 
	 *city without enough money for hostels. 
	 * @return nightsintrainstation Thats num of nights there
	 */
	public int getNightsInStation() {
		return nightsintrainstation ;
	}
	 
	
	
	/**
	 * Simulates a visit by this Backpacker to the given city for the given number of nights.
	 * The Backpacker's money is reduced based on the number of nights of hostel booked. When 
	 *the funds are not sufficient for numNights nights of stay in the city, the number of nights 
	 *spent in the train station is updated accordingly. The journal is updated by appending a
	 *comma, the city name, and the number of nights in parentheses. 
	 * @param c An city object to represent the intended city
	 * @param numNights An int to represent the number of desired nights 
	 */
	public void visit(City c, int numNights) {
		cityname = c;
		int numberhostelscansleep;
		int numberhostelswewant = numNights;
		int nights;
		
		numberhostelscansleep = (int)(firstmoney /cityname.hostelCost() );
		
		nights = Math.min(numberhostelscansleep, numberhostelswewant);
		
		firstmoney -= (nights * c.hostelCost());
		nightsintrainstation += numNights - nights;
		
		if (firstmoney <= 0) {
			firstmoney += (numNights * c.hostelCost());
			
			nightsintrainstation += numNights - nights;
		}
		
		journal = journal + "," + c.getCityName() + "(" + String.valueOf(numNights) + ")";
	}
	 
	
	/**
	 * Sends the given number of postcards, if possible, reducing the Backpacker's funds 
	 *appropriately and increasing the count of postcards sent. If there is not enough money,
	 *sends as many postcards as possible without allowing the funds to go below zero. 
	 * 
	 * @param howMany the number of postcards one wishes to send
	 */

	public void sendPostcardsHome(int howMany) {
		int numbercanbuy;
		
		numbercanbuy = (int)(firstmoney /  cityname.postcardCost());
		

		numberpostcardssent += howMany;
		firstmoney -= (howMany * cityname.postcardCost());
		
		if (firstmoney <= 0) {
		
			numberpostcardssent -= howMany;
			firstmoney += (howMany * cityname.postcardCost());
			
			//numbercanbuy = (int)(firstmoney /  cityname.postcardCost());
			
			numberpostcardssent += numbercanbuy;
			firstmoney -= (numbercanbuy * cityname.postcardCost());
			
			

			
			
		}
		
	}
	 
	
	
	
	
	/**
	 *postcards sent since the last call to this method, and resets the count of the number of 
	 *postcards sent back to zero
	 * Increases the Backpacker's funds by an amount equal to SYMPATHY_FACTOR times the number of
	 */

	public void callHomeForMoney() {
		firstmoney += (SYMPATHY_FACTOR *numberpostcardssent);
		
		numberpostcardssent = 0;
	}
}
