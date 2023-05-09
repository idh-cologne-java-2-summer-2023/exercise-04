package idh.java;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Bank implements Iterable<Account> {

	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Bank() {
	}

	public void generateAccount(int quantity) {
		Random random = new Random();
		for (int i = 0; i < quantity; i++) {
			accounts.add(new Account(i, random.nextInt(1000)));
		}
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Account getAccountID(int id) {
		for (Account account : accounts) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Iterator<Account> iterator() {
		return accounts.iterator();
	}

}