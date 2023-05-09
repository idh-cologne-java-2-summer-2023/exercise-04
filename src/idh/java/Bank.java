package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return new AccountIterator(this);
		
	}
 
	for(Account account : bank) {
		
	}
}
