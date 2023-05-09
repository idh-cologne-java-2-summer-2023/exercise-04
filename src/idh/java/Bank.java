package idh.java;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank(int numAccounts) {
        for (int i = 0; i < numAccounts; i++) {
            accounts.add(new Account(i, 0));
        }
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getId() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}