package week04.gcrcodebase.annotation.beginner1;

import java.lang.reflect.Method;

class CriticalOperations {

    @ImportantMethod(level = "CRITICAL")
    public void initializeSystem() {
        System.out.println("System initialized");
    }

    @ImportantMethod(level = "HIGH")
    public void backupDatabase() {
        System.out.println("Backup completed");
    }

    public void regularTask() {
        System.out.println("Regular task");
    }
}

public class Beginner1_ImportantMethod {

    public static void main(String[] args) {
        Method[] methods = CriticalOperations.class.getDeclaredMethods();
        System.out.println("Important Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Level: " + imp.level());
            }
        }
    }
}
