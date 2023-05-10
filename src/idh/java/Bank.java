package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	Account[] accounts;
	
	public Bank(int numAccounts) {
		accounts = new Account[numAccounts];
		for (int i = 0; i < numAccounts; i++) {
			accounts[i] = new Account(i, i);
		}
	}
	
	public Iterator<Account> iterator() {
		return new BankIterator();
	}
	
	private class BankIterator implements Iterator<Account> {
		private int index = 0;
		
		public boolean hasNext() {
			return index < accounts.length;
		}
		
		public Account next() {
			return accounts[index++];
		}
	}
}
