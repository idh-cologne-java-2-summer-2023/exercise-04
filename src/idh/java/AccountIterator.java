package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	Account account;
	int currentPossition = 0;
	public AccountIterator(Account account) {
		this.account = account;
	}
	public void printAllAccounts() {
        while (hasNext()) {
            Account account = next();
            System.out.println(account.getId() + ": " + account.getBalance());
            }}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account next() {
		// TODO Auto-generated method stub
		return null;
	}

}
