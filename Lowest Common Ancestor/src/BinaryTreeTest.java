import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

	@Test
	public void testFindLCA() {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		System.out.println("LCA(4, 5) = " +
							tree.findLCA(4, 5).data);
		int answer = 2;										// initial test on the solution implemented
		assertEquals(answer, tree.findLCA(4, 5).data);

		//tree = new BinaryTree();
		//assertNull();										// answer is null for an empty tree
	}
}