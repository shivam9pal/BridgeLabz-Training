package week04.gcrcodebase.reflection;
import java.lang.reflect.Field;
import java.util.Map;

class Student {
    private String name;
    private int age;
    private double marks;

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}



class SimpleObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create instance dynamically
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate through fields
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                String fieldName = field.getName();

                if (properties.containsKey(fieldName)) {
                    Object value = properties.get(fieldName);

                    // Handle primitive type conversions if needed
                    field.set(obj, value);
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


class MapperTest {

}
