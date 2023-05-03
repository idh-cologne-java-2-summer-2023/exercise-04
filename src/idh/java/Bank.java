package idh.java;

import java.util.Arrays;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
    Account[] members;

    int nextPosition = 0;
    String name;

    public Bank(String name, int numberOfAccounts) { //Constructor: New bank gets a name and size
        this.members = new Account[numberOfAccounts];
        this.name = name;
    }

    public void addMember(int accNumber, int accBalance) throws Exception { //adds Accounts
        if (nextPosition < members.length) {
            members[nextPosition++] = new Account(accNumber, accBalance);
        } else
            throw new Exception("Bank full");
    }

    public int bankSize() { // gives the number of accounts
        return members.length;
    }

    public Account getBankMember(int memberId) { //gives one member
        for (Account account : members) {
            if (account.getAccNumber() == memberId) {
                return account;
            }
        }
        return null;
    }

    public String getBankName() {
        return name;
    }

    public void setBankName(String name) {
        this.name = name;
    }

    @Override
    public Iterator<Account> iterator() {
        return Arrays.stream(members).iterator();
    }
}
