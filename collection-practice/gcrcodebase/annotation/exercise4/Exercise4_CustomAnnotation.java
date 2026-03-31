package week04.gcrcodebase.annotation.exercise4;

import java.lang.reflect.Method;

class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Alice")
    public void deployProject() {
        System.out.println("Deploying project");
    }

    @TaskInfo(priority = 2, assignedTo = "Bob")
    public void testFeature() {
        System.out.println("Testing feature");
    }
}

public class Exercise4_CustomAnnotation {

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        Method[] methods = TaskManager.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
                System.out.println();
            }
        }
    }
}
