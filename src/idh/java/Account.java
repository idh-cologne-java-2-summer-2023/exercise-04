package idh.java;

public class Account {
	private String name;
	private int accountNumber;
	private int accountBalance;
	private int pin;
	
	
	public Account (int accountNumber, String name) {
		
	}

	public Account(String newName, int newAccountNumber, int newAccountBalance, int newpin) {
		name = newName;
		accountNumber = newAccountNumber;
		accountBalance = newAccountBalance;
		pin = newpin;
	}
	
	public boolean validatePin(int userPIN) {
		if(userPIN == pin) {
			return true;
		} else {
			return false;
		}
	}

	public void withdraw (int amount) {
		accountBalance -= amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
