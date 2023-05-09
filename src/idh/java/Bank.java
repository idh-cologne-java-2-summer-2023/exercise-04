package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {

    private Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator(accounts);
    }

    public Account getAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
