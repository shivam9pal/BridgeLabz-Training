package JUnit_demo.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {
	
	private StringUtils utils;
	
	@Before
	public void setup() {
	    utils=new StringUtils();
	}
	
	@Test
	public void testReverse() {
		assertEquals("cba", utils.reverse("abc"));
        assertEquals("", utils.reverse(""));
        assertNull(utils.reverse(null));
	}
	
	  @Test
	    public void testIsPalindrome() {
	        assertTrue(utils.isPalindrome("madam"));
	        assertTrue(utils.isPalindrome("Race car")); // ignores case & spaces
	        assertFalse(utils.isPalindrome("hello"));
	        assertFalse(utils.isPalindrome(null));
	    }

	    @Test
	    public void testToUpperCase() {
	        assertEquals("HELLO", utils.toUpperCase("hello"));
	        assertEquals("JAVA", utils.toUpperCase("Java"));
	        assertNull(utils.toUpperCase(null));
	    }
}
