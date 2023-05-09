package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{

	// accounts known to the ATM
		Account[] accounts = new Account[5];
		
	public Bank() {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this, null);
	}

}
