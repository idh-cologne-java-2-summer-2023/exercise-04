package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{

	Bank account;
	int curPosition = -1; //loop counter
	
	public AccountIterator(Bank bank) {
		this.account = bank;
	}
	
	public boolean hasNext() {
		return curPosition < Bank.acclistLength() - 1;
	}

	
	public Account next() {
		curPosition++;
		return Bank.getAccount(curPosition);
	}
	

}
