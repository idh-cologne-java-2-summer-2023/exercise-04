package idh.java;

import java.util.Iterator;

class AccountIterator implements Iterator<Account> {
	int currentPosition = 0;
	Account[] accounts;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}

	public boolean hasNext() {
		return currentPosition < accounts.length;
	}

	public Account next() {
		return accounts[currentPosition++];
	}

}
