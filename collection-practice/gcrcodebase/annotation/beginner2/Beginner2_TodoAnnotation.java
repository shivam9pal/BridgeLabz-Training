package week04.gcrcodebase.annotation.beginner2;

import java.lang.reflect.Method;

class ProjectManager {

    @Todo(task = "Implement authentication", assignedTo = "Alice", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Auth implementation");
    }

    @Todo(task = "Fix login bug", assignedTo = "Bob")
    public void fixBug() {
        System.out.println("Bug fix");
    }

    @Todo(task = "Update documentation", assignedTo = "Charlie", priority = "LOW")
    public void updateDocs() {
        System.out.println("Docs updated");
    }
}

public class Beginner2_TodoAnnotation {

    public static void main(String[] args) {
        Method[] methods = ProjectManager.class.getDeclaredMethods();
        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}
