package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;
import adt.linkedList.RecursiveSingleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			top.insertFirst(element);
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T aux = ((RecursiveSingleLinkedListImpl<T>) top).getData();
			top.removeFirst();
			return aux;
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		T result = null;
		if(!isEmpty()) {
			result = ((RecursiveSingleLinkedListImpl<T>) top).getData();
		}
		return result;
	}

	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == size;
	}

}
