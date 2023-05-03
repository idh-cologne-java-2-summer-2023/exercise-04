package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	public Account[] accountsObjects;
	int position = 0;

	AccountIterator(Account[] accountsObjects) {
		this.accountsObjects = accountsObjects;
	}

	@Override
	public boolean hasNext() {
		return position + 1 < accountsObjects.length;
	}

	@Override
	public Account next() {
		position++;
		return accountsObjects[position - 1];
	}
	
}
