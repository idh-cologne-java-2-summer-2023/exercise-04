package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
	Account[] accounts;
	static ATM atm;
	
	public Bank() {
		accounts = new Account[5];
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public Account[] getAccount() {
		return accounts;
	}
	
	public ATM getATM() {
		return atm;
	}

	public Iterator<Account> iterator() {
		return new AccountIterator(this, atm);
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		atm = new ATM(bank);
		atm.run();
		
	}
	
	
	
}
