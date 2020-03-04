   

package hw1;

public class City {
	
	// required instance variables
	private String thiscity;
	private int hostelcostpernight;
	public static final double POSTCARD_COST = 0.05; 
	
	//Note
	// currency of the hostels is euros
	// several accessor methods but not mutator
	
	/**
	 * The city constructor helps initialize all the required instance variables
	 * @param givenCityName , the name of the users initial city
	 * @param givenHostelCost , the name of that hostel's cost per night
	 */
	public City(String givenCityName, int givenHostelCost) {
		thiscity = givenCityName;
		hostelcostpernight = givenHostelCost;
	}
	
	/**
	 * the getCityName() method returns this city's name.
	 * An accessor method with no parameters
	 * @return thiscity
	 */
	public String getCityName() {
    	return thiscity;
     
    }
    
    
	/**
	 * Returns this city's hostel cost per night.
	 * Is an accessor method with no parameters
	 * @return hostelcostpernight
	 */
    public int hostelCost() {
        return hostelcostpernight;
    }
 
    


/**
    *  Returns the cost to send a postcard from this city. The value is a percentage of the lodging
    *  cost specified by the constant POSTCARD_COST, rounded to the nearest integer.
    *  Is an accessor method with no parameters
    * @return rounded This is cost of sending a postcard 
    */
    public int postcardCost() {
    	// formula for the price calculation
      	double price = (POSTCARD_COST * hostelcostpernight);
      	
      	//created a long variable to save the rounded cost that happens to be of long type
      	long rounded = Math.round(price); 

      	
      	// casted it as an int causes thats what is requied
        return (int)rounded;
    }
 
    
    
    
    /**
     * Returns the number of nights of hostel stay in this city that a Backpacker could afford with the given amount of money. 
     * @param moneyAvailable , The amount of money that the user has at a particular time
     * @return numberofnights , this is the number of nights the person is able to stay at the hostel
     */

    public int nightsStay(int moneyAvailable) {
    	int numberofnights;
    	
    	numberofnights = (moneyAvailable / hostelcostpernight);
    	
	    return numberofnights;
    }
	
    
    /**
     * Returns the number of postcards that a Backpacker could afford to send from this city with 
     * @param moneyAvailable the money available
     * @return postcardsfromyou the number to send
     */
    //the given amount of money. 
    public int numPostcards(int moneyAvailable) {
    	int postcardstoyou;
    	
    	postcardstoyou = (moneyAvailable / postcardCost());
    	
    	return postcardstoyou;
    }
    	
	
	
	
	

}
