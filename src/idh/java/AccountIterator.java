package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
//nur für Aufgabe 1 gedacht	
	
	Account[] accounts;
	int currentPosition = -1;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public boolean hasNext() {
		return currentPosition < this.accounts.length - 1;
	}

	@Override
	public Account next() {
		currentPosition++;
		return accounts[currentPosition];
	}

}
