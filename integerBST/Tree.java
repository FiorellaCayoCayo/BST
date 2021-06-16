package BST;

public class Tree {
	
	Node root;
	int tam;
	public Tree() {
		this.root = null;
		tam = 0;
	}
	
	private String inOrden(Node n) {   //left - root - right
		if(n != null) 
			return inOrden(n.left) + n.data + ", " + inOrden(n.right);
		return "";
	}
	
	public String inOrden() {
		return inOrden(root);
	}
	
	private String preOrden(Node n) {   //root - left - right
		if(n != null) 
			return n.data + ", " +preOrden(n.left) + preOrden(n.right);
		return "";
	}
	
	public void preOrden() {
		preOrden(root);
	}
	
	private String postOrden(Node n) {   //left - right - root
		if(n != null) 
			return postOrden(n.left) + postOrden(n.right) + n.data + ", ";
		return "";
	}
	
	public void postOrden() {
		postOrden(root);
	}
	
	public void insert(int date) {
		
		if(root == null) {
			this.root = new Node(date);
			tam++;
		}
		else {
			Node aux = root;
			boolean value = true;
			while(value) {
				if(date < aux.data) {
					if(aux.left != null)
						aux = aux.left;
					else {
						aux.left = new Node(date, aux);
						tam++;
						value = false;
					}
				}
				else if(date > aux.data) {
					if(aux.right != null)
						aux = aux.right;
					else {
						aux.right = new Node(date, aux);
						tam++;
						value = false;
					}
				}
				else
					System.out.println("el dato " + date + " ya fue insertado");
					
			}
		}
	}
	
	public boolean search(int date) {
		Node aux = root;
		while(aux != null) {
			
			if(date == aux.data) 
				return true;
			
			else if(date < aux.data)
				aux = aux.left;
			
			else 
				aux = aux.right;
		}
		return false;
	}
	
	public Node searchNode(int date) {
		Node aux = root;
		while(aux != null) {
			
			if(date == aux.data) 
				return aux;
			
			else if(date < aux.data)
				aux = aux.left;
			
			else 
				aux = aux.right;
		}
		return null;
	}
	
	private boolean isLeaf(Node aux) {
		if(aux.left == null && aux.right == null)
		    return true;
		return false;
	}
	
	private void removeLeaf(Node aux) {
		if(aux == aux.father.left)
			aux.father.left = null;
		else if (aux == aux.father.right)
			aux.father.right = null;
		else
			root = null;
		
	}
	
	private boolean isChild(Node aux) {
		if((aux.left == null && aux.right != null) || (aux.left != null && aux.right == null))
			return true;
		return false;
	}
	
	private void removeChild(Node aux) {
		if(aux == root) {
			if(aux.left != null)
				root = aux.left;
			else
				root = aux.right;
			
			root.father = null;
		}
		else {
			if(aux.left != null) {
				if(aux == aux.father.left)
					aux.father.left = aux.left;
				else
					aux.father.right = aux.left;
				
				aux.left.father = aux.father;
			}
			else {
				if(aux == aux.father.left)
					aux.father.left = aux.right;
				else
					aux.father.right = aux.right;
				
				aux.right.father = aux.father;
			}
		}
	}
	
	private void removeTwoChildren(Node aux) {
		//dirigido a right
		Node higher = searchMax(aux.left);
		aux.data = higher.data;
		if(isLeaf(higher))
			removeLeaf(higher);
		
		else 
			removeChild(higher);
	}
	
	private Node searchMax(Node m) {
		while(m.right != null) 
			m = m.right;
		return m;
	}
	
	public boolean remove(int date) {
		Node aux = searchNode(date);
		if(aux != null) {  //si lo encontro
			if(isLeaf(aux))
				removeLeaf(aux);
			
			else if(isChild(aux))
				removeChild(aux);
			
			else
				removeTwoChildren(aux);
			tam--;
			return true;
		}
		return false;
	}
	

}

