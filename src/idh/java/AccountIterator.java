package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	Account[] accounts;
	int currentPos = -1;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;

	}

	@Override
	public boolean hasNext() {
		return currentPos < accounts.length - 1;
	}

	@Override
	public Account next() {
		currentPos++;
		return accounts[currentPos];
	}

}
