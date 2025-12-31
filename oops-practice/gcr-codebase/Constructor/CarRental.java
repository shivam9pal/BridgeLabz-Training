package week02.gcrCodebase.constructor;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500;

    // Constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    //Calculating cost
    double calculateCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println(customerName);
        System.out.println(carModel);
        System.out.println("Total Cost: " + calculateCost());
    }

    public static void main(String[] args) {
        CarRental cr = new CarRental("Shivam", "Swift", 4);
        cr.display();
    }
}

