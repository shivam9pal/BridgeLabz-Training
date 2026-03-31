package week03.scenariobased.factoryhazardrobot;

import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		RobotHazardEditor hazard=new RobotHazardEditor();
		
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter Arm Precision (0.0 - 1.0):");
			double armPricison=Double.parseDouble(sc.nextLine());
			System.out.println("Enter Worker Density (1 - 20):");
			int workerDesnity=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
			String machieryState=(sc.nextLine());
			
			double response=hazard.calculateHazardRisk(armPricison, workerDesnity, machieryState);
			System.out.println("Robot Hazard Risk Score: "+response);
			sc.close();
		} catch (RobotSafetyException e) {
			sc.close();
			System.out.println(e.getMessage());
		}
	}
}
