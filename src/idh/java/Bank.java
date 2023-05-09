package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements Iterable<Account> {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Iterator<Account> iterator() {
        return accounts.iterator();
    }
}
