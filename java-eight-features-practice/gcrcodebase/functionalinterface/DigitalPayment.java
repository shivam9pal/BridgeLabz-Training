package week06.gcrcodebase.functionalinterface;

interface Payment {
    void pay(double amount);
}
class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}
class WalletPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet.");
    }
}

class DigitalPayment {
	public static void main(String[] args) {

        Payment creditCard = new CreditCardPayment();
        Payment upi = new UPIPayment();
        Payment wallet = new WalletPayment();

        creditCard.pay(1500);
        upi.pay(800);
        wallet.pay(500);
    }
}
