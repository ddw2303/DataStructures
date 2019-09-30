/**
 * This class creates the priority queue which is used by 
 * the Project2 class to store State objects in order based
 * on population. The methods in this class, with the exception
 * of printQueue(), are referenced from "Data Structures and Algorithms in Java", 
 * Second Edition, by Robert LaFore. Pages 147-148.
 * 
 * 
 * @author Dustin White
 * @version 6-14-19
 *
 */
public class PriorityQueue {
	
	private int maxSize;
	private State[] queArray;
	private int nItems;
	
	/**
	 * Constructor for PriorityQueue
	 * 
	 * @param x: integer
	 */
	public PriorityQueue(int x){
		
		maxSize = x;
		queArray = new State[maxSize];
		nItems = 0;
		
	}//end PriorityQueue
	
	/**
	 * Method for inserting State object into the queue
	 * 
	 * @param state: State object
	 */
	public void insert(State state) {
		
		int i;
		
		if(nItems == 0) {
			queArray[nItems++] = state;
		}//end if
		
		else {
			for(i = nItems - 1; i >= 0; i--) {
				if(state.getPop() < queArray[i].getPop()) {
					queArray[i + 1] = queArray[i];
				}//end if
				else {    //done shifting
					break;  
				}//end else
			}//end for
			queArray[i + 1] = state;
			nItems++;
		}//end else
	}//end insert()
	
	/**
	 * Method to remove State object from the queue
	 * 
	 * @return State object
	 */
	public State remove() {
		
		return queArray[--nItems];
		
	}//end remove()
	
	/**
	 * Method that returns true if the queue is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return (nItems == 0);
	}//end isEmpty()
	
	/**
	 * Method that returns true if the queue is full
	 * 
	 * @return
	 */
	public boolean isFull() {
		
		return (nItems == maxSize);
		
	}//end isFull()
	
	/**
	 * Method to print the queue
	 * 
	 */
	public void printQueue() {
		
		System.out.printf("%-28s%-28s%-28s%-28s%-28s%-28s", "Name", "Capital City", "Abbr", "Population", "Region", "US House Seat");
		System.out.println();
		System.out.println("__________________________________________________________________________________________________________________________________________________________");
		
		for(int i = 0; i < queArray.length; i++) {
			System.out.printf("%-28s%-28s%-28s%-28s%-28s%-28s\n", queArray[i].getState(), queArray[i].getCity(), queArray[i].getAbr(), queArray[i].getPop(), queArray[i].getReg(), queArray[i].getSeats());
		}//end for
		
		
	}//end printQueue()

}//end PriorityQueue
