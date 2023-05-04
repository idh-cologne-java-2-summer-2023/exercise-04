package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Bank account;
	int counter = -1;
	
	public AccountIterator(Bank bank) {
		this.account = bank;
	}

	public boolean hasNext() {
		return counter < Bank.getAccountArrayLength() -1;
	}

	public Account next() {
		counter ++;
		return Bank.getAccountIter(counter);
	}

}
