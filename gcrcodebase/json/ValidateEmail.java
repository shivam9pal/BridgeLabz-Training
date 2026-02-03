package week05.gcrcodebase.json;
public class ValidateEmail {
	public static void main(String[] args) {
		String email = "test@gmail.com";
		
		if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Valid Email");
		}else {
			System.out.println("Invalid Email");
		}
	}
}
