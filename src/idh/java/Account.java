package idh.java;

/**
 * This class represents an account in our bank.
 *
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
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}

	/**
	 * Withdraws a sum of money from the account
	 *
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = this.balance - sum;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
