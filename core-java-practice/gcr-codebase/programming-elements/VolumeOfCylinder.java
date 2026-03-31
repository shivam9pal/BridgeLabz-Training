package practiceProblemDay1;
import java.util.Scanner;

public class VolumeOfCylinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //Taking the user input 
        System.out.print("Enter radius= ");
        double radius = sc.nextDouble();

        System.out.print("Enter height= ");
        double height = sc.nextDouble();
        // Displayig the volume of cylinder
        double volume = Math.PI * radius * radius * height;
        System.out.println("Volume of Cylinder = " + volume);

	}

}
