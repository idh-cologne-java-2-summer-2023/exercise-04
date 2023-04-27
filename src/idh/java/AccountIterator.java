package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{

	static int position = 0;
	
	static Account[] accounts;
	public AccountIterator(	Account[] accounts){
		accounts = Bank.accounts;
	}
	
	public static void main(String[] args) {
	}

	@Override
	public boolean hasNext() {
		return position < accounts.length;
	}

	@Override
	public Account next() {
		return accounts[position++];
	}

}
