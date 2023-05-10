package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
	private Account[] accounts;
	private int position = 0;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}
	
	public boolean hasNext() {
		return position < accounts.length;
	}

	public Account next() {
		return accounts[position++];
	}
}
