/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Jan 24, 2023
 */
package model;

import java.util.List;

public class Member {
	
	private String name;
	private String phoneNumber;
	private String address;
	private int memberRegistrationNumber;
	private List<Account> memberRegisteredAccounts;
	
	private static int registrationNumberBase = 1000;
	
	public Member() {
		
	}
	
	public Member(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.memberRegistrationNumber = registrationNumberBase;
		registrationNumberBase += 1;
	}
	
	public Member(String name, String phoneNumber, String address, List<Account> memberRegisteredAccounts) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.memberRegistrationNumber = registrationNumberBase;
		this.memberRegisteredAccounts = memberRegisteredAccounts;
		registrationNumberBase += 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMemberRegistrationNumber() {
		return memberRegistrationNumber;
	}

	public List<Account> getMemberRegisteredAccounts() {
		return memberRegisteredAccounts;
	}

	public void setMemberRegisteredAccounts(List<Account> memberRegisteredAccounts) {
		this.memberRegisteredAccounts = memberRegisteredAccounts;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", memberRegistrationNumber=" + memberRegistrationNumber + ", memberRegisteredAccounts="
				+ memberRegisteredAccounts + "]";
	}

}
