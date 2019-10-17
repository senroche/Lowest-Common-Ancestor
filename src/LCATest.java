import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LCATest {
	
	// Test LCA - BST input [4,2,6,1,3,5,7] 
	// Values of nodes irrelevant, realistic values used for proof.
    @Test
    public void testStandardBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
        tree.root = new LCA.Node(4); tree.root.left = new LCA.Node(2);
        tree.root.right = new LCA.Node(6); tree.root.left.left = new LCA.Node(1);
        tree.root.left.right = new LCA.Node(3); tree.root.right.left = new LCA.Node(5);
        tree.root.right.right = new LCA.Node(7);
        /*
        
        BST Diagram:
              4
            /   \
           2     6
          / \   / \
         1   3 5   7

        */

        assertEquals( 4,tree.findLCA(2, 6));
        assertEquals( 2,tree.findLCA(1, 3));
        assertEquals( 6,tree.findLCA(5, 7));
        assertEquals( 4,tree.findLCA(1, 6));
        assertEquals( 4,tree.findLCA(7, 2));
        assertEquals( 4,tree.findLCA(3, 5));
        assertEquals( 4,tree.findLCA(4, 6));
        assertEquals( 2,tree.findLCA(1, 2));
        //Test node not found
        assertEquals( -1,tree.findLCA(250, 2));
        assertEquals( -1,tree.findLCA(2, 250));
        assertEquals( -1,tree.findLCA(250, 250));
        
    }
   

    @Test
    public void largeInputTestBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
    	tree.root = new LCA.Node(21);
    	tree.root.left = new LCA.Node(14); 
        tree.root.right = new LCA.Node(28); 
        tree.root.left.left = new LCA.Node(11);
        tree.root.left.right = new LCA.Node(18); 
        tree.root.right.left = new LCA.Node(25);
        tree.root.right.right = new LCA.Node(32);
        tree.root.left.left.left = new LCA.Node(5); 
        tree.root.left.left.right = new LCA.Node(12);
        tree.root.left.right.left = new LCA.Node(15);
        tree.root.left.right.right = new LCA.Node(19);
        tree.root.right.left.left = new LCA.Node(23); 
        tree.root.right.left.right = new LCA.Node(27);
        tree.root.right.right.left = new LCA.Node(30); 
        tree.root.right.right.right = new LCA.Node(37);
        
        assertEquals( 21,tree.findLCA(21, 21));
        assertEquals( 21,tree.findLCA(28, 14));
        assertEquals( 14,tree.findLCA(11, 18));
        assertEquals( 32,tree.findLCA(30, 37));
        
        assertEquals( 18,tree.findLCA(15, 18));
        assertEquals( 14,tree.findLCA(11, 18));
        assertEquals( 28,tree.findLCA(25, 32));
        assertEquals( 28,tree.findLCA(23, 30));
        assertEquals( 21,tree.findLCA(21, 28));
        assertEquals( 21,tree.findLCA(28, 18));
        assertEquals( 21,tree.findLCA(37, 11));

    
        
        /*
        
	    BST Diagram:
	                 21
	              /     \
	           14        28
	          / \        / \
	        11    18     25   32
	       / \    / \    / \   / \
	      5  12  15 19  23 27  30 37
      
        */
    }
    

    
    //Test unbalanced tree 
    @Test
    public void testUnbalancedBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
        tree.root = new LCA.Node(4);
        tree.root.right = new LCA.Node(6); 
        tree.root.right.left = new LCA.Node(5);
        tree.root.right.right = new LCA.Node(7); 
        tree.root.right.right.right = new LCA.Node(9); 
        tree.root.right.right.right.right = new LCA.Node(11);
	
        /*
        
        BST Diagram:
              4
                \
                 6
                / \
               5   7
                    \
                     9
                      \
                      11
    

        */
		assertEquals(9, tree.findLCA(11,9));
		assertEquals(6, tree.findLCA(7,5));
		assertEquals(4, tree.findLCA(4,11));
		assertEquals(6, tree.findLCA(6,7));
	}
    
    // Test with just one node and root
    @Test 
	public void testTwoNodeBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
		tree.root = new LCA.Node(1);
		tree.root.right = new LCA.Node(4);
	
		/*
               1
                \
                 4
		 */
		
		assertEquals(1, tree.findLCA(4,1));
		assertEquals(1, tree.findLCA(1,4));
	}
    
    // Test with just one root node
    @Test
    public void testOneNodeBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
		tree.root = new LCA.Node(1);
	
		/*
               1
                
		 */
		assertEquals(1, tree.findLCA(1,1));
		//Node not found
		assertEquals(-1, tree.findLCA(1,3));
	}
    
    @Test
    //Test null root
    public void testNullRootBST() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
		tree.root = null;
	
		/*
             null
           /      \
                
		 */
		
		assertEquals(-1, tree.findLCA(1,1));
	}
    
    @Test
    //Simple test case with edges between head and all nodes.
    //Changed node names to match values.
    public void testStandardDAG() {
        LCA.DAGNode head = new LCA.DAGNode(1);
        LCA.DAGNode nodeTwo = new LCA.DAGNode(2);
        LCA.DAGNode nodeFour = new LCA.DAGNode(4);
        LCA.DAGNode nodeSix = new LCA.DAGNode(6);
        LCA.DAGNode nodeEight = new LCA.DAGNode(8);
        LCA.DAGNode nodeTen = new LCA.DAGNode(10);
        head.edges.add(nodeTwo);
        head.edges.add(nodeFour);
        head.edges.add(nodeSix);
        head.edges.add(nodeEight);
        head.edges.add(nodeTen);
        
        assertEquals(head, LCA.findLCA_DAG(head, head, nodeSix));
        assertEquals(head, LCA.findLCA_DAG(head, nodeTwo, nodeSix));
        assertEquals(head, LCA.findLCA_DAG(head, nodeFour, nodeSix));
        assertEquals(head, LCA.findLCA_DAG(head, nodeEight, nodeSix));
        //Check ancestor of self and self
        assertEquals(nodeSix, LCA.findLCA_DAG(head, nodeSix, nodeSix));
    }
    
    @Test
    //Example taken from LCA.pdf slides made available on course website.
    //Screenshot of visualization will be added.
    public void largeInputTestDAG() {
        LCA.DAGNode head = new LCA.DAGNode(1);
        LCA.DAGNode nodeTwo = new LCA.DAGNode(2);
        LCA.DAGNode nodeThree = new LCA.DAGNode(3);
        LCA.DAGNode nodeFour = new LCA.DAGNode(4);
        LCA.DAGNode nodeFive = new LCA.DAGNode(5);
        LCA.DAGNode nodeSix = new LCA.DAGNode(6);
        LCA.DAGNode nodeSeven = new LCA.DAGNode(7);
        LCA.DAGNode nodeEight = new LCA.DAGNode(8);
        LCA.DAGNode nodeNine = new LCA.DAGNode(9);
        LCA.DAGNode nodeTen = new LCA.DAGNode(10);
        LCA.DAGNode nodeEleven = new LCA.DAGNode(11);
        LCA.DAGNode nodeTwelve = new LCA.DAGNode(12);
        LCA.DAGNode nodeThirteen = new LCA.DAGNode(13);
        head.edges.add(nodeTwo);
        head.edges.add(nodeTwo);
        head.edges.add(nodeThree);
        head.edges.add(nodeFour);
        head.edges.add(nodeSix);
        nodeThree.edges.add(nodeFive);
        nodeFive.edges.add(nodeSeven);
        nodeFive.edges.add(nodeEight);
        nodeSeven.edges.add(nodeTen);
        nodeTen.edges.add(nodeNine);
        nodeTen.edges.add(nodeEleven);
        nodeTen.edges.add(nodeTwelve);
        nodeTen.edges.add(nodeThirteen);
        
        assertEquals(nodeFive, LCA.findLCA_DAG(head, nodeSeven, nodeEight));
        assertEquals(nodeSix, LCA.findLCA_DAG(head, nodeSix, nodeSix));
        assertEquals(nodeTen, LCA.findLCA_DAG(head, nodeTwelve, nodeEleven));
        assertEquals(nodeTen, LCA.findLCA_DAG(head, nodeNine, nodeThirteen));
        assertEquals(head, LCA.findLCA_DAG(head, nodeSix, nodeEleven));
    
    }
    
    // Test DAG LCA with null nodes
    @Test
    public void testNullInputsDAG() {
        assertEquals(LCA.findLCA_DAG(null, null, null), null); // LCA with two null inputs
        LCA.DAGNode nodeOne = new LCA.DAGNode(6);
        assertEquals(LCA.findLCA_DAG(null, null, nodeOne), null); // Tests with one null input
        assertEquals(LCA.findLCA_DAG(null, nodeOne, null), null); 

    }
}