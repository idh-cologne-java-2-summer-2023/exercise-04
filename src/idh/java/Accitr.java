package idh.java;

import java.util.Iterator;

public class Accitr implements Iterator<Account> {

	int currentPosition = -1;
	Account[] tempaccount;

	public Accitr(Account[] accounts) {
		this.tempaccount = accounts;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < tempaccount.length +1;
	}

	@Override
	public Account next() {
		currentPosition ++;
		return tempaccount[currentPosition];
	}

}
