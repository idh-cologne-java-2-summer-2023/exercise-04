package idh.java;

public class Bank {

 int numberofaccounts;
 
 
 public Bank(int numberofaccounts) {
	 // accounts known by ATM
	 Account[] accounts = new Account[numberofaccounts];
	 // create accounts with balances that can varify
	 Random random = new Random();
	 for (int i = 0; i < accounts.length; i++) {
		 accounts[i] = new Account(i, random.nextInt(1000));
			 
 }
	 
 }
 
 @Override
 public Iterator<Account> iterator() {
	 return new Accountiterator();
 }
}