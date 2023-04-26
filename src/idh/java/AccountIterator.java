package idh.java;

import java.util.Iterator;

class AccountIterator implements Iterator<Account> {
	Account[] accounts;
	int currentPos = 0;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public boolean hasNext() {
		return currentPos < accounts.length;
	}

	@Override
	public Account next() {
		return accounts[currentPos++];
	}

}