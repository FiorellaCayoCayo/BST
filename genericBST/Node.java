package BST;

public class Node <E> {
	 
	E data;
	Node left;
	Node right;
	Node father;
	
	public Node(E date) {
		this.data = date;
		left = null;
		right = null;
		father = null;
	}
	
	public Node (E date, Node father) {
		this.data = date;
		left = null;
		right = null;
		this.father = father;
	}

}

