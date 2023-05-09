package idh.java;

import java.util.Iterator;
import java.util.Random;

class Bank implements Iterable<Account> {
	
	// accounts known to the Bank
	Account[] accounts;

	public Bank(int numAccounts) {
		// create accounts with varying balances
		Random random = new Random();
		accounts = new Account[numAccounts];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return iterator();
	}}