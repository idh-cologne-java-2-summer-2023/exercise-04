package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	Account[] accounts = new Account[5];
	private ATM atm;
	public Bank() {
		
	}
	
	public void setAtm (ATM atm){
		this.atm = atm;
	}
	

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return atm.new AccountIterator(this);
	}

}
