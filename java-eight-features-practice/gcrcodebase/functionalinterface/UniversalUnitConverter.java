package week06.gcrcodebase.functionalinterface;


interface UnitConverter {

    // Convert kilometers to miles
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert kilograms to pounds
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
}

class UniversalUnitConverter {
	public static void main(String[] args) {

        double distanceKm = 10;
        double weightKg = 5;

        double miles = UnitConverter.kmToMiles(distanceKm);
        double pounds = UnitConverter.kgToLbs(weightKg);

        System.out.println(distanceKm + " km = " + miles + " miles");
        System.out.println(weightKg + " kg = " + pounds + " lbs");
    }
}
