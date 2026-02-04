package week06.gcrcodebase.functionalinterface;

interface Device {
    void turnOn();
    void turnOff();
}

class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}
class AC implements Device {

    @Override
    public void turnOn() {
        System.out.println("AC is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is turned OFF");
    }
}
class Light implements Device {

    @Override
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

class SmartDevice {
	 

	    public static void main(String[] args) {

	        Device light = new Light();
	        Device ac = new AC();
	        Device tv = new TV();

	        light.turnOn();
	        ac.turnOn();
	        tv.turnOn();

	        System.out.println();

	        light.turnOff();
	        ac.turnOff();
	        tv.turnOff();
	    
	}

}
