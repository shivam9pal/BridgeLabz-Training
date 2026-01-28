package week04.scenariobased.backupscheduler;

class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority; // higher value = higher priority

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Backup path is invalid!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        // Higher priority first
        return Integer.compare(other.priority, this.priority);
    }

    public void execute() {
        System.out.println("Backing up: " + folderPath + 
                           " (Priority: " + priority + ")");
    }
}

