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