package idh.java;
import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	Account[] accounts;
    
    public Bank(int anzahlAccounts) {
    	accounts = new Account[anzahlAccounts];
    	Random random = new Random();
		for (int i = 0; i < anzahlAccounts; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
    	
 
    }
    
    public Account getAccount(int accountId) {
        for (Account account : accounts) {
            if (account.getId() == accountId) {
                return account;
            }
        }
        return null;
    }

	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
    

}

