package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Account[] accounts;
	int searchedAcc;
	int currentPosition = -1;
	
	public AccountIterator(Bank bank, ATM atm) {
		this.accounts = bank.getAccount();
		this.searchedAcc = ATM.getID();
	}

	public boolean hasNext() {
		return currentPosition < accounts.length -1;
	}

	// gives back the searched account of the type Account
	public Account next() {
		currentPosition++;
		for (Account account : accounts) {
			if (account.getId() == searchedAcc) 
				return account;
		}
		return null;
	}

}
