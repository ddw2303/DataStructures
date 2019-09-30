/**
	 * This class builds the state objects. It contains methods for getting
	 * and setting the fields for the state object. 
	 * 
	 * 
	 * @author Dustin White
	 * @version 6-14-19
	 *
	 */
public class State {
				
	private String stateName;
	private String capCity;
	private String abr;
	private int statePop;
	private String stateReg; 
	private int houseSeats;
		
	/**
	 * Constructor for State
	 * 
	 * @param name
	 * @param capital
	 * @param abbreviation
	 * @param population
	 * @param region
	 * @param seats
	 */
	public State(String name, String capital, String abbreviation, int population, String region, int seats) 
	{ 
		
		stateName = name;
		capCity = capital;
		abr = abbreviation;
		statePop = population;
		stateReg = region;
		houseSeats = seats;
		
	}//end State constructor

	/**
	 * This method gets the name of the state.
	 * 
	 * @param 
	 * @return stateName
	 */
	public String getState() {
		
		return stateName;
		
	}//end getState

	/**
	 * This method sets the name of the state.
	 * 
	 * @param state: string
	 */
	public void setState(String state) {
		
		stateName = state;   
		
	}//end setState()

	/**
	 * This method gets the name of a city.
	 * 
	 * @param nothing
	 * @return city: string
	 */
	public String getCity() {
		
		return capCity;
		
	}//end getCity()

	/**
	 * This method sets the name of a city.
	 * 
	 * @param capital: string
	 */
	public void setCity(String capital) {
		
		capCity = capital;
		
	}//end setCity()

	/**
	 * This method gets the abbreviation of a state.
	 * 
	 * @return abr: string
	 * @param nothing
	 */
	public String getAbr() {
		
		return abr;
		
	}//end getAbr()

	/**
	 * This method sets the abbreviation for a state taking
	 * a string as its parameter.
	 * 
	 * @param abbreviation: string
	 */
	public void setAbr(String abbreviation) {
		
		abr = abbreviation;
		
	}//end setAbr()

	/**
	 * This method gets the population of a state.
	 * 
	 * @param none
	 * @return statePop: int
	 */
	public int getPop() {
		
		return statePop;
		
	}//end getPop()

	/**
	 * This method sets the population of a state
	 * taking an integer as its parameter.
	 * 
	 * @param population: int
	 */
	public void setPop(int population) {
		
		statePop = population;
		
	}//end setPop()

	/**
	 * This method gets the region a state is 
	 * located in.
	 * 
	 * @param nothing
	 * @return stateReg: string
	 */
	public String getReg() {
		
		return stateReg;
		
	}//end getReg()

	/**
	 * This method sets the region of a state 
	 * taking a string as its parameter.
	 * 
	 * @param region: string
	 */
	public void setReg(String region) {
		
		stateReg = region;
		
	}//end setReg()

	/**
	 * This method gets the number of seats in the
	 * House of Representatives a state has.
	 * 
	 * @param nothing
	 * @return houseSeats: integer
	 */
	public int getSeats() {
		
		return houseSeats;
		
	}//end getSeats()

	/**
	 * This method sets the number of seats in the
	 * House of Representatives for a state.
	 * 
	 * @param seats: integer
	 */
	public void setSeats(int seats) {
		
		houseSeats = seats;
		
	}//end setSeats()

	/**
	 * This method compares 2 states by name taking a state
	 * as its parameter. If the result is 0, the 2 states are equal.
	 * If the result is positive if the first state is greater than
	 * the second state. If the result is negative, the second state
	 * is greater than the first. 
	 * 
	 * @param name: string
	 * @return integer
	 */
	public int stateComparison(String name) {
		
		return this.getState().compareTo(name);
		
	}//end stateComparison()

	/**
	 * This method prints out the name, capital, abbreviation,
	 * population, region, and number of seats in the House of Representatives.
	 * 
	 * @parameter none
	 * @return string
	 */
	public String stateInfo() {
		
		return stateName + " " + capCity + " " + abr + " " + statePop + " " + stateReg + " " + houseSeats; 
		
	}//end stateInfo()

	


}//end State
