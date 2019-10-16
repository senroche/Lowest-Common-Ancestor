import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LCATest {

	
	// Test LCA 
	//[4,2,6,1,3,5,7]
    @Test
    public void test() {
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
    

    @Test
    //Test null root
    public void unbalancedTreeRight() {
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
    
    
    
    @Test 
    // Test with just one node and root
    //[1,4]
	public void testTwoNode() {
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
    
    @Test
    public void testOneNode() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
		tree.root = new LCA.Node(1);
	
		/*
               1
                
		 */
		
		assertEquals(1, tree.findLCA(1,1));
	}
    
    @Test
    //Test null root
    public void testNullRoot() {
    	LCA.BT_NoParentPointer tree = new LCA.BT_NoParentPointer();
		tree.root = null;
	
		/*
             null
           /      \
                
		 */
		
		assertEquals(-1, tree.findLCA(1,1));
	}



    
}