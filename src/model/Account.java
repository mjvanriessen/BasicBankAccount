/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Jan 24, 2023
 */
package model;

import java.text.DecimalFormat;

public class Account {
	
	private String accountType;
	private double accountBalance;
	private String dateOpened;
	private double interestRate;
	private int maturityRate;
	
	public Account() {
		
	}
	
	public Account(String accountType, double accountBalance, String dateOpened, double interestRate) {
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.dateOpened = dateOpened;
		this.interestRate = interestRate;
	}
	
	public Account(String accountType, double accountBalance, String dateOpened, double interestRate, int maturityRate) {
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.dateOpened = dateOpened;
		this.interestRate = interestRate;
		this.maturityRate = maturityRate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getMaturityRate() {
		return maturityRate;
	}

	public void setMaturityRate(int maturityRate) {
		this.maturityRate = maturityRate;
	}
	
	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", accountBalance=" + accountBalance + ", dateOpened="
				+ dateOpened + ", interestRate=" + interestRate + ", maturityRate=" + maturityRate + "]";
	}

	public String deposit(double depositValue) {
		if(this.accountType.equals("CD")) {
			return "Invalid option for account type.";
		}
		else {
			double total = getAccountBalance() + depositValue;
			setAccountBalance(total);
			return "$" + depositValue + " deposit made,  new account balance: $" + this.accountBalance;
		}
	}
	
	public String withdrawal(double withdrawalValue) {
		String outcome;
		if(this.accountType.equals("CD")) {
			outcome =  "Invalid option for account type";
		}
		else if(withdrawalValue > getAccountBalance()) {
			outcome =  "Insufficient funds in account.";
		}
		else {
			double total = getAccountBalance() - withdrawalValue;
			setAccountBalance(total);
			outcome = "$" + withdrawalValue + " withdrawal made,  new account balance: $" + getAccountBalance();
		}
		return outcome;
	}
	
	public String interaccountTransfer(Account transferFrom, Account transferTo, double value) {
		if(transferFrom.accountType.equals("CD") || transferTo.accountType.equals("CD")) {
			return "Invalid option for account type";
		}
		else if(transferFrom.getAccountBalance() < value) {
			return "Insufficient funds in account.";
		}
		else {
			double transferFromValue = transferFrom.getAccountBalance() - value;
			double transferToValue = transferTo.getAccountBalance() + value;
			transferFrom.setAccountBalance(transferFromValue);
			transferTo.setAccountBalance(transferToValue);
			return "$" + value + " transferred.";
		}
	}
	
	public String cdMaturityValue() {
		DecimalFormat f = new DecimalFormat("##.00");
		String valueCast;
		double matureValue = 0;
		if(this.accountType.equals("CD")) {
			matureValue = this.accountBalance * (Math.pow(1 + this.interestRate / 12, 12 * this.maturityRate));
		}
		else {
			valueCast = "";
			return valueCast;
		}
		valueCast = f.format(matureValue);
		return valueCast;
		
	}
	
	
	

}
