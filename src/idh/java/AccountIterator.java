package idh.java;

import java.util.Iterator;


public class AccountIterator implements Iterator<Account> {
    private Account[] accounts;
    private int currentPosition;

    public AccountIterator(Account[] accounts) {
        this.accounts = accounts;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < accounts.length;
    }

    @Override
    public Account next() {
        return accounts[currentPosition++];
    }
}

