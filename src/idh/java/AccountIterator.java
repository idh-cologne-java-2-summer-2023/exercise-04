package idh.java;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class AccountIterator implements Iterator<Account> {

	//Aufgabe 2.2
	    private List<Account> accounts;

	    public void Bank() {
	        this.accounts = new ArrayList<>();
	    }

	    public void addAccount(Account account) {
	        accounts.add(account);
	    }

	    public void removeAccount(Account account) {
	        accounts.remove(account);
	    }

	    public List<Account> getAccounts() {
	        return accounts;
	    }

	    public Iterator<Account> iterator() {
	        return accounts.iterator();
	    }



	        private int currentIndex = 0;

	        @Override
	        public boolean hasNext() {
	            return currentIndex < accounts.size();
	        }

	        @Override
	        public Account next() {
	            return accounts.get(currentIndex++);
	        }
	    }


