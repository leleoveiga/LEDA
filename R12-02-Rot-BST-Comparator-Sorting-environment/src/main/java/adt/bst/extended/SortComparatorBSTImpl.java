package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	public SortComparatorBSTImpl() {
		super();
	}
	
	@Override
	public T[] sort(T[] array) {
		
		return order();
		
	}
	
	@Override
	public T[] reverseOrder() {
		ArrayList<T> array = new ArrayList<>();
		
		reverseOrder(root, array);
		
		T[] result = (T[]) array.toArray(new Comparable[array.size()]);
		
		return result;
	}
	
	private void reverseOrder(BSTNode<T> node, ArrayList<T> array) {
		if (node.isEmpty()) return;
		
		reverseOrder((BSTNode<T>) node.getRight(), array);
		array.add(node.getData());
		reverseOrder((BSTNode<T>) node.getLeft(), array);
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
