package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	// accounts known to the ATM
	Account[] accounts = new Account[5]; 
		
	// create accounts with varying balances
	Random random = new Random(); {
	
	for (int i = 0; i < accounts.length; i++) {
	accounts[i] = new Account(i, random.nextInt(1000));
	}
	}

	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		for (Account account : accounts) {
			if (account.getId() == id) 
				return account;
		}
		return null; 
	}
	
	public static void main(String[] args) {
		
	AccountIterator iter = new AccountIterator(null);
	while (iter.hasNext());
		System.out.println(iter.next().getId());
	}
	
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

