package BST;

public class Node {
	
	int data;
	Node left;
	Node right;
	Node father;
	
	public Node(int date) {
		this.data = date;
		left = null;
		right = null;
		father = null;
	}
	
	public Node (int date, Node father) {
		this.data = date;
		left = null;
		right = null;
		this.father = father;
	}

}

