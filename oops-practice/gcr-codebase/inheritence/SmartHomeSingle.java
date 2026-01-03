package week02.gcrcodebase.inheritence;

// Superclass
class Device {
    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status + ", Temperature Setting: " + temperatureSetting);
    }
}

public class SmartHomeSingle{

    public static void main(String[] args) {
        Thermostat t1 = new Thermostat(101, "ON", 24);
        t1.displayStatus();
    }
}
