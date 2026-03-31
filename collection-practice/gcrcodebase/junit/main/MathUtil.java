package JUnit_demo.JUnit;

class MathUtil {
	
	public int devide(int a,int b) {
		if(b==0) {
			throw new ArithmeticException("cannot devide by zero");
		}
		return a/b;
	}
	
	public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
