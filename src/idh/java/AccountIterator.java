package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Account account;
	
	int currentPosition = -1;
	
	public AccountIterator(Account account) {
		this.account = account;
		
	}

	@Override
	public boolean hasNext() {        //gibt Info ob es noch einen weiteren Account gibt
		// TODO Auto-generated method stub
		return false ;
	}

	@Override
	public Account next() { //gibt nächsten Account aus
		// TODO Auto-generated method stub
		return null;
	}

}
