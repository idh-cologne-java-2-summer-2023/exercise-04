package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


		public class Bank implements Iterable<Account> {
		    private List<Account> accounts;

		    public Bank() {
		        this.accounts = new ArrayList<>();
		    }

		    public void addAccount(Account account) {
		    	accounts.add(account);
		    }

		    public void removeAccount(Account account) {
		    	accounts.remove(account);
		    }

		    public List<Account> getAccount() {
		        return accounts;
		    }

			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			public Account next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterator<Account> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
	

		

	}

