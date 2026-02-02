package week04.gcrcodebase.reflection;



import java.lang.reflect.Field;

class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}


class JsonUtil {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                String name = field.getName();
                Object value = field.get(obj);

                json.append("\"").append(name).append("\":");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(",");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

class JsonTest {

    public static void main(String[] args) {
        Student s = new Student("Alice", 22, 89.5);

        String json = JsonUtil.toJson(s);
        System.out.println(json);
    }
}

