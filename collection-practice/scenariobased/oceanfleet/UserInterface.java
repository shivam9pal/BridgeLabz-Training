package week04.scenariobased.oceanfleet;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		VesselUtil vu = new VesselUtil();
		
		System.out.println("Enter the number of vessels to be added");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter vessel details");
		for(int i=0; i<n; i++) {
			String [] arr = sc.nextLine().split(":");
			
			Vessel v = new Vessel(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
			
			vu.addVesselPerformance(v);
		}
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Enter the Vessel Id to check speed");
		String id = sc.nextLine();
		System.out.println(vu.getVesselById(id));
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("High performance vessels are");
		
		vu.getHighPerformanceVessels().forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------");
		
		

		sc.close();
	}
}
