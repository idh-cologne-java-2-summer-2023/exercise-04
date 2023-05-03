package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	private int index = 0;
	private final Account[] accounts;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}

	
	public boolean hasNext() {
		return index < accounts.length;
	}

	public Account next() {
		if (!hasNext()) {
			throw new RuntimeException("No more accounts.");
		}
		return accounts[index++];
	}
	
}