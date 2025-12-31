package week02.gcrCodebase.constructor;

public class Circle {
    double radius;
    //default constructor
    Circle() {
        this(5.0);   // calls parameterized constructor
    }

    //parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }
    double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(7);

        System.out.println("Area: " + c1.area());
        System.out.println("Area: " + c2.area());
    }
}

