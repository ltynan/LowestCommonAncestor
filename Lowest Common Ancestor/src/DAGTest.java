import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DAGTest {
	DirectedAcylicGraph<Node> DAG = new DirectedAcylicGraph<Node>();
	ArrayList<Node> nodes;

	@Test
	public void testLowestCommonAncestor() {
		nodes = new ArrayList<>();
		DAG = new DirectedAcylicGraph<Node>();
		for (int i = 0; i < 10; i++) {
			nodes.add(new Node(i));
		}
		DAG.setRoot(nodes.get(0));	
		nodes.get(0).addEdge(nodes.get(1));
		nodes.get(0).addEdge(nodes.get(2));
		nodes.get(1).addEdge(nodes.get(3));
		nodes.get(1).addEdge(nodes.get(4));
		nodes.get(2).addEdge(nodes.get(4));
		nodes.get(2).addEdge(nodes.get(5));
		nodes.get(2).addEdge(nodes.get(6));
		nodes.get(5).addEdge(nodes.get(8));
		nodes.get(6).addEdge(nodes.get(8));
		nodes.get(6).addEdge(nodes.get(7));
		nodes.get(6).addEdge(nodes.get(9));
		nodes.get(7).addEdge(nodes.get(9));
		assertEquals(nodes.get(6), DAG.lowestCommonAncestor(nodes.get(9), nodes.get(8)));
		assertEquals(nodes.get(2), DAG.lowestCommonAncestor(nodes.get(8), nodes.get(4)));
		assertEquals(nodes.get(0), DAG.lowestCommonAncestor(nodes.get(8), nodes.get(3)));

		nodes = new ArrayList<>();
		DAG = new DirectedAcylicGraph<Node>();
		for (int i = 0; i < 9; i++) {
			nodes.add(new Node(i));
		}
		DAG.setRoot(nodes.get(0));
		nodes.get(0).addEdge(nodes.get(1));
		nodes.get(0).addEdge(nodes.get(2));
		nodes.get(1).addEdge(nodes.get(4));
		nodes.get(1).addEdge(nodes.get(5));
		nodes.get(2).addEdge(nodes.get(3));
		nodes.get(3).addEdge(nodes.get(5));
		nodes.get(3).addEdge(nodes.get(6));
		nodes.get(5).addEdge(nodes.get(7));
		nodes.get(5).addEdge(nodes.get(8));
		
		assertEquals(nodes.get(0).data, DAG.lowestCommonAncestor(nodes.get(1), nodes.get(2)).data);
		assertEquals(nodes.get(3).data, DAG.lowestCommonAncestor(nodes.get(8), nodes.get(6)).data);
		assertEquals(nodes.get(3).data, DAG.lowestCommonAncestor(nodes.get(8), nodes.get(5)).data);
		

	}
	
	@Test
	public void testNullLowestCommonAncestor() {
		nodes = new ArrayList<>();
		DAG = new DirectedAcylicGraph<Node>();
		nodes.add(new Node(null));
		nodes.add(new Node(1));
		nodes.add(new Node(2));
		DAG.setRoot(nodes.get(0));	

		assertEquals(null, DAG.lowestCommonAncestor(nodes.get(1), nodes.get(2)));
		
		DirectedAcylicGraph<Node> DAG2 = new DirectedAcylicGraph<Node>();
		ArrayList<Node> nodes2 = new ArrayList<>();
		nodes2.add(new Node(4));
		assertEquals(null, DAG2.lowestCommonAncestor(nodes2.get(0), nodes.get(0)));
		
		assertNull(DAG.lowestCommonAncestor(null, null));
	}
	
    @Test
    public void testData(){
        nodes = new ArrayList<>();
        nodes.add(new Node(1));
        nodes.add(new Node(2));
        nodes.add(new Node(3));
        DAG.setRoot(nodes.get(1));
        
        nodes.get(1).addEdge(nodes.get(2));
        nodes.get(1).addEdge(nodes.get(0));
        
        assertEquals("lca(a1,a3) = a2", nodes.get(1).data, DAG.lowestCommonAncestor(nodes.get(0), nodes.get(2)).data);
    }
}
