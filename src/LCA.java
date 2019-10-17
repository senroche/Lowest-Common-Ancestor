// Java Program that finds LCA in a Binary Tree.
//O(n) solution to find LCA of two given nodes n1 and n2

import java.util.ArrayList; 
import java.util.List; 
import java.util.LinkedList;

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
	
	//Directed Acyclic Graph Node
	public static class DAGNode {
	    int value;	
	    ArrayList<DAGNode> edges;

	    DAGNode(int value) {
	        this.value = value;
	        edges = new ArrayList<>();
	
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


	public static DAGNode findLCA_DAG(DAGNode head, DAGNode nodeOne, DAGNode nodeTwo){
		
	    DAGNode LCA = null;
	    ArrayList<DAGNode> nodes = new ArrayList<>();
	    
	    addNodesToListDAG(nodes, head);
	    boolean isAncestor[] = new boolean[nodes.size()];
	    
	    for (int i = 0; i < isAncestor.length; i++)
	        isAncestor[i] = false;
	    for (int i = 0; i < nodes.size(); i++) {
	        if (checkPathDAG(nodes.get(i), nodeOne, nodeTwo)) {
	            isAncestor[i] = true;
	        }
	    }
	
	    for (int i = 0; i < nodes.size(); i++) {
	
	        if(isAncestor[i])
	
	            LCA = nodes.get(i);
	    }
	    return LCA;
	}

	// Checks if one node is ancestor to the other
	public static boolean checkPathDAG(DAGNode node, DAGNode nodeOne) {
	
	    if (node == null)
	    	
	        return false;
	
	    if (node == nodeOne)
	
	        return true;
	
	    else {
	        for (int i = 0; i < node.edges.size(); i++) {
	            if (checkPathDAG(node.edges.get(i), nodeOne)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}


	public static boolean checkPathDAG(DAGNode node, DAGNode nodeOne, DAGNode nodeTwo) {
	
	    if (checkPathDAG(node, nodeOne) && checkPathDAG(node, nodeTwo))
	        return true;
	
	    return false;
	
	}
	
	public static void addNodesToListDAG(ArrayList<DAGNode> nodes, DAGNode root) {
	    if (root != null) {
	        LinkedList<DAGNode> queue = new LinkedList<>();
	        queue.add(root);
	        DAGNode cur;
	        
	        while (queue.size() != 0) {
	            cur = queue.get(0);
	
	            for (int i = 0; i < cur.edges.size(); i++) {
	                queue.add(cur.edges.get(i));
	            }
	
	            nodes.add(cur);
	
	            queue.remove(0);
	        }
	    }
	}
}