package week01.method;
import java.util.*;
public class FourDigitRandom {
	//Four digits random genrator
	public int[] generate4DigitRandomArray(int size){
		int[] randomArray=new int[size];
		if(size<0) {
			System.out.println("Enter the valid Size");
		}
		for(int i=0;i<size;i++) {
			randomArray[i]=(int)Math.random()*(9000)+1000;
		}
		
		return randomArray;
	}
	
	//To find Average of Array
	public double[] findAverageMinMax(int[] numbers) {
		
		int sum=0;
		for(int i=0;i<numbers.length;i++) {
			sum+=numbers[i];
		}
		//Find Average and sum
		double average=sum/numbers.length;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<numbers.length;i++) {
			max=Math.max(max,numbers[i]);
			min=Math.min(min,numbers[i]);
		}
		
		return new double[] {average,(double)max,(double)min};
	}
	
	
	public static void main(String[] args) {
		FourDigitRandom fd=new FourDigitRandom();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Count  of numbers: ");
		int size=sc.nextInt();
		int [] randomNumber=fd.generate4DigitRandomArray(size);
		double[] average=fd.findAverageMinMax(randomNumber);
		System.out.println(Arrays.toString(average));
	}
}
