package week_5;

public class FractionAdditionandSubtraction_592 {
	public String fractionAddition(String expression) {
        int num = 0;   
        int den = 1;   
        
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            int sign = 1;
            
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = (expression.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            
            int currNum = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currNum = currNum * 10 + (expression.charAt(i) - '0');
                i++;
            }
            currNum *= sign;
            i++; 
            
            int currDen = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currDen = currDen * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            num = num * currDen + currNum * den;
            den = den * currDen;
            
            int g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
        }
        
        return num + "/" + den;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
	public static void main(String[] args) {
		FractionAdditionandSubtraction_592 obj = new FractionAdditionandSubtraction_592();
		String expression = "-1/2+1/2+1/3";
		System.out.println(obj.fractionAddition(expression));
	}
}
