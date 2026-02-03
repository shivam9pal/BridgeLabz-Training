package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}

public class CarToJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("Toyota", 2023);

        String json = mapper.writeValueAsString(car);

        System.out.println(json);
    }
}
