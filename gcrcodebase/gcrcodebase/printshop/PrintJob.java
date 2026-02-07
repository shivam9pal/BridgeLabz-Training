package week08.gcrcodebase.printshop;

public class PrintJob implements Runnable {

    private final String jobName;
    private final int pages;
    private final int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() +
                " started printing " + jobName +
                " (Priority: " + priority + ")"
        );

        try {
            for (int page = 1; page <= pages; page++) {
                Thread.sleep(100); // 100ms per page
                System.out.println(
                        "Printing " + jobName +
                        " - Page " + page +
                        " of " + pages
                );
            }

            System.out.println(
                    Thread.currentThread().getName() +
                    " completed " + jobName
            );

        } catch (InterruptedException e) {
            System.out.println(jobName + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

