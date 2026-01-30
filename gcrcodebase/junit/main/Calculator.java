package JUnit_demo.JUnit;

public class Calculator {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public int device(int a, int b) {
		if(b==0) throw new IllegalArgumentException("Cannot device by Zero");
		return a/b;
	}
}
