package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	static Account[] accounts = new Account[5];
	public static String name = "Sparkasse";
	
	public Bank() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);
	}
	
	public static Account[] getAccounts() {
		return accounts;
	}
}
