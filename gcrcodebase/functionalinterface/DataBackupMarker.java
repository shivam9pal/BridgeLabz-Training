package week06.gcrcodebase.functionalinterface;

//Marker Interface (no methods)
interface BackupSerializable {
}
class Patient implements BackupSerializable {
    String name;
    int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Invoice implements BackupSerializable {
    String invoiceId;

    public Invoice(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
class TempLog {
    String message;

    public TempLog(String message) {
        this.message = message;
    }
}

class BackupProcessor {

    public static void processBackup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println(obj.getClass().getSimpleName() + " is backed up.");
        } else {
            System.out.println(obj.getClass().getSimpleName() + " is NOT eligible for backup.");
        }
    }
}		



class DataBackupMarker {
	
		public static void main(String[] args) {

	        Patient p = new Patient("John", 30);
	        Invoice i = new Invoice("INV123");
	        TempLog log = new TempLog("Session started");

	        BackupProcessor.processBackup(p);
	        BackupProcessor.processBackup(i);
	        BackupProcessor.processBackup(log);
	    
	}
}
