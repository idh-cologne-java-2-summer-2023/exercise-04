package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AccountIterator implements Iterator<Account> {
	
	private List<Account> bank;
	
	public void Bankf() {
		this.bank = new ArrayList<>();
		
	}
	
	public void addAccount(Account account) {
		bank.add(account);
		
	}
	
	public void removeAccount(Account account) {
		account.remove(account);
		
	}
	
	public List<Account> getAccounts() {
		return bank;
	}
	
	public Iterator<Account> iterator() {
		return bank.iterator();
	}
	
	private int currentIndex = 0;
	
	public boolean hasNext() {
		return currentIndex < bank.size();
		
	}
	
	public Account next() {
		return bank.get(currentIndex++);
	}

};
