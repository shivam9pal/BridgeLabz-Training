package week08.gcrcodebase.threadmonitoring;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

class StateMonitor extends Thread {

    private final Thread[] threads;
    private final Set<String> observedStates = new HashSet<>();

    public StateMonitor(Thread... threads) {
        this.threads = threads;
        setName("State-Monitor");
    }

    @Override
    public void run() {
        boolean allTerminated;

        do {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                observedStates.add(t.getName() + " -> " + state);

                System.out.println(
                        LocalTime.now() +
                        " | " + t.getName() +
                        " | State: " + state
                );

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            System.out.println("-----------------------------------");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("StateMonitor interrupted.");
                Thread.currentThread().interrupt();
            }

        } while (!allTerminated);

        printSummary();
    }

    private void printSummary() {
        System.out.println("\n📊 State Transition Summary:");
        for (String state : observedStates) {
            System.out.println(state);
        }
    }
}

