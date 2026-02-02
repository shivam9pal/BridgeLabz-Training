package week04.gcrcodebase.annotation.advanced6;

import java.lang.reflect.Field;

class Person {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    @JsonField(name = "user_age")
    private int age;

    public Person(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

public class Advanced6_JsonField {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (fields[i].isAnnotationPresent(JsonField.class)) {
                JsonField jf = fields[i].getAnnotation(JsonField.class);
                try {
                    Object value = fields[i].get(obj);
                    json.append("\"").append(jf.name()).append("\":");
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    if (i < fields.length - 1) {
                        json.append(", ");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Person person = new Person("john_doe", "john@example.com", 30);
        String jsonString = toJson(person);
        System.out.println("JSON Output: " + jsonString);
    }
}
