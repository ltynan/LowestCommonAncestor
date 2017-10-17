import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

	@Test
	public void testLCARightSide() {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(12);							//	12
		tree.root.left = new Node(8);					// 8
		tree.root.right = new Node(16);								//16
		tree.root.left.left = new Node(6);			//6		
		tree.root.left.right = new Node(10);				//10
		tree.root.right.left = new Node(14);					//14	
		tree.root.right.right = new Node(18);								//18
		
		System.out.println("LCA(14, 18) = " +
							tree.findLCA(14, 18).data);
		int answer = 16;										// initial test on the solution implemented
		assertEquals(answer, tree.findLCA(14, 18).data);

	}
	
	
	
	@Test
	public void testEmptyTree(){
		BinaryTree tree = null;
		assertEquals(tree, null);
		
	}
}