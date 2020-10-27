import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class LCATest {
	public void testIsTreeEmpty()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		boolean isEmpty = test.isEmpty();
		assertEquals(isEmpty, true);
		test.put(3, 6);
		test.put(6, 12);
		test.put(9, 15);
		test.put(12, 18);
		isEmpty = test.isEmpty();
		assertEquals(isEmpty, false);
	}
	@Test
	public void testTreeSize()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		assertEquals(test.size(), 0);
		test.put(1, 1);
		assertEquals(test.size(), 1);
		test.put(2, 4);
		test.put(3, 6);
		assertEquals(test.size(), 3);
		test.put(1, 8);
		assertEquals(test.size(), 3); //Size doesn't change as element already exists
	}
	
	@Test
	public void testGet()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		assertNull(test.get(3));
		test.put(3, 1);
		assertSame(test.get(3), 1);
		test.put(4,2);
		test.put(5, 3);
		test.put(6, 4);
		assertSame(test.get(5), 3);
		
	}
	@Test
	public void testFullTree()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(1, 11);
		test.put(2, 10);
		test.put(3, 9);
		test.put(4, 8);
		test.put(5, 7);
		test.put(6, 6);
		test.put(7, 5);
		test.put(8, 4);
		test.put(9, 3);
		test.put(10, 2);
		test.put(11, 1);
		assertSame(test.search(test.root,7,8).key,7);
		assertSame(test.search(test.root,4,5).key,4);
		assertSame(test.search(test.root,2,3).key,2);	
	}
	
	@Test
	public void testTwoNodes()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(7, 1);
		test.put(8, 2);
		assertSame(test.search(test.root, 7, 8).key, 7);
		assertNull(test.search(test.root, 7, 1)); //Test to see if one node doesn't exist
	}
	@Test
	public void testForNonExistingNodes()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(1, 6);
		test.put(2, 5);
		test.put(3, 4);
		test.put(4, 3);
		test.put(5, 2);
		test.put(6, 1);
		
		assertNull(test.search(test.root, 7, 10));
		assertNull(test.search(test.root, 8, 9));
		assertNull(test.search(test.root, 9, 8));
		assertNull(test.search(test.root, 10, 7));
	}

@Test 
	public void testSameValue()
	{
	LCA<Integer, Integer> test = new LCA<Integer, Integer>();
	test.put(1, 6);
	test.put(2, 5);
	test.put(3, 4);
	test.put(4, 3);
	test.put(5, 2);
	test.put(6, 1);
	
	assertSame(test.search(test.root, 1,1).key, 1);
	assertSame(test.search(test.root, 4, 4).key, 4);
	}
}
