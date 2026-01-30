package JUnit_demo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MathUtilTest {
	@Test
	void devideByZero() {
		MathUtil mathUtil=new MathUtil();
		
		ArithmeticException exception= assertThrows(ArithmeticException.class, ()->mathUtil.devide(2, 0));
		assertEquals("cannot devide by zero", exception.getMessage());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,6})
	void testEvenNumber(int n) {
		assertTrue(true,MathUtil.isEven(n));
	}
	
	@ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int number) {
        assertFalse(MathUtil.isEven(number));
    }
}
