package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Bank bank;
	ATM atm;
	int currentPosition = -1;
	
	public AccountIterator (Bank bank, ATM atm) {
		this.bank = bank;
		this.atm = atm;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < bank.accounts.length - 1;
	}

	@Override
	public Account next() {
		currentPosition++;
		return atm.getAccount(currentPosition);
	}

}
