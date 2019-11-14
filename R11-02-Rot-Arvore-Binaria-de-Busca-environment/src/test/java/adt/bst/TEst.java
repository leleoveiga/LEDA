package adt.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.bt.BTNode;

class TEst {
	
	BSTImpl<Integer> bst;
	private BTNode<Integer> NIL = new BTNode<Integer>();
	
	@BeforeEach
	void setUp() {
		bst = new BSTImpl<>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(20);
		bst.insert(30);
		bst.insert(70);
		bst.insert(80);
		bst.insert(15);
		bst.insert(27);
		bst.insert(33);
		bst.insert(26);
		bst.insert(28);
		bst.insert(72);
		bst.insert(81);
	}
	

	@Test
	void testHeight() {
		BSTImpl<Integer> bst2 = new BSTImpl<>();
		assertEquals(-1,  bst2.height());
		bst2.insert(1);
		bst2.insert(2);
		assertEquals(1,  bst2.height());
		assertEquals(4,  bst.height());
		
	}
	
	@Test
	void testSearch() {
		assertEquals(bst.search(70).getData(), new Integer(70));
		BSTImpl<Integer> bst2 = new BSTImpl<>();
		assertEquals(NIL , bst2.search(2));
		bst2.insert(2);
		assertEquals(bst2.search(2).getData(), new Integer(2));
		assertEquals(bst.search(82), NIL);
	}
	
	@Test
	void testMinimum() {
		assertEquals(bst.minimum().getData(), new Integer(15));
	}
	
	@Test
	void testSucessor() {
		assertEquals(bst.sucessor(50).getData(), new Integer(70));
		assertEquals(bst.sucessor(25).getData(), new Integer(26));
		assertEquals(bst.sucessor(82), new BSTNode<>());
		assertEquals(bst.sucessor(81).getData(), new Integer(81));
	}
	@Test
	void testPredecessor() {
		assertEquals(bst.predecessor(50).getData(), new Integer(33));
		assertEquals(bst.predecessor(25).getData(), new Integer(20));
		assertEquals(bst.predecessor(82), null);
		assertEquals(bst.predecessor(81), null);
	}

}
