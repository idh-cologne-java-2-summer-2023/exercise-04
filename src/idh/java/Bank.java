package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

	// Anzahl an Konten, die in Bank gespeichert werden können
	static Account[] accounts = new Account[20];

	public Bank() {

		// Code für zufällige Accounts aus ATM übernommen
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}

	}

	@Override
	public Iterator<Account> iterator() {

		return new AccountIterator(accounts);
	}

	public static Account[] getAccount() {

		return accounts;
	}

}
