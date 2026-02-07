package week08.gcrcodebase.threadmonitoring;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }

           
            Thread.sleep(2000);

            
            for (int i = 0; i < 1_000_000; i++) {
                Math.log(i + 1);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

