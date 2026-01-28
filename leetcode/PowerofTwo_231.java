package week_4;

public class PowerofTwo_231 {
	public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
	public static void main(String[] args) {
		PowerofTwo_231 obj = new PowerofTwo_231();
		int number = 16;
		boolean result = obj.isPowerOfTwo(number);
		System.out.println(result);
	}
}
