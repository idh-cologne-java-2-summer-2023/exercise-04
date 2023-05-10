package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	Account[] customerAccounts;
	
	public int size() {
		return customerAccounts.length;
	}
	
	public Account getCustomerAccount(int customerAccount) {
		return customerAccounts[customerAccount];
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator2(this);
	}
	
	
}
