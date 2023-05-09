package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Bank implements Iterable<Account>{
	private List<Account> bank;
	
	public Bank() {
		this.bank = new ArrayList<>();
		
	}
	
	public void addAccount(Account account) {
		bank.add(account);
		
	}
	
	public void removeAccount(Account account) {
		bank.remove(account);
		
	}
	
	public List<Account> getAccount() {
		return bank;
	}
	
	public boolean hasNext() {
		return false;
		
	}
	
	public Account next() {
		return null;
	}
	
	public Iterator<Account> iterator() {
		return null;
}

};
