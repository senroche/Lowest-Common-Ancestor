// Java Program that finds LCA in a Binary Tree.
//O(n) solution to find LCA of two given nodes n1 and n2

import java.util.ArrayList; 
import java.util.List; 

public class LCA{
	
// Binary Tree Node
public static class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = null;
        right = null;
    } 
} 

//Binary tree class for LCA with no parent pointer.
public static class BT_NoParentPointer 
{ 
    Node root; 
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();
     


	// Finds LCA will utilise an internal function that calls findPath
	int findLCA(int n1, int n2) {
		return 0;
	}
	
		
	    
	// Finds the path from node to the given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private boolean findPath(Node root, int n, List<Integer> path) {
        

        return false;
    }


}

public static void main(String[] args) {


}
}