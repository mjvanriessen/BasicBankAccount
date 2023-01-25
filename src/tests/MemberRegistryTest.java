/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Jan 24, 2023
 */
package tests;
import model.Account;
import model.Member;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;


public class MemberRegistryTest {
	
	List<Account> mAccounts1 = new ArrayList<Account>();
	Account savingsM1 = new Account("Savings", 1000.00, "02-05-2015", 0.00);
	Account cdM1 = new Account("CD", 6000.00, "03-07-2016", 0.045, 2);
	Member member1 = new Member("Michael", "111-222-3333", "123 Main Street");
	
	List<Account> mAccounts2 = new ArrayList<Account>();
	Account savingsM2 = new Account("Savings", 650.00, "01-03-2023", 0.00);
	Account checkingM2 = new Account("Checking", 125.00, "01-03-2023", 0.00);
	Member member2 = new Member("John", "333-333-4444", "456 1st Avenue", mAccounts2);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void accountSetupTest() {
		mAccounts1.add(savingsM1);
		mAccounts1.add(cdM1);
		member1.setMemberRegisteredAccounts(mAccounts1);
		mAccounts2.add(savingsM2);
		mAccounts2.add(checkingM2);
		System.out.println(member1.toString());
		System.out.println(member2.toString());
	}
	
	@Test
	public void memberAccountMaturityTest() {
		mAccounts1.add(cdM1);
		member1.setMemberRegisteredAccounts(mAccounts1);
		assertEquals("6563.94", member1.getMemberRegisteredAccounts().get(0).cdMaturityValue());
	}

}
