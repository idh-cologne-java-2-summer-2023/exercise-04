package idh.java;
import java.util.Iterator;
public class AccountIterator implements Iterator<Account> {

  Account[] accounts;
    int currentPosition = 0;

    public AccountIterator(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < accounts.length ;
    }

    @Override
    public Account next() {
        currentPosition++;
        return accounts[currentPosition];
    }
}
