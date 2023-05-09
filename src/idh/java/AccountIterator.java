package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Account [] account;
	int currentPosition = 0;
	
	 public AccountIterator(Account [] account) {
	        this.account = account;
	}        

	@Override
	public boolean hasNext() {
		return currentPosition < account.length;
	}

	@Override
	public Account next() {
		currentPosition++;
		return account [currentPosition];
	}

}
