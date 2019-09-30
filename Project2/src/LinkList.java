/**
 * This class creates the Linked List that is used to
 * build the stack of State objects. The methods in this 
 * class are referenced from "Data Structures and Algorithms in Java", 
 * Second Edition, by Robert LaFore. Pages 203-206.
 * 
 * 
 * @author Dustin White
 * @version 6-14-19
 *
 */
public class LinkList {
	
	private Link first;
	
	
	/**
	 * Constructor for LinkList
	 */
	public LinkList() {
		
		first = null;
	}//end LinkList()
	
	/**
	 * Method to determine if the list is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		
		return(first == null);
	}//end isEmpty()
	
	/**
	 * Method to insert a State object into the list
	 * 
	 * @param s: State object
	 */
	public void firstInsert(State s) {
		
		Link newLink = new Link(s);
		newLink.next = first;
		first = newLink;
		
		
	}//end firstInsert()
	
	/**
	 * Method to delete a link
	 * 
	 * @return temp: Link
	 */
	public State firstDelete() {
		
		Link temp = first;
		first = first.next;
		return temp.d;
	}//end firstDelete()
	
	/**
	 * Method to display the linked list
	 * 
	 */
	public void listDisplay() {
		
		Link current = first;
		while(current != null) {
			
			current.linkDisplay();
			current = current.next;
		}//end while
		System.out.println("");
	
	}//end listDisplay()
	
	/**
	 * Method to retrieve the size of the linked list
	 * 
	 * @return size: int
	 */
	public int size() {
		int size = 0;
		Link current = first;
		while(current != null) {
			current = current.next;
			size++;
		}
		return size;
	}
	
	

}//end LinkList
