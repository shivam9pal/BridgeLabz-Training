package week04.gcrcodebase.reflection;

import java.lang.reflect.Field;

 class Configuration {

    private static String API_KEY = "ORIGINAL_KEY";

    public static void showKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}


class StaticFieldReflection {

    public static void main(String[] args) {
        try {
            // Show original key
            Configuration.showKey();

            // Get Class object
            Class<?> cls = Configuration.class;

            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");

            // Allow access
            field.setAccessible(true);

            // Modify static field (null because it's static)
            field.set(null, "UPDATED_KEY_123");

            // Print updated key
            Configuration.showKey();

            // Retrieve value using reflection
            String value = (String) field.get(null);
            System.out.println("Retrieved via reflection: " + value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

