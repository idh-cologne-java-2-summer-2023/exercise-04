package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank  implements Iterator<Account> {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

	@Override
	public boolean hasNext() {
		
		return false;
	}

	@Override
	public Account next() {
		
		return null;
	}

}