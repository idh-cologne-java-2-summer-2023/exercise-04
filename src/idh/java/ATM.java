package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM extends Bank {
	
	// initial cash in the ATM
	int cash = 100;

	// accounts known to the ATM
	Account[] accounts = knownacc();
	Account account = getAccount(id);

	public ATM() {
	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Please enter your account number: ");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Your current balance is " + account.getBalance() + "€");
				System.out.print("Please enter the amount you would like to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(id, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int id, int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(id);
		if (account == null) {
			System.out.println("Sorry, this account doesn't exist.");
			return;
		}
		
		// check for balance of the account
		if (amount > account.getBalance()) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		
		// withdraw
		account.withdraw(amount);
		cash += amount;
		int newbalance;
		newbalance = account.getBalance() -amount;
		account.setBalance(newbalance);
		System.out.println("Ok, here is your money, enjoy!");
			

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	
	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		for (Account account : accounts) {
			if (account.getId() == id) 
				return account;
		}
		return null;
	}

}
