package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException, StackOverflowException, StackUnderflowException {
		if (!isFull()) {
			int top = stack1.getTop();
			for (int i = top; i < top + 1; i--) {
				stack2.push(stack1.pop());
			}
			stack2.push(element);
			for (int i = top; i < top + 1; i--) {
				stack1.push(stack2.pop());
			}
		} else {

			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws StackOverflowException, StackUnderflowException, QueueUnderflowException {
		if (!isEmpty()) {
			int top = stack1.getTop();
			for (int i = top; i < top + 1; i--) {
				stack2.push(stack1.pop());
			}

			T result = stack2.pop();
			for (int i = top; i < top + 1; i--) {
				stack1.push(stack2.pop());
			}
			return result;
		}
		throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		return stack1.getArray()[0];
	}

	@Override
	public boolean isEmpty() {
		return stack1.getTop() == -1;
	}

	@Override
	public boolean isFull() {
		return stack1.getTop() == stack1.getArray().length - 1;
	}

}
