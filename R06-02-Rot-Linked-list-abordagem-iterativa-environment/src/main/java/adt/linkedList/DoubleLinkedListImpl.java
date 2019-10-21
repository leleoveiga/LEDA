package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {

		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
				new DoubleLinkedListNode<T>());
		aux.next = head;
		((DoubleLinkedListNode<T>) head).previous = aux;
		if (isEmpty()) {
			last = aux;
		}
		head = aux;
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			head = head.next;

			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}

			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			last = last.previous;
			last.next = new DoubleLinkedListNode<T>();
		}
		if(last.isNIL()) {
			head = last;
		}
	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			head.data = element;
			head.next = new DoubleLinkedListNode<T>();
			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
			last = (DoubleLinkedListNode<T>) head;
		} else {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head;
			
			while(!aux.next.isNIL()) {
				aux = (DoubleLinkedListNode<T>) aux.next;
			}
			
			aux.next.data = element;
			((DoubleLinkedListNode<T>) aux.next).previous = aux;
			aux.next.next = new DoubleLinkedListNode<T>();
			last = (DoubleLinkedListNode<T>) aux.next;
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
