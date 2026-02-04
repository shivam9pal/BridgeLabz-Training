package week06.gcrcodebase.functionalinterface;

interface PasswordValidator{
	static boolean isValid(String password) {
		String pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[%$@#.-_]).{8,16}$";
		if(password.matches(pattern)) return true;
		return false;
	}
}

class PasswordStrengthValidator {
	public static void main(String[] args) {
		boolean passwordResponse=PasswordValidator.isValid("Shivam@12345");
		System.out.println(passwordResponse);
	}
}
