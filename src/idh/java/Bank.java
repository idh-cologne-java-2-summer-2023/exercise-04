package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
	//Bank Name
	String name;
	//number of Accounts
	 int accQuant;
	
	static Account[] accounts;

	
	public Bank(String name, int accQuant) {
		this.name = name;
		this.accQuant = accQuant;
		createAccs();
	}
	
	public static int acclistLength() {
		return accounts.length;
	}

	public static Account getAccount(int accNumb ) {
		return accounts[accNumb];
	}
	
	public void createAccs() {
		
		// create accounts with varying balances
				Random random = new Random();
				for (int i = 0; i < accounts.length; i++) {
					accounts[i] = new Account(i, random.nextInt(1000));
				}
	}

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
	}
	
}
