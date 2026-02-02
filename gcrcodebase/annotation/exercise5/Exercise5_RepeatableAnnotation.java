package week04.gcrcodebase.annotation.exercise5;

import java.lang.reflect.Method;

class BugManager {

    @BugReport(description = "NullPointer exception in login")
    @BugReport(description = "UI rendering issue")
    public void processTransaction() {
        System.out.println("Processing transaction");
    }
}

public class Exercise5_RepeatableAnnotation {

    public static void main(String[] args) {
        Method[] methods = BugManager.class.getDeclaredMethods();
        for (Method method : methods) {
            BugReport[] reports = method.getAnnotationsByType(BugReport.class);
            if (reports.length > 0) {
                System.out.println("Method: " + method.getName());
                for (BugReport report : reports) {
                    System.out.println("  Bug: " + report.description());
                }
            }
        }
    }
}
