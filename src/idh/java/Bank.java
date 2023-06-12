package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	// accounts known to the ATM
	Account[] accounts = new Account[5];
		
		
	public Bank() {	
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	class AccountIterator implements Iterator<Account> {
		
		int currentPosition = 0;

		@Override
		public boolean hasNext() {
			return currentPosition < accounts.length;
		}

		@Override
		public Account next() {
			currentPosition += 1;
			return accounts[currentPosition-1];
		}
		
	}
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator();
	}
}
