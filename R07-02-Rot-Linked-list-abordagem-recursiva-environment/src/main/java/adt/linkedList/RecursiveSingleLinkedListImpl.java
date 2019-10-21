package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		if(data == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		if(!isEmpty()) {
			return next.size()+1;
		} else {
			return 0;
		}
	}

	@Override
	public T search(T element) {
	
		if(isEmpty()) {
			return null;
		} else {
			if(data == element) {
				return data;
			} else {
				return next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		
		if(isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.data == element) {
				this.data = next.data;
				this.next = next.next;
			} else {
				this.next.remove(element);
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
		if(!node.isEmpty()) {
			array[index] = node.getData();
			return toArray(array, node.next, index+1);
		} else {
			return (T) array;
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
