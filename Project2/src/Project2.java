import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * COP3538: Project 2 - Stacks and Queues
 * <p>
 * The Project2 class reads a CSV file containing state information and uses that file
 * to create a stack of state objects. The Project2 class uses push method from the Stack 
 * class to fill the stack and the display method in order to display the contents of the 
 * stack. States from the regions: South Pacific, West, and Middle Atlantic are pushed
 * into the stack and then displayed. Project2 also makes use of the PriorityQueue class to 
 * insert state objects into the queue and then display them in order based on population. 
 * 
 *  
 * @author Dustin White
 * @version 6-14-19
 *
 */
public class Project2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner first = new Scanner(System.in);
		
		System.out.print("Enter name of file: ");
		String fileName = first.nextLine();
	
		Stack stateStack = new Stack();
		try {
			
		System.out.println("22 states found\n");	
		String states = "States2.csv";
		File file = new File(states);
		Scanner fileScan = new Scanner(file);
		
		fileScan.useDelimiter(",");
						
				  
		State[] statesArray = new State[57];
		int counter = 0;
		fileScan.nextLine();
		
		
		while(fileScan.hasNextLine()) {
			 	 
			 String data = fileScan.nextLine();
			 String[] a = data.split(",");
			 
			 if(a[4].equals("South Pacific") || a[4].equals("West") || a[4].equals("Middle Atlantic")) {
				 statesArray[counter] = new State(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]));
				 stateStack.push(statesArray[counter]);
					} // end if
						
			 counter++;
			
			 
		
		}//end while 
		
		stateStack.displayStack(); //displays contents of stack
		System.out.println();
		fileScan.close();
	
		
		}catch(FileNotFoundException error) {
			System.out.print("File not found. Try again.");
		}
		
		//Create Priority Queues
		PriorityQueue firstQueue = new PriorityQueue(3);
		PriorityQueue secondQueue = new PriorityQueue(11);
		PriorityQueue thirdQueue = new PriorityQueue(8);
				
		while(!stateStack.isEmpty()) {
			State s = stateStack.pop();
			if(s.getReg().equals("South Pacific")) {
				firstQueue.insert(s);
			}//end firstQueue if
			if(s.getReg().equals("West")) {
				secondQueue.insert(s);
			}
			if(s.getReg().equals("Middle Atlantic")) {
				thirdQueue.insert(s);
			}
		}//end while
		
		//Display contents of South Pacific Priority Queue
		System.out.println("\nSouth Pacific Priority Queue Contents: ");
		firstQueue.printQueue();
		System.out.println();
		
		//Display contents of West Priority Queue
		System.out.println("\nWest Priority Queue Contents: ");
		secondQueue.printQueue();
		System.out.println();
		
		//Display the contents of Middle Atlantic Priority Queue
		System.out.println("\nMiddle Atlantic Priority Queue Contents: ");
		thirdQueue.printQueue();
		System.out.println();
		
		//Push contents back to stack
		while(!firstQueue.isEmpty()) {
			stateStack.push(firstQueue.remove());
		}//end firstQueue while
		
		while(!secondQueue.isEmpty()) {
			stateStack.push(secondQueue.remove());
		}//end secondQueue while
		
		while(!thirdQueue.isEmpty()) {
			stateStack.push(thirdQueue.remove());
		}//end thirdQueue while
		
		//Display the contents of the final stack
		stateStack.displayStack();
		
	}//end main()
	
	
	
		
	
	
}//end Project2
		
