package JUnit_demo.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	private ListManager listManager;
	private List<Integer> list;
	
	@Before
	public void setUp() {
		listManager=new ListManager();
	}
	
	
	//test add element
	@Test
	 void testAdd() {
		listManager.addElement(list, 20);
		listManager.addElement(list, 20);
		
		assertTrue(list.contains(10));
		assertTrue(list.contains(20));
		
		assertEquals(2, listManager.getSize(list));
		
	}
}
