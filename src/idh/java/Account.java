package idh.java;

/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
	// the balance of the account
	int balance;
	
	// the id of the account
	int id;

	public Account(int id, int status) {
		this.id = id;
		this.balance = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public Account setBalance(int status) {
		this.balance = status;
		return null;
	}
	
	/**
	 * Withdraws a sum of money from the account
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}
	
	Accountlterator iter = new Accountlterator(null);
	while(iter.hasNext) {
		System.out.println(iter.next().getAccount());
	}
	char[] getAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
