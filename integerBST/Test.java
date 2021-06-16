package BST;

public class Test {
	
	public static void main(String [] args) {
		Tree bst = new Tree();
		bst.insert(15);
		bst.insert(9);
		bst.insert(20);
		bst.insert(6);
		bst.insert(14);
		bst.insert(17);
		bst.insert(64);
		bst.insert(13);
		bst.insert(26);
		bst.insert(72);
		
		System.out.println(bst.inOrden());
		bst.remove(14);
		System.out.println(bst.inOrden());
		bst.remove(26);
		System.out.println(bst.inOrden());
		bst.remove(15);
		System.out.println(bst.inOrden());
	}

}

