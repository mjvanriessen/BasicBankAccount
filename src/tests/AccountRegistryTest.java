/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Jan 24, 2023
 */
package tests;
import model.Account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountRegistryTest {
	
	Account emptyAccount = new Account();
	Account savingsAccount1 = new Account("Savings", 50.00, "05-15-2019", 0.01);
	Account savingsAccount2 = new Account("Savings", 25.00, "07-09-2019", 0.01);
	Account cdAccount = new Account("CD", 200.0, "08-01-2019", 0.035, 1);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void accountFieldTest() {
		assertNull(emptyAccount.getAccountType());
		assertEquals(0, savingsAccount1.getMaturityRate());
		assertNotNull(cdAccount.getMaturityRate());
		assertEquals(1, cdAccount.getMaturityRate());
	}
	
	@Test
	public void valueTransferTest() {
		assertEquals("Invalid option for account type.", cdAccount.deposit(75.00));
		assertEquals("$75.0 deposit made,  new account balance: $125.0", savingsAccount1.deposit(75.00));
		
		assertEquals("Invalid option for account type", cdAccount.withdrawal(50.00));
		assertEquals("Insufficient funds in account.", savingsAccount2.withdrawal(75.00));
		assertEquals("$40.0 withdrawal made,  new account balance: $85.0", savingsAccount1.withdrawal(40.00));
		
		assertEquals("Invalid option for account type", cdAccount.interaccountTransfer(savingsAccount1, cdAccount, 100.00));
		assertEquals("Insufficient funds in account.", savingsAccount2.interaccountTransfer(savingsAccount2, savingsAccount1, 40.00));
		assertEquals("$40.0 transferred.", savingsAccount1.interaccountTransfer(savingsAccount1, savingsAccount2, 40.00));
	}

}
