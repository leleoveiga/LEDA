package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		
		SingleLinkedListNode<T> aux = head;
		int size = 0;
		while(!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T ans = null;
		SingleLinkedListNode<T> aux = head;
		
		while(!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		ans = aux.getData();
		return ans;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T>auxH = head;
		if(head.isNIL()) {
			head = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		} else {
			while(!auxH.next.isNIL()) {
				auxH = auxH.next;
			}
			auxH.next = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> aux = head;
		if(head.data.equals(element)) {
			head = head.next;
		} else {
			while (!aux.next.isNIL() && aux.next.getData() != element) {
				aux = aux.next;
			}
			aux.setNext(aux.getNext().getNext());
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = head;
		int count = 0;
		
		while(!aux.isNIL()) {
			result[count] = aux.getData();
			count++;
			aux = aux.getNext();
		}
		
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
