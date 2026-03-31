package JUnit_demo.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@Before
	public void setup() {
		calculator =new Calculator();
	}
	
	@Test
	public void TestAdd() {
		assertEquals(4, calculator.add(3, 1));
	}
	@Test
	public void TestSub() {
		assertEquals(2, calculator.subtract(3, 1));
	}
	@Test
	public void TestMul() {
		assertEquals(3, calculator.mul(3, 1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestDevide() {
		assertEquals(3, calculator.device(3, 0));
	}
}
