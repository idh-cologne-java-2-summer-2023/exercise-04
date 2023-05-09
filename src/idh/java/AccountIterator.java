package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Bank bank;
	int position = 0;

	public AccountIterator(Bank bank) {
		this.bank = bank;
	}

	@Override
	public boolean hasNext() {
		return position < bank.accounts.size();
	}

	@Override
	public Account next() {
		return bank.getAccountByIndex(position++);
	}

}
