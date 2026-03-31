package week02.gcrCodebase.classObject;

public class AreaOfCircle {
	//Setting Attrubutes radius
	private double radius;
    void calculateAreaAndCircumference() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        //Displaying the Area and Circumference
        System.out.printf("Area of circle: %.4f\n", area);
        System.out.printf("Circumference of circle: %.4f\n", circumference);
    }

    public static void main(String[] args) {
    	AreaOfCircle c = new AreaOfCircle();
        c.radius = 2.5;
        //Calling Method
        c.calculateAreaAndCircumference();
    }

}
