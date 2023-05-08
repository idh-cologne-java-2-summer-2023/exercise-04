package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	//Aufgabe 1 -->while-Schliefe in ATM Klasse
	
	ATM atm;
	public int pointer = 0;
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return pointer < atm.size();
	}

	@Override
	public Account next() {
		// TODO Auto-generated method stub
		Account account = atm.getAccount(pointer);
		pointer ++;
		return account; 
		
		}
	
	}

