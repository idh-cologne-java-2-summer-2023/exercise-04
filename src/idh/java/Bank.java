package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {

	Account account ;
	
	public Bank (Account account) {
		this.account = account;
		
	}
	
	
	@Override
	public Iterator<Account> iterator() {
		
		return new AccountIterator (this);
	}

//komme ab dem Punkt nicht weiter
	



	//

	

}
