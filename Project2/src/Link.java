/**
 * This class creates the initial link to be used in the 
 * LinkList class. The methods in this class are referenced 
 * from "Data Structures and Algorithms in Java", Second Edition,
 * by Robert LaFore. Pages 203-206.
 * 
 * 
 * @author Dustin White
 *@version 6-14-19
 */
public class Link {
	public State d;
	public Link next;


/**
 * Constructor for Link
 * 
 * @param s: State object
 */
public Link(State s) {
	d = s;
}//end Link()

/**
 * Method to display a link
 * 
 */
public void linkDisplay() {
	System.out.print(d + " ");
}//end linkDisplay()

}//end class Link
