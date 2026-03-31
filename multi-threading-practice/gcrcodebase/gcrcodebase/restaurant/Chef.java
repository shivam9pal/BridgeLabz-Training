package week08.gcrcodebase.restaurant;

public class Chef extends Thread {

    private final String dish;
    private final long cookingTime; 

    public Chef(String name, String dish, long cookingTime) {
        super(name);          
        this.dish = dish;
        this.cookingTime = cookingTime;
    }

    @Override
    public void run() {
        System.out.println(getName() +
                " started preparing " + dish);

        try {
            // 4 equal stages: 25%, 50%, 75%, 100%
            long stageTime = cookingTime / 4;

            for (int progress = 25; progress <= 100; progress += 25) {
                Thread.sleep(stageTime);
                System.out.println(getName() +
                        " preparing " + dish +
                        ": " + progress + "% complete");
            }

            System.out.println(getName() +
                    " completed " + dish);

        } catch (InterruptedException e) {
            System.out.println(getName() +
                    " was interrupted while preparing " + dish);
            Thread.currentThread().interrupt();
        }
    }
}

