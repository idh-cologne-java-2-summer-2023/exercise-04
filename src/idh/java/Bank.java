package idh.java;

import java.util.Iterator;
import java.util.Random;
import java.lang.Iterable;

public class Bank implements Iterable<Account>{
	
	// accounts known to the ATM
	Account[] accounts = new Account[5];
	
	public Bank () {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}


	public static void main(String[] args) {
		
	}
	
	protected Account getAccount(int id){
		for (Account account : accounts) {
			if (account.getId() == id) 
				return account;
		}
		return null;
	}

	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}

}
