package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	Account[] accounts = new Account[5];
	ATM atm; 
	
	public Bank(ATM atm) {
		this.atm = atm; 
		
	}

	@Override 
	public Iterator<Account> iterator() {
		return atm.new AccountIterator(this);
	}
	
}
