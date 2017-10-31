import java.util.ArrayList;
import java.util.Stack;

public class DirectedAcylicGraph {

	public class Node {

		int data;							// data stored in Node
	    Node left, right;
	    ArrayList<Node> DAGNodes;			// array of nodes stored after
	    
	    Node(int value) { 					// initialise new node with passed in int value
	        data = value;
	        left = right = null;
	        DAGNodes = new ArrayList<Node>();			// Keeps track of the nodes in the list
	    }
	}
	
	private Node root;
	
	//Getter Function
    public Node getRoot() {
		return root;
	}

	//Setter Function
	public void setRoot(Node root) {
		this.root = root;
	}
	
	private ArrayList<Node> DepthFirstSearch(Node node, Node target, 
											ArrayList<Node> list, Stack<Node> stack) {
        stack.push(node);
        for (Node theNode : node.DAGNodes) {
            if (theNode.equals(target)) {
                list.addAll(stack);
                return list;
            }
            DepthFirstSearch(theNode, target, list, stack);
        }
        stack.pop();
        return list;
    }

	
	public Node lowestCommonAncestor(Node n1, Node n2) {
		return lowestCommonAncestor(getRoot(), n1, n2);
	}

	private Node lowestCommonAncestor(Node node, Node n1, Node n2) {
		if (node == null || n1 == null || n2 == null) {		// null DAG returns a null answer for DAG
			return null;
		}
		ArrayList<Node> list1 = DepthFirstSearch(node, n1, new ArrayList<>(), new Stack<>());
		ArrayList<Node> list2 = DepthFirstSearch(node, n2, new ArrayList<>(), new Stack<>());
		
		if (list1 == null || list2 == null) {		// return null for empty 
			return null;
		}
		
		ArrayList<Node> min;
		ArrayList<Node> max;
		if (list1.size() <= list2.size()) {
			min = list1;
			max = list2;
		} else {
			min = list2;
			max = list1;
		}
		ArrayList<Node> set = new ArrayList<>();
		for (Node n : min) {
			set.add(n);
		}
		for (int i = max.size() - 1; i >= 0; i--) {
			if (set.contains(max.get(i))) {
				return max.get(i);
			}
		}
		return null;
	}	
}