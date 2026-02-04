package week06.gcrcodebase.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Alert class
class Alert {
    String message;
    String type; // NORMAL, WARNING, EMERGENCY

    public Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " : " + message;
    }
}

class MdeicalAlert {

    public static void main(String[] args) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("Patient temperature slightly high", "WARNING"));
        alerts.add(new Alert("Heart rate critical!", "EMERGENCY"));
        alerts.add(new Alert("Daily health check normal", "NORMAL"));
        alerts.add(new Alert("Blood sugar dropping fast", "EMERGENCY"));

        // User preference: show only EMERGENCY alerts
        Predicate<Alert> showEmergencyOnly = alert -> alert.type.equals("EMERGENCY");

        System.out.println("=== Showing Emergency Alerts ===");
        filterAlerts(alerts, showEmergencyOnly);
    }

    // Method that uses Predicate to filter
    public static void filterAlerts(List<Alert> alerts, Predicate<Alert> condition) {
        for (Alert alert : alerts) {
            if (condition.test(alert)) {
                System.out.println(alert);
            }
        }
    }
}


