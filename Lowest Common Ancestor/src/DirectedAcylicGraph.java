import java.util.Arrays;

public class DirectedAcylicGraph {

	private class Node {
		private int data;					// data stored in Node
		private Node[] successors;			// array of nodes stored after

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


	//Checks whether Node n is in the graph.
	public boolean contains(int key) {
		boolean dataInList = false;
		for (int i=0; i<nodes.length; i++) {
			if (nodes[i].data == key) {
				dataInList = true;
				break;
			}			
		}
		return dataInList;
	}

	// Adds a node to the graph. No precaution for cycles yet.
	public void put(int v, int fromData, int toData) {	
		Node n = new Node(v);
		Node from = retrieveNodeFromData(fromData);
		Node to = retrieveNodeFromData(toData);

		if (fromData != 0) {					// may need to consider changing type to <Integer> 
												//due to having to use 0 and not being able to use null
			
			from.successors = extendArrayByOne(from.successors);
			from.successors[from.successors.length-1] = n;
			// If 'from' Node is not already in the graph.
			if (from.data == 0) {					
				addNodeToNodes(from);
			}
		}

		if (toData != 0) {
			n.successors = extendArrayByOne(n.successors);
			n.successors[n.successors.length-1] = to;
			// If 'to' Node is not already in the graph.
			if (to.data == 0) {
				addNodeToNodes(to);
			}
		}
		addNodeToNodes(n);		
	}

	public void addNodeToNodes (Node n) {
		nodes = extendArrayByOne(nodes);
		nodes[nodes.length-1] = n;
	}

	// Extends an array by one element.
	public Node[] extendArrayByOne(Node[] originalArray) {
		Node[] copyArray = new DirectedAcylicGraph.Node[originalArray.length+1];
		System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);
		return copyArray;
	}

	// Elements need to be deleted rather than turned to null.
	public void deleteNode(Node n) {
		int i;
		for(i=0; i<n.successors.length; i++) {
			n.successors[i] = null;
		}

		for(i=0; i<nodes.length; i++) {
			if (Arrays.asList(nodes[i].successors).contains(n) == true) {
				for (int j=0; j<nodes[i].successors.length; j++) {
					if (nodes[i].successors[j] == n) {
						nodes[i].successors[j] = null;
					}
				}
			}
		}

		for (int k=0; k<nodes.length; k++) {
			if (nodes[k] == n) {
				nodes[k] = null;
			}
		}		
	}

	// Returns Node associated with int v.
	public Node retrieveNodeFromData (int v){
		Node returnNode = new Node(0); 				
		for (int i=0; i<nodes.length; i++){
			if (nodes[i].data == v){
				returnNode = nodes[i];
				break;			
			}	
		}
		return returnNode;
	}
	
	
	Node root;
	Node findLCA(int n1, int n2)
	{
		return findLCA(root, n1, n2);
	}

	Node findLCA(Node node, int n1, int n2)
	{
		if (node == null)
			return null;
		else	
			return node;
	}
}