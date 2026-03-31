package week04.gcrcodebase.annotation.exercise2;

class LegacyAPI {

    @Deprecated(since = "1.5", forRemoval = true)
    public void oldFeature() {
        System.out.println("Old feature is running");
    }

    public void newFeature() {
        System.out.println("New feature is running");
    }
}

public class Exercise2_Deprecated {

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
