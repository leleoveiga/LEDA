package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;
import adt.stack.StackRecursiveDoubleLinkedListImpl;
import adt.stack.StackUnderflowException;

//Apenas uns testes que fiz para a StackRecursiveDOubleLinkedListImpl

public class StackTest {

	StackRecursiveDoubleLinkedListImpl<Integer> pilha1;
	StackRecursiveDoubleLinkedListImpl<Integer> pilha2;
	StackRecursiveDoubleLinkedListImpl<Integer> pilha3;
	
	@Before
	public void setUp() throws Exception {

		pilha1 = new StackRecursiveDoubleLinkedListImpl<Integer>(5);
		pilha2 = new StackRecursiveDoubleLinkedListImpl<Integer>(1);
		pilha3 = new StackRecursiveDoubleLinkedListImpl<Integer>(0);
		
		pilha1.push(1);
		pilha1.push(2);
		pilha1.push(3);
		pilha2.push(1);
	}

	@Test
	public void testPush() {
		assertEquals(new Integer(3), pilha1.top());
	}

	@Test
	public void testPop() throws StackUnderflowException {
		assertEquals(new Integer(3), pilha1.pop());
		assertEquals(new Integer(2), pilha1.pop());
		assertEquals(new Integer(1), pilha1.pop());
	}

	@Test(expected = StackUnderflowException.class)
	public void testIsEmpty() throws StackUnderflowException {
		pilha1.pop();
		pilha1.pop();
		pilha1.pop();
		pilha1.pop();
	}

	@Test(expected = StackOverflowException.class)
	public void testIsFull() throws StackOverflowException {
		pilha1.push(4);
		pilha1.push(5);
		pilha1.push(6);
	}

}
