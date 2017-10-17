import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

	@Test
	public void testLCARightSide() {
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
		int answer = 16;										// initial test on the solution implemented
		assertEquals(answer, tree.findLCA(14, 27).data);

	}
	
	@Test
	public void testLCALeftSide() {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(12);					//				 _ 12 _
		tree.root.left = new Node(8);				// 			   / 	   \
		tree.root.right = new Node(16);				//			_ 8 _	  _ 16 _
		tree.root.left.left = new Node(6);			//		   /     \   /		\
		tree.root.left.right = new Node(10);		//		  6 	 10 14		18
		tree.root.right.left = new Node(14);		//							  \
		tree.root.right.right = new Node(18);		//							   27
		tree.root.right.right.right = new Node(27); //		
		System.out.println("LCA(6, 8) = " +
							tree.findLCA(6, 8).data);
		int answer = 8;								
		assertEquals(answer, tree.findLCA(6, 8).data);

	}
	
	@Test
	public void testEmptyTree(){
		BinaryTree tree = null;
		assertEquals(tree, null);
		
	}
}