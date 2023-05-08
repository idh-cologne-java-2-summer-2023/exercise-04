package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	
	Account[] konten = new Account[5];
	String bankName;
	
	public Bank(String name) {
		bankName = name;
		
		Random random = new Random();
		for (int i = 0; i < konten.length; i++) {
			konten[i] = new Account(i, random.nextInt(1000));
		}
	}
	
	public String getName() {
		return this.bankName;
	}

	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(konten);
	}

}
