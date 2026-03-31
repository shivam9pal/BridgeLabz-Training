package week04.scenariobased.backupscheduler;

import java.util.PriorityQueue;

public class BackupScheduler {

    public static void main(String[] args) {
        PriorityQueue<BackupTask> queue = new PriorityQueue<>();

        try {
        	 // critical
            queue.add(new BackupTask("/system/config", 5)); 
            queue.add(new BackupTask("/user/docs", 2));
            queue.add(new BackupTask("/logs", 1));
            // high priority
            queue.add(new BackupTask("/database", 4));       
            // queue.add(new BackupTask("", 3)); // would throw exception

        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Executing backup tasks in priority order:\n");

        while (!queue.isEmpty()) {
        	// gets highest priority first
            BackupTask task = queue.poll(); 
            task.execute();
        }
    }
}

