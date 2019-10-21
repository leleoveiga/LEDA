package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import problems.FloorCeilBinarySearch;

public class FloorCeilBinarySearchTest {
	
	FloorCeilBinarySearch busca;

	@Before
	public void setUp() throws Exception {
		busca = new FloorCeilBinarySearch();
	}

	@Test
	public void testFloor() {
		Integer[] v = {0,1,2,4};
		assertEquals(2, busca.binarySearchFloor(v, 0, v.length, 3));
		
	}

	@Test
	public void testCeil() {
		Integer[] v = {0,1,2,4};
		assertEquals(4, busca.binarySearchCeil(v, 0, v.length, 3));
	}

}
