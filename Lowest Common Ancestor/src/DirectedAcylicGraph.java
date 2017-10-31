import java.util.Arrays;

public class DirectedAcylicGraph {
	
	private class Node {
		private int data;					// Value stored in Node
		private Node[] successors;			// values stored in the nodes after
	
		public Node(int key) {
			this.data = key;
		}
	}
	
	private Node[] nodes = new DirectedAcylicGraph.Node[0];					// Keeps track of the nodes in the list
	
	// Is the DAG empty?
	public boolean isEmpty() { 
		if (size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	// Returns number of Nodes in graph.
	public int size() { 
		return nodes.length; 
	}
}