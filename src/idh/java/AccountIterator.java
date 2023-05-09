
package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AccountIterator implements Iterator<Account> {
    private ArrayList<Account> accounts;
    private int position;

    public AccountIterator(Account[] accounts) {
        this.accounts = new ArrayList<Account>();
        for (Account account : accounts) {
            this.accounts.add(account);
        }
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < accounts.size();
    }

    @Override
    public Account next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Account account = accounts.get(position);
        position++;
        return account;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}