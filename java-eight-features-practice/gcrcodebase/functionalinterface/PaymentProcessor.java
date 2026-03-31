package week06.gcrcodebase.functionalinterface;

interface PaymentMethod{
	void upi();
	//new method
	default void creditCard() {
		System.out.println("the payment done by credit card..!");
	};
}
class Upi implements PaymentMethod{
	public void upi() {
		System.out.println("The payment done by UPI");
	}
}
class CreditCard implements PaymentMethod{
	@Override
	public void creditCard() {
		System.out.println("The payment done by Override Credit Card...!");
	}

	@Override
	public void upi() {
		System.out.println("the payment done by credit card..!");
		
	}
}

class PaymentProcessor {
	public static void main(String[] args) {
		PaymentMethod upi=new Upi();
		PaymentMethod credit=new CreditCard();
		upi.upi();
		credit.creditCard();
	}
}
