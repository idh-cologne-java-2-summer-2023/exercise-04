package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Account [] konten;
	int currentPosition = -1;	//Laufvariable
	
	public AccountIterator(Account[] accounts) {
		this.konten = accounts;
	}
	
	
	@Override
	public boolean hasNext() {
		
		return currentPosition < konten.length -1;
	}

	@Override
	public Account next() {
		currentPosition++;
		return konten[currentPosition];
	}

}
