import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * COP3538: Project 1 - Array Searches and Sorts
 * <p>
 * The Project1 class reads a CSV file containing state information and uses that file to 
 * create an array of state objects. It offers the user a menu with six choices. The first 
 * choice prints a report with all of the information contained in the States1.csv file. 
 * Options 2, 3, and 4 sort the report using Bubble Sort, Selection Sort, and Insertion Sort
 * respectively. 
 * <p>
 * After user chooses to sort the report, they then choose option 1 to run the report
 * in its sorted form. Option 5 allows the user to search for a capital city and uses
 * Binary Search or Sequential Search depending if the report is sorted or not. Option
 * 6 allows the user to exit the program.
 * 
 * @author Dustin White
 * @version 05-31-19
 *
 */
public class Project1 {
	
	
	/**
	 * The main method read and parses the States1.csv file using a delimiter  
	 * to split it into an array of State objects. 
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner first = new Scanner(System.in);
		
		System.out.print("Enter name of file: ");
		String fileName = first.nextLine();
		
		try {
			
		System.out.println("56 states found\n");	
		String states = "States1.csv";
		File file = new File(states);
		Scanner fileScan = new Scanner(file);
		fileScan.useDelimiter(",");
						
				  
		State[] statesArray = new State[56];
		int counter = 0;
		fileScan.nextLine();
		
		
		while(fileScan.hasNextLine()) {
			 			 
			 String data = fileScan.nextLine();
			 String[] a = data.split(",");
			 statesArray[counter] = new State(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]));
					
			 counter++;
			
			 
		
		}//end while 
		fileScan.close();
		
		Scanner user = new Scanner(System.in);
		
		
		
		while(true) {
			Menu();
			
		int selection = user.nextInt();
		
		switch(selection) {
		
		case 1:
			printReport(statesArray);
			System.out.println(" ");
			break;
		
				
		case 2:
			sortName(statesArray);
			break;
			
		case 3:
			sortPopulation(statesArray);
			break;
			
		case 4:
			sortCity(statesArray);
			break;
			
		case 5:
			System.out.print("Enter name of capital: ");
			
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			
			
			if(true) {
				binarySearch(statesArray, name);
			}
			else {
			   sequentialSearch(statesArray, name);
			}
			
			
			break;
		case 6:
			user.close();
			System.out.println("Have a great day!");
			System.exit(0);
			
		default:
			
			while(selection < 1 || selection > 6) {
				System.out.println("Invalid choice. Choose a valid option 1-6. \n");
				
			
			try {
				System.out.print("Choose an option: ");
				int num = user.nextInt();
			}
			catch(RuntimeException ime){
				System.out.println("Invalid choice. Choose a valid option 1-6");
			}
			break;
			} // end while
			
				}// end switch
			} // end while
		
				
		}catch(FileNotFoundException error) {
			System.out.println("File not found. Please try another file");
		}//end catch
		
		

	}//end main()
	
	/**
	 * Method that displays the menu for the user
	 * 
	 * @param none
	 */
	public static void Menu() {
				
		System.out.println("1. Print a state report");
		System.out.println("2. Sort by state name");
		System.out.println("3. Sort by population");
		System.out.println("4. Sort by capital");
		System.out.println("5. Find and print a given state");
		System.out.println("6. Quit");
		System.out.print("Choose an option: ");
		
	}//end Menu()
	
	public static void printReport(State[] stateArray) {
		
		System.out.printf("%-28s%-28s%-28s%-28s%-28s%-28s", "Name", "Capital City", "Abbr", "Population", "Region", "US House Seat");
		System.out.println();
		System.out.println("__________________________________________________________________________________________________________________________________________________________");
		
		for(int i = 0; i < stateArray.length; i++) {
			System.out.printf("%-28s%-28s%-28s%-28s%-28s%-28s\n", stateArray[i].getState(), stateArray[i].getCity(), stateArray[i].getAbr(), stateArray[i].getPop(),  
			stateArray[i].getReg(), stateArray[i].getSeats());
			
		}//end printReport()
		
		
	}//end printReport()
	
