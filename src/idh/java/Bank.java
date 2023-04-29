package idh.java;
import java.util.Iterator;
import java.lang.Iterable;

public class Bank implements Iterable<Account> {

	static Account[] accounts = new Account[100];
	
	public static void main(String[] args) {
		
	}
	
	public Bank() {
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, (int)(Math.random()*5000) + 1);
		}
		iterator();
	}
	
	public Iterator<Account> iterator(){
		return new AccountIterator(accounts);
	}
	
	public static Account[] getAccount() {

		return accounts;
	}
	
}
