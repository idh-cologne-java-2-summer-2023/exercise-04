package idh.java;

import java.util.Iterator;

public class Bank  implements Iterable<Account>{
	private static Account[] accounts;
	public Bank() {
		accounts = new Account[2];
		accounts[0] = new Account("Alex", 420, 100, 187);
		accounts[1] = new Account("Lago", 2012, 5000, 187);
	}
	/**
	private static Account getAccount(int accountNumber) {
		for(Account currentAccount : accounts) {
			if(currentAccount.getAccountNumber()== accountNumber) 
				return currentAccount; 
		}
		return null; 
	} **/
	
	public static Account getAccountIter(int accountNumber) {
		for(Account currentAccount : accounts) {
			if(currentAccount.getAccountNumber()== accountNumber) 
				return currentAccount; 
		}
		return null; 
	}
	
	public static boolean authenticateUser(int userAccountNumber, int userPin) {
		Account userAccount = getAccountIter(userAccountNumber);
		if(userAccount !=null) {
			return userAccount.validatePin(userPin);
		} else {
			return false;
		}
	}
	public String getName(int userAccountNumber) {
		return getAccountIter(userAccountNumber).getName();
	}
	public static int getAccountBalance(int userAccountNumber) {
		return getAccountIter(userAccountNumber).getAccountBalance();
	}
	public static void withdraw(int userAccountNumber, int withdrawamount) {
		getAccountIter(userAccountNumber).withdraw(withdrawamount);
	}
	public static int getAccountArrayLength() {
		return accounts.length;
	}
	
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	}
}
