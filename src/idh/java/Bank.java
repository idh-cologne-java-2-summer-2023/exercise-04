package idh.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public Iterator<Account> iterator() {
        return accounts.iterator();
    }
}