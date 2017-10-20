import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

	@Test
	public void testFindLCA() {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(12);					//				 _ 12 _
		tree.root.left = new Node(8);				// 			   / 	   \
		tree.root.right = new Node(16);				//			_ 8 _	  _ 16 _
		tree.root.left.left = new Node(6);			//		   /     \   /		\
		tree.root.left.right = new Node(10);		//		  6 	 10 14		18
		tree.root.right.left = new Node(14);		//							  \
		tree.root.right.right = new Node(18);		//							   27
		tree.root.right.right.right = new Node(27); //		
		System.out.println("LCA(14, 27) = " +
							tree.findLCA(14, 27).data);
		int answer = 16;										// test LCA on right side of Binary Tree
		assertEquals(answer, tree.findLCA(14, 27).data);
		
		System.out.println("LCA(6, 8) = " +
							tree.findLCA(6, 8).data);
		answer = 8;								
		assertEquals(answer, tree.findLCA(6, 8).data);			// test LCA on left side of Binary Tree
		
		tree = new BinaryTree();
		tree.root = new Node(12);					//				 _ 12 _
		tree.root.left = new Node(8);				// 			   / 	   \
		tree.root.right = new Node(16);				//			  8		    16 
		
		answer =12;
		assertEquals(answer, tree.findLCA(12, 8).data);			// test LCA for tree with only 3 nodes
		
		
		tree.root.left=null;
		assertEquals(answer, tree.findLCA(12, 8).data);  		// test LCA for tree with only 2 nodes
	}
	
	@Test
	public void testEmptyTree(){
		BinaryTree tree = null;
		assertEquals(tree, null);
		
	}
	
	@Test
	public void testEmptyNodes(){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(22);					//				 _ 22 _
		tree.root.left = new Node(11);				// 			   / 	   \
		tree.root.right = null;						//			  11	  null
		tree.root.left.left = new Node(2);			//			/     \  		
		tree.root.left.right = new Node(9);			//	   	   2 	   9 	
		
		assertNull(tree.root.right);
													//				 _ 22 _
		tree.root.left = null;						// 			   / 	   \
		assertNull(tree.root.left);					//			 null	   null
															   
	}
	
	@Test
	public void testLCAwithNegativeNode(){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(11);					//				 _ 11 _
		tree.root.left = new Node(5);				// 			   / 	   \
		tree.root.right = new Node(14);				//			_ 5 _	   14
		tree.root.left.left = new Node(-3);			//		   /     \  		
		tree.root.left.right = new Node(9);			//		  -3 	  9 	
		
		int negativeNode = tree.root.left.left.data;
		assertTrue(negativeNode < 0);
		
		System.out.println("LCA(14, -3) = " +
				tree.findLCA(14, -3).data);
		
		int answer = 11;								
		assertEquals(answer, tree.findLCA(14, -3).data);
		
	}
}