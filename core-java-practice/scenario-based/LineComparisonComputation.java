package scenarioBased;

import java.util.Scanner;
public class LineComparisonComputation {
	//Calculate Length
	public static double lengthOfStarightLine(int x1,int x2,int y1, int y2) {
		double length=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		return length;
	}
	
	//Comparing length 
	public static boolean lengthCompare(double lengthOne,double lengthTwo) {
		String lenOne=String.valueOf(lengthOne);
		String lenTwo=String.valueOf(lengthTwo);
		if(lenOne.equals(lenTwo)) {
			return true;
		}
		return false;
	}
	//Using CompareTo
	public static void greaterOrlessLength(double lengthOfOne,double lengthOfTwo) {
		int result=Double.valueOf(lengthOfOne).compareTo(Double.valueOf(lengthOfTwo));
		if(result<0) {
			System.out.println("The length of Line 1 is lesser than length of Line two ");
		}else if(result==0) {
			System.out.println("The length of Line 1 is equals to the length of Line two ");
		}else {
			System.out.println("The length of Line 1 is greater than length of Line two ");
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("-------Welcome to line comparison computation program---------");
		//Taking input for straight line 
		System.out.println("Enter the Value for for Line 1 & Line 2 ");
		System.out.println("Enter values in one line:");
        System.out.print("x1 y1 x2 y2 x1 y1 x2 y2");

        int x1  = sc.nextInt();
        int y1  = sc.nextInt();
        int x2  = sc.nextInt();
        int y2  = sc.nextInt();
        int x11 = sc.nextInt();
        int y11 = sc.nextInt();
        int x21 = sc.nextInt();
        int y21 = sc.nextInt();
		
		//Gets length of line 
		double lengthOfOne=lengthOfStarightLine(x1,x2,y1,y2);
		double lengthOfTwo=lengthOfStarightLine(x11,x21,y11,y21);
		
		//compairing length
		boolean result=lengthCompare(lengthOfOne,lengthOfTwo);
		//Displaying result
		System.out.println("---The Result of Two length Comparison is :"+result);
		System.out.println("---The Length of line One is :"+lengthOfOne);
		System.out.println("---The Length of line Two is :"+lengthOfTwo);
		//Displaying CompareTo
		greaterOrlessLength(lengthOfOne,lengthOfTwo);
		
		
		
		
		
		
	}

}
