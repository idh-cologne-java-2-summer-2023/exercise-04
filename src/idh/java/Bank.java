package idh.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	//Aufgabe 2.1
	private ArrayList<Account> accounts;
	
	public Bank () {
		accounts = new ArrayList<Account>();	
	}
	// Konto wird zur Liste hinzugefügt
	void addAccounts (Account anAccount) {
		accounts.add(anAccount);
	}
	
	//die Liste der Konten wird zurückgegeben
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator();
			
	}

}
