package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	ATM atm;
	int currentPosition = 0;
	
	public AccountIterator(ATM atm) {
		this.atm = atm;
	}
	
	@Override
	public boolean hasNext() {
		return currentPosition < atm.accounts.length; 
	}

	@Override
	public Account next() {
		currentPosition++;
		return atm.getAccount(currentPosition);
	}

}
