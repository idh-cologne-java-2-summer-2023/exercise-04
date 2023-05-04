package idh.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	class AccountIterator implements Iterator<Account> {
		
		private int position = -1;
		private Bank institute;
		
		public AccountIterator(Bank reference) {
			institute = reference;
		}
		
		@Override
		public boolean hasNext() {
			return position < institute.getAccounts().size() - 1;
		}

		@Override
		public Account next() {
			position++;
			return getAccounts().get(position);
		}
	}

	private ArrayList<Account> accounts = new ArrayList<>();
	private String institute;
	
	public Bank(String institute) {
		this.institute = institute;
	}

	public boolean validID(String id) {
		if (id.matches("[0-9]{4}")) {
			return true;
		}
		return false;
	}

	public Account matchingID(String id) {
//		AccountIterator accIt = new AccountIterator(this);
//		while (accIt.hasNext()) {
//			Account a = accIt.next();
//			if (a.getId().equals(id)) {
//				return a;
//			}
//		}
		for (Account a : this) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this);
	}

	// getters and setters
	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Account a) {
		accounts.add(a);
	}
}
