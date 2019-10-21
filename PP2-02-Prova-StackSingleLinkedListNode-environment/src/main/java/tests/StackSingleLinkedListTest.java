package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;
import adt.stack.StackSingleLinkedListNodeImpl;
import adt.stack.StackUnderflowException;

public class StackSingleLinkedListTest {

	private StackSingleLinkedListNodeImpl<Integer> lista1;
	private StackSingleLinkedListNodeImpl<Integer> lista2;
	
	@Before
	public void setUp() throws Exception {
		lista1 = new StackSingleLinkedListNodeImpl<>(5);
		lista2 = new StackSingleLinkedListNodeImpl<>(0);
		
		lista1.push(1);
		lista1.push(2);
		lista1.push(3);
		
	}

	@Test(expected = StackUnderflowException.class)
	public void popTest() throws StackUnderflowException {
		assertEquals(new Integer(3), lista1.pop());
		assertEquals(new Integer(2), lista1.pop());
		assertEquals(new Integer(1), lista1.pop());
		lista1.pop();
	}
	
	@Test(expected = StackUnderflowException.class)
	public void popTest2() throws StackUnderflowException {
		lista2.pop();
	}
	
	@Test(expected = StackOverflowException.class)
	public void overflowTest() throws StackOverflowException {
		lista1.push(4);
		lista1.push(5);
		lista1.push(6);
	}
	
	@Test(expected = StackOverflowException.class)
	public void overflowTest2() throws StackOverflowException {
		lista2.push(4);
	}
	
	
	@Test
	public void topTest() {
		assertEquals(new Integer(3), lista1.top());
		assertEquals(null, lista2.top());
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(lista2.isEmpty());
	}
	
	@Test
	public void isFullTest() throws StackOverflowException {
		lista1.push(4);
		lista1.push(5);
		assertTrue(lista1.isFull());
	}
	
	
	
	

}
