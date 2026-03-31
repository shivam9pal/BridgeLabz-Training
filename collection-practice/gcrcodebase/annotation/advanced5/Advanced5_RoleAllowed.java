package week04.gcrcodebase.annotation.advanced5;

import java.lang.reflect.Method;

class AdminPanel {

    @RoleAllowed("ADMIN")
    public void deleteUser(int userId) {
        System.out.println("User " + userId + " deleted");
    }

    @RoleAllowed("ADMIN")
    public void viewSystemLogs() {
        System.out.println("System logs displayed");
    }

    public void viewProfile() {
        System.out.println("Profile viewed");
    }
}

class SecurityManager {

    private String userRole;

    public SecurityManager(String role) {
        this.userRole = role;
    }

    public void executeMethod(AdminPanel panel, String methodName, Object... args)
            throws Exception {
        Method method = null;
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        method = AdminPanel.class.getMethod(methodName, paramTypes);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (userRole.equals(roleAllowed.value())) {
                method.invoke(panel, args);
            } else {
                System.out.println("Access Denied! Required role: " + roleAllowed.value());
            }
        } else {
            method.invoke(panel, args);
        }
    }
}

public class Advanced5_RoleAllowed {

    public static void main(String[] args) throws Exception {
        AdminPanel panel = new AdminPanel();

        System.out.println("=== ADMIN USER ===");
        SecurityManager admin = new SecurityManager("ADMIN");
        admin.executeMethod(panel, "deleteUser", 123);

        System.out.println("\n=== GUEST USER ===");
        SecurityManager guest = new SecurityManager("GUEST");
        guest.executeMethod(panel, "deleteUser", 456);

        System.out.println();
        admin.executeMethod(panel, "viewProfile");
    }
}
