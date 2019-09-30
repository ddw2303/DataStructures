/**
 * This class creates the binary search tree which is used by 
 * the Project3 class to store State objects. The methods in 
 * this class, with the exception of printFiveMin() and printFiveMax() 
 * are referenced from "Data Structures and Algorithms in Java", 
 * Second Edition, by Robert LaFore. Pages 406-412.
 * 
 * 
 * @author Dustin White
 * @version 6-29-19
 *
 */
public class BinarySearchTree {

	private Node root;

	/**
	 * The Node class creates the nodes that will be used by
	 * the BinarySearchTree class.
	 * 
	 * @author Dustin White
	 * @version 6-29-19
	 *
	 */
	private class Node {

		String stateName;
		int statePopulation;
		Node leftChild;
		Node rightChild;
		
		/**
		 * Constructor for Node class
		 * 
		 * @param state: string
		 * @param population: integer
		 */
		public Node(String state, int population) {

			stateName = state;
			statePopulation = population;

		}// end Node constructor

		public void printNode() {
			System.out.printf("%-25s%,10d\n", stateName, statePopulation);
		}// end printNode()

	}// end Node

	/**
	 * Constructor for BinarySearchTree class
	 */
	public BinarySearchTree() {
		
		root = null;
		
	}// end BinarySearchTree constructor
	
	/**
	 * Method for finding a state
	 * 
	 * @param state: string
	 * @return
	 */
	public int find(String state){ 
		
		Node current = root; 
		int counter = 1;
		
		while(current != null) {
		if (state.compareTo(current.stateName) != 0){
			counter++;
			
			if (state.compareTo(current.stateName) < 0) {
				current = current.leftChild; //traverse left side
			}//end if
			else 
				current = current.rightChild; //traverse right side
			if (current == null) { 
				System.out.println(state + " is not found");
				System.out.println(counter + " nodes visited\n");
				return -1; 
			}//end if(current == null)
			
			if(state.compareTo(current.stateName) == 0) {
				System.out.println(state + " is found with a population of " + current.statePopulation);
				System.out.println(counter + " nodes visited\n");
				return 1;//current.statePopulation;
			}//end if
		}//end if 
		}//end while
		return -1;
	} // end find()
		
	/**
	 * Method for inserting a node into the tree with 
	 * state name and state population as its data
	 * 
	 * @param state: string
	 * @param population: integer
	 */
	public void insert(String state, int population) {
		
		Node newNode = new Node(state, population); 
		newNode.stateName = state; 
		newNode.statePopulation = population;
		
		if (root == null) {
			root = newNode;
		}//end if
		else {
			Node current = root; 
			Node parent;
			while (true){
				parent = current;
				if (state.compareTo(current.stateName) < 0) {
					current = current.leftChild;
					if (current == null){
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else{
					current = current.rightChild;
					if (current == null){ 
						parent.rightChild = newNode;
						return;
					}//end if
				} // end else go right
			} // end while
		} // end else not root
	} // end insert()
		
	/**
	 * Method for deleting a node given a state name
	 * 
	 * @param state: string
	 */
	public void delete(String state)	{ 
		
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.stateName.compareTo(state) != 0) {
			parent = current;
			if (0 < current.stateName.compareTo(state)) {
				isLeftChild = true;
				current = current.leftChild;
			} 
			else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) 
				return; // didn't find it
		} // end while
		System.out.println(state + " has been deleted from the tree");

		// if no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) // if root,
				root = null; // tree is empty
			else if (isLeftChild) {
				parent.leftChild = null; // disconnect
			}
			else // from parent
				parent.rightChild = null;
		}

		// if no right child, replace with left subtree
		else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			}
			else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			}
			else
				parent.rightChild = current.leftChild;
		}//end else if

		// if no left child, replace with right subtree
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		else // two children, so replace with inorder successor
		{
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);

			// connect parent of current to successor instead
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			successor.leftChild = current.leftChild;
		} // end else two children
			
		return; 
	} // end delete()
		
	/**
	 * Method for finding the successor to the node that is deleted
	 * in the delete() method. 
	 * 
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while (current != null) // until no more
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if (successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/**
	 * Method for selecting the type of traversal used to 
	 * traverse the tree
	 * 
	 * @param traverseType: integer
	 */
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			preOrder(root);
			break;
		case 2:
			inOrder(root);
			break;
		case 3:
			postOrder(root);
			break;
		}
		System.out.println();
	}

	/**
	 * Method traversing the tree using preorder traversal
	 * 
	 * @param localRoot
	 */
	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			localRoot.printNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}//end preOrder()
	
	
	/**
	 * Method for traversing the tree using inorder traversal
	 * 
	 * @param node
	 */
	private void inOrder(Node localRoot) {
		
		if(localRoot == null) {
			return;
		}
		inOrder(localRoot.leftChild);
		localRoot.printNode();
		inOrder(localRoot.rightChild);
		
	}//end inOrder()
		

	/**
	 * Method for traversing the tree using postorder traversal
	 * 
	 * @param localRoot
	 */
	public void postOrder(Node localRoot) {
		
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.printNode();
			
			}//end if
		
	}//end postOrder()
	
		
		
	

}// end BinarySearchTree
