package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Account[] account;
	int position = -1;
	
	public AccountIterator(Account account[]) {
		this.account = account;
	}
	
	@Override
	public boolean hasNext() {
			return position < account.length - 1;
		}


	@Override
	public Account next() {
		position++;
		return account[position];
	}

}
