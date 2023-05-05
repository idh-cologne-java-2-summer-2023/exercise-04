package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	Account[] accounts;

	public Bank() {
		accounts = new Account[10];
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}	
	}

	public Account[] getAccounts() {
		return accounts;
	}

	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator();
	}
	
	private class AccountIterator implements Iterator<Account>{
			
			int cPos;
			
			public AccountIterator() {
				cPos = 0;
			}
			@Override
			public boolean hasNext() {
				return cPos < getAccounts().length;
			}
			@Override
			public Account next() {
				cPos++;
				return getAccounts()[cPos-1];
			}
		}
		
}
