package idh.java;

import java.util.Iterator;
import java.util.Random;


public class Bank implements Iterable<Account>{

	int numberOfAccounts = 5;
	
	Account[] accounts = new Account[numberOfAccounts];
	
	public Bank() { // -> vorher: ATM() aus ATM klasse
		
		// create accounts with varying balances
				Random random = new Random();
				for (int i = 0; i < accounts.length; i++) {
					accounts[i] = new Account(i, random.nextInt(1000));
				}
	}

	@Override
	public Iterator<Account> iterator() {
		
		return new AccountIterator(accounts);
	}
	
}
