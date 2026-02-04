package week06.gcrcodebase.functionalinterface;


//Marker Interface (no methods)
interface SensitiveData {
}
class UserCredentials implements SensitiveData {
    String username;
    String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
class BankDetails implements SensitiveData {
    String accountNumber;

    public BankDetails(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
class ProductInfo {
    String name;

    public ProductInfo(String name) {
        this.name = name;
    }
}

class EncryptionProcessor {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println(obj.getClass().getSimpleName() + " is encrypted before storage.");
        } else {
            System.out.println(obj.getClass().getSimpleName() + " does not require encryption.");
        }
    }
}
class SensitiveDataTagging {
	public static void main(String[] args) {
		

	        UserCredentials user = new UserCredentials("john", "pass123");
	        BankDetails bank = new BankDetails("123456789");
	        ProductInfo product = new ProductInfo("Laptop");

	        EncryptionProcessor.process(user);
	        EncryptionProcessor.process(bank);
	        EncryptionProcessor.process(product);
	    
	}
}
