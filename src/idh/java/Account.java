package idh.java;

/**
 * Diese Klasse repräsentiert ein Konto in unserer Bank.
 * Autor: reiterns
 *
 */
public class Account {
	// der Kontostand
	int balance;

	// die ID des Kontos
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

	public void setBalance(int status) {
		this.balance = status;
	}

	/**
	 * Hebt eine Summe Geld vom Konto ab.
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}


}
