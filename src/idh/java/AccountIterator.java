package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Account [] account;
	int currentPosition = 0; //i
	
	public AccountIterator(Account [] account) {
		this.account = account;
	}
	
	@Override
	public boolean hasNext() { // gibt es eine nächste Speicherstelle im Array?
		return currentPosition < account.length;
	}

	@Override
	public Account next() {  // nächste Position im Array
		currentPosition++;
		return account [currentPosition];
	}

}
