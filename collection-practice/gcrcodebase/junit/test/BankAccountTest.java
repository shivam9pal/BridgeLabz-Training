package JUnit_demo.JUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
	private BankAccount account;
	
	@BeforeEach
	void setUp() {
		account=new BankAccount(1000);
	}
	
	@Test
    void testDepositIncreasesBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }
	
	@Test
    void testWithdrawReducesBalance() throws InsufficientFundsException {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawFailsWhenInsufficientFunds() {
        Exception exception = assertThrows(
                InsufficientFundsException.class,
                () -> account.withdraw(2000)
        );

        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testMultipleTransactions() throws InsufficientFundsException {
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(300);

        assertEquals(1200, account.getBalance());
    }
}
