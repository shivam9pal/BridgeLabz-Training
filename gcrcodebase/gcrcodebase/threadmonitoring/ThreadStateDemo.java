package week08.gcrcodebase.threadmonitoring;

class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner task1 = new TaskRunner("TaskRunner-1");
        TaskRunner task2 = new TaskRunner("TaskRunner-2");

        // Threads are NEW here
        StateMonitor monitor = new StateMonitor(task1, task2);

        System.out.println("Initial States:");
        System.out.println(task1.getName() + ": " + task1.getState());
        System.out.println(task2.getName() + ": " + task2.getState());
        System.out.println("-----------------------------------");

        task1.start();
        task2.start();
        monitor.start();

        task1.join();
        task2.join();
        monitor.join();

        System.out.println("\nAll tasks completed. Monitoring stopped.");
    }
}

