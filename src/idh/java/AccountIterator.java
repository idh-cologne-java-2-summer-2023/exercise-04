package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Account[] accounts;
	int currentPosition = -1;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public boolean hasNext() {
		return this.currentPosition < this.accounts.length;
	}

	@Override
	public Account next() {
		return this.accounts[this.currentPosition++];
	}

}
