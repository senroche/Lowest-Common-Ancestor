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
     


    // Finds LCA, will utilise an internal function that calls findPath
    int findLCA(int n1, int n2)
    { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2)
    { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) 
        { 
            System.out.println((path1.size() > 0) ? "Node 1 present" : "Node 1 missing"); 
            System.out.println((path2.size() > 0) ? "Node 2 present" : "Node 2 missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) 
        {       
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
	
		
	    
    // Finds the path from node to the given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private boolean findPath(Node root, int n, List<Integer> path) 
    {  
        if (root == null) 
        { 
            return false; 
        } 
        path.add(root.data); 

        if (root.data == n) 
        { 
            return true; 
        }
        if (root.left != null && findPath(root.left, n, path)) 
        { 
            return true; 
        } 
        if (root.right != null && findPath(root.right, n, path)) 
        { 
            return true; 
        }
        path.remove(path.size()-1); 
        return false; 
    }
}

public static void main(String[] args) {

	
	
	
}
}