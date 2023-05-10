package idh.java;

import java.util.Iterator;

public class AccountIterator2 implements Iterator<Account> {
	
//nur für Aufgabe 2 gedacht		
	
	Bank bank;
	
	int currentPosition = -1;
	
	public AccountIterator2(Bank bank) {
		this.bank = bank;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < bank.size();
	}

	@Override
	public Account next() {
		currentPosition++;
		return bank.getCustomerAccount(currentPosition);
	}
	


}
