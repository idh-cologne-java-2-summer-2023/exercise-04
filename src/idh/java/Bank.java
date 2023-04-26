package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank
{


	Account[] accounts = new Account[5];

	public Bank() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);
	}

}