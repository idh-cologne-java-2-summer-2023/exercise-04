package idh.java;

import java.util.Iterator;

class AccountIterator implements Iterator<Account> {
	int currentPosition = 0;
	Account[] account;

	public AccountIterator(Account[] accounts) {
		this.account = accounts;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < account.length;
	}

	@Override
	public Account next() {
		return account[currentPosition++];
	}

}
