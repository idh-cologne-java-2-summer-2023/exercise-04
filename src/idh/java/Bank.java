package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	static Account[] accounts;
	String name;
	

	public Bank(String name, int amountOfAccounts) {
		this.name = name;
		// create accounts with varying balances
	//	if(wenn it.hasnext true dann ansonsten exception?)
		accounts = new Account[amountOfAccounts];
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}

	}

	public int getBankSize() {
		return accounts.length;
	}

	public static Account getAccount(int id) {
		for (Account account : accounts) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
