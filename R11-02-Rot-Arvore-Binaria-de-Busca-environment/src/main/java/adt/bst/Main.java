package adt.bst;

public class Main {
	
	public static void main(String[] args) {
		BSTImpl<Integer> bst = new BSTImpl<>();
//		System.out.println(bst.height());
		bst.insert(1);
//		System.out.println(bst.height());
		bst.insert(2);
		System.out.println(bst.search(2).getData().compareTo(bst.search(1).getData()));
		
	}

}
