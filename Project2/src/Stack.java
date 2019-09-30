
/**
 * This class creates the stack that will be used by the
 * Project2 class to store State objects. The methods in this 
 * class are referenced from "Data Structures and Algorithms in Java", 
 * Second Edition, by Robert LaFore. Page 204.
 * 
 * 
 * @author Dustin White
 * @version 6-14-19
 *
 */
public class Stack {
	
	private LinkList stateList;
	private int num;
	
	
	/**
	 * Constructor for Stack
	 * 
	 */
	public Stack() {
		
		stateList = new LinkList();
		num++;
		
	}//end Stack()
	
	/**
	 * Method to determine if the stack is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		
		
		return (stateList.isEmpty());
		
	}//end isEmpty()
	
	
	/**
	 * Method to push a State object onto the stack
	 * 
	 * @param s: State object
	 */
	public void push(State s) {
		
		stateList.firstInsert(s);
		num++;
		
		
	}//end push()
	
	/**
	 * Method to remove a state object from the stack
	 * 
	 * @return State object
	 */
	public State pop() {
		
		num--;
		return stateList.firstDelete();
		
		
				
	}//end pop()
	
	/**
	 * Method to display the stack
	 * 
	 */
	public void displayStack() {
		
		
		System.out.println("Stack contents: ");
				
		System.out.printf("%-28s%-28s%-28s%-28s%-28s%-28s", "Name", "Capital City", "Abbr", "Population", "Region", "US House Seat");
		System.out.println();
		System.out.println("__________________________________________________________________________________________________________________________________________________________");
				
		stateList.listDisplay();
		
	}//end displayStack()
	
	/**
	 * Method to determine if the stack is full
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		
		return(!stateList.isEmpty() && stateList.size() >= 57);
		
				
	}//end isFull()
		

}//end Stack
