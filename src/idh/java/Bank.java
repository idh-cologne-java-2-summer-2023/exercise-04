package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {

	@Override
	public Iterator<Account> iterator() {
	for (Account account : Bank) {
		System.out.println(account.getAccount());
	}
				return null;
			}

	
	}