	/**
	 * Method sorts states in alphabetical order using Bubble Sort taking
	 * the State array as a parameter. 
	 * 
	 * @param statesArray
	 */
	public static void sortName(State[] statesArray) {
		int outer, inner;
		
		for( outer = statesArray.length - 1; outer > 1; outer--) { //outer loop (going backward)
			for(inner = 0; inner < outer; inner++) { //inner loop (going forward)
				if(((statesArray[inner].getState()).compareTo(statesArray[outer].getState())) > 0) { //if out of order
					State temp = statesArray[outer]; //swap items
					statesArray[outer] = statesArray[inner];
					statesArray[inner] = temp;
				}
			}
		}
		System.out.println("\nStates are now sorted by name.\n");
		
	}//end nameBubbleSort()
	
	/**
	 * Method sorts states by population using Selection Sort taking 
	 * the State array as a parameter. 
	 * 
	 * @param statesArray
	 */
	public static void sortPopulation(State[] statesArray) {
		
		int outer, inner;
		for(outer = 0; outer < statesArray.length - 1; outer++) { //outer loop
			int lowest = outer;
			for(inner = outer + 1; inner < statesArray.length; inner++) { //inner loop
				if(statesArray[inner].getPop() < statesArray[lowest].getPop()) {
					lowest = inner; //new lower
				}
				if(lowest != outer) { //swap items
					State temp = statesArray[lowest];
					statesArray[lowest] = statesArray[outer];
					statesArray[outer] = temp;
				}//end if
			}//end inner loop
		}//end outer loop
		System.out.println("\nStates are now sorted by population.\n");
		
	}//end sortPopulation()
	
	/**
	 * Method sorts states in alphabetical order of capital city 
	 * using Insertion Sort taking the statesArray as an argument.
	 * 
	 * @param statesArray: array
	 */
	public static void sortCity(State[] statesArray) {
		
		int inner, outer;
		for(outer = 1; outer < statesArray.length; outer++) { //outer is dividing line
			 State temp = statesArray[outer]; //removed marked item
			 inner = outer - 1; //start shifts at outer
			 while((inner >= 0) && (statesArray[inner].getCity().compareTo(temp.getCity()) > 0)) {
				 statesArray[inner + 1] = statesArray[inner];
				 inner--;
			 }//end while
			statesArray[inner + 1] = temp; //insert marked items
		}//end for
		
	}//end sortCity()
	
	/**
	 * This method searches for city name using the Sequential Search method. It 
	 * takes the statesArray and a string as its parameters.
	 * 
	 * @param statesArray
	 * @param city
	 * @return
	 */
	public static void sequentialSearch(State[] statesArray, String city) {
		
		
		int i;
		for(i = 0; i < statesArray.length - 1; i++) { //for each element
			
			if(statesArray[i].getCity().equals(city)) {
				
				System.out.println("Name: " + statesArray[i].getState() + "\n");
				System.out.println("Capital City: " + statesArray[i].getCity() + "\n");
				System.out.println("Abbr: " + statesArray[i].getAbr() + "\n");
				System.out.println("Population: " + statesArray[i].getPop() + "\n");
				System.out.println("Region: " + statesArray[i].getReg() + "\n");
				System.out.println("US House Seats: " + statesArray[i].getSeats() + "\n");
				
			}
			else {
				System.out.println(city + " is not a capital. Enter a valid capital.\n"); //the city was not found
				break;
				
			}//end if
									
		}//end for
		
	}//end linearSearch()
	
	/**
	 * This method locates a capital city using Binary Search.
	 * 
	 * @param statesArray
	 * @param city
	 * @return located
	 */
	public static boolean binarySearch(State[] statesArray, String city) {
		
		int lowerBound = 0;
		int upperBound = statesArray.length - 1;
		int mid;
		boolean located = true;
		
		while(lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;
			
			if(city.equals(statesArray[mid].getCity())){ //found the city
				System.out.printf("%-15s%-15s\n","Name: ", statesArray[mid].getState());
				System.out.printf("%-15s%-15s\n","Capital City: ", statesArray[mid].getCity());
				System.out.printf("%-15s%-15s\n","Abbr: ", statesArray[mid].getAbr());
				System.out.printf("%-15s%-15s\n","Population: ", statesArray[mid].getPop());
				System.out.printf("%-15s%-15s\n","Region: ", statesArray[mid].getReg());
				System.out.printf("%-15s%-15s\n","US House Seats: ", statesArray[mid].getSeats() + "\n");
				break;
			}//end if
			else if((statesArray[mid].getCity().compareTo(city)) > 0) {
				lowerBound = mid + 1; //city is in upper half
			}//end else if
			else {
				upperBound = mid - 1; //city is in lower half
			}//end else 
		}//end while
		return located;
		
	}//end binarySearch()
	
}//end class Project1

