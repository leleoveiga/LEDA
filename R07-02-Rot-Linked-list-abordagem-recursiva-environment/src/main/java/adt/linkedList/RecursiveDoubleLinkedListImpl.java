package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (previous == null) {
			previous = new RecursiveDoubleLinkedListImpl<T>();
		}
		if (isEmpty()) {
			data = element;
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
			aux.setPrevious(this);
			next = aux;
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (data == element) {
				if (previous.isEmpty()) {
					data = null;
					next = null;
					previous = null;
				} else {
					data = next.getData();
					next = next.getNext();
				}
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			data = element;
			previous = new RecursiveDoubleLinkedListImpl<T>();
			next = new RecursiveDoubleLinkedListImpl<T>();
			previous.setNext(this);
			((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
			aux.setData(data);
			aux.setNext(next);
			aux.setPrevious(this);
			next = aux;
			data = element;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (this.next.isEmpty() && this.previous.isEmpty()) {
				this.data = null;
				this.next = null;
				this.previous = null;
			} else {
				this.data = next.getData();
				this.next = next.getNext();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (this.next.isEmpty()) {
				if (this.previous.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					this.previous.setNext(next);
					((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this.previous);
				}

			} else {
				((DoubleLinkedList<T>) next).removeLast();
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArray(array, this, 0);
		return array;
	}

	private T toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			return toArray(array, node.next, index + 1);
		} else {
			return (T) array;
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
