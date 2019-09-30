import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * COP3538: Project 3 - Binary Search Trees
 * <p>
 * The Project3 class reads a CSV file containing state information and uses that file
 * to create a binary search tree of state objects. The Project3 class uses the insert()
 * method to build the binary search tree.  It then prints out the results of inorder 
 * traversal using the traversal() and inorder() methods.  Next, states are deleted from
 * the tree using the delete() method. Following deletion, the results of preorder 
 * traversal are printed using traversal() and preorder() methods. Project3 then uses
 * the find() method to find states along with their population and how many nodes were
 * visited. the delete() method is called again to delete more states followed by the
 * results of postorder traversal using traversal() and postorder(). 
 * 
 *  
 *@author Dustin White
 *@version 6-29-19
 */
public class Project3 {
	
	static BinarySearchTree stateTree = new BinarySearchTree();
	
	public static void main(String[] args) {
		
		Scanner first = new Scanner(System.in);
		
		System.out.print("Enter name of file: ");
		String fileName = first.nextLine();
		int counter = 0;
		State[] statesArray = new State[56];
		
		try {
				
		String states = "States3.csv";
		File file = new File(states);
		Scanner fileScan = new Scanner(file);
		fileScan.useDelimiter(",");
						
		fileScan.nextLine();
		
		
		while(fileScan.hasNextLine()) {
			 			 
			 String data = fileScan.nextLine();
			 String[] a = data.split(",");
			 
			 for(int i = 0; i < a.length; i++) {
			 statesArray[counter] = new State(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]));
			  }
			 			
			counter++;
		}//end while 
		fileScan.close();
		
		}catch(FileNotFoundException error) {
			System.out.print("File not found. Try again.");
		}//end catch
		
		//fill tree
		for(int j = 0; j < statesArray.length; j++) {
			stateTree.insert(statesArray[j].getState(), statesArray[j].getPop());
			
			}//end for
		
		System.out.println("There were " + counter + " state records put on the binary search tree\n");
		
		//print states using inorder traversal
		System.out.println("Inorder traversal: \n");
		System.out.printf("%-25s%-25s\n", "Name", "Population");
		System.out.println("____________________________________");
		stateTree.traverse(2);
		System.out.println();
		
		//delete states from the tree
		stateTree.delete("California");
		stateTree.delete("Florida");
		stateTree.delete("New York");
		
		
		System.out.println();
		
		//print states using preorder traversal
		System.out.println("Preorder traversal: \n");
		System.out.printf("%-25s%-25s\n", "Name", "Population");
		System.out.println("____________________________________");
		stateTree.traverse(1);
		System.out.println();
		
		
		//find states on the tree
		stateTree.find("American Samoa");
		stateTree.find("Rhode Island");
		stateTree.find("Florida");
		
		
		
		//delete states from the tree
		stateTree.delete("U.S. Virgin Islands");
		stateTree.delete("Wyoming");
		stateTree.delete("West Virginia");
		stateTree.delete("New Mexico");
		System.out.println();
		
		
		
		//print states using postorder traversal
		System.out.println("Postorder Traversal: \n");
		System.out.printf("%-25s%-25s\n", "Name", "Population");
		System.out.println("____________________________________");
		stateTree.traverse(3);
		
		
		
		
		
		
	}//end main
	
	

}//end Project3
