import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class LCATest {
	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA of empty tree: ", null, tree.findLCA(1, 2));
	}
	
	@Test
	public void testSimpleLCA(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.leftside = new Node(2);
		tree.root.rightside = new Node(3);
		tree.root.leftside.leftside = new Node(4);
		tree.root.leftside.rightside = new Node(5);
		tree.root.rightside.leftside = new Node(6);
		tree.root.rightside.rightside = new Node(7);
		assertEquals("LCA of 2 and 3: ", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 4 and 5: ", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7: ", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 6: ", 1, tree.findLCA(4, 6).data);
	}

	@Test
	public void testForNonExistentNodes(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.leftside = new Node(2);
		tree.root.rightside = new Node(3);
		tree.root.leftside.leftside = new Node(4);
		tree.root.leftside.rightside = new Node(5);
		tree.root.rightside.leftside = new Node(6);
		tree.root.rightside.rightside = new Node(7);
		assertEquals("LCA of non-existent nodes: ", null, tree.findLCA(8, 9));
	}
	
	@Test
	public void testTwoNodes(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.leftside = new Node(2);
		assertEquals("LCA of root and only one child: ", 1, tree.findLCA(1, 2).data);	
	}
	
	@Test
	public void testSize15Nodes() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.leftside = new Node(2);
		tree.root.rightside = new Node(3);
		tree.root.leftside.leftside = new Node(4);
		tree.root.leftside.rightside = new Node(5);
		tree.root.rightside.leftside = new Node(6);
		tree.root.rightside.rightside = new Node(7);
		tree.root.leftside.leftside.leftside = new Node(8);
		tree.root.leftside.leftside.rightside = new Node(9);
		tree.root.leftside.rightside.leftside = new Node(10);
		tree.root.leftside.rightside.rightside = new Node(11);
		tree.root.rightside.leftside.leftside = new Node(12);
		tree.root.rightside.leftside.rightside = new Node(13);
		tree.root.rightside.rightside.leftside = new Node(14);
		tree.root.rightside.rightside.rightside = new Node(15);

		assertEquals("LCA of 1 and 2", 1, tree.findLCA(1, 2).data);
		assertEquals("LCA of 2 and 3", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 2 and 4", 2, tree.findLCA(2, 4).data);
		assertEquals("LCA of 4 and 5", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 8", 4, tree.findLCA(4, 8).data);
		assertEquals("LCA of 8 and 9", 4, tree.findLCA(8, 9).data);
		assertEquals("LCA of 6 and 12", 6, tree.findLCA(6, 12).data);
		assertEquals("LCA of 14 and 15", 7, tree.findLCA(14, 15).data);
		assertEquals("LCA of 8 and 2", 2, tree.findLCA(8, 2).data);
		assertEquals("LCA of 9 and 11", 2, tree.findLCA(9, 11).data);
		assertEquals("LCA of 13 and 14", 3, tree.findLCA(13, 14).data);
		assertEquals("LCA of 15 and 1", 1, tree.findLCA(15, 1).data);
	}
	
	@Test
	public void noOrderTest() {
		LCA tree = new LCA();
		tree.root = new Node(5);
		tree.root.leftside = new Node(3);
		tree.root.rightside = new Node(1);
		tree.root.leftside.leftside = new Node(4);
		tree.root.leftside.rightside = new Node(7);
		tree.root.rightside.leftside = new Node(2);
		tree.root.rightside.rightside = new Node(6);

		assertEquals("LCA of tree with no order", 5,
				tree.findLCA(6, 4).data);
		assertEquals("LCA of tree with no order", 3,
				tree.findLCA(3, 4).data);
		assertEquals("LCA of tree with no order", 1,
				tree.findLCA(6, 2).data);
		assertEquals("LCA of tree with no order", 5,
				tree.findLCA(7, 2).data);
	}
}
