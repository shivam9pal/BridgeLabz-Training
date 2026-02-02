package week04.gcrcodebase.reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}

class SimpleDIContainer {

    public static <T> T getInstance(Class<T> clazz) {
        try {
            // Create main object
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Inject dependencies
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {

                    field.setAccessible(true);

                    // Create dependency instance
                    Object dependency =
                            field.getType().getDeclaredConstructor().newInstance();

                    // Inject dependency
                    field.set(obj, dependency);
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class DITest {

    public static void main(String[] args) {

        Car car = SimpleDIContainer.getInstance(Car.class);
        car.drive();
    }
}

