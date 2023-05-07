package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {
	
	//Bank of the ATM
	String Bank;
	
	// initial cash in the ATM
	int cash = 100;

	

	public ATM(String bank) {
		this.Bank = bank;
		
		
		
	}
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {								
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(accountNumber);
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
		cash -= amount; //war += (Fehler?)
		System.out.println("Ok, here is your money, enjoy!");

	};

	

	private Account getAccount(int accountNumber) {
		for (Account account : bank) {
			if (account.getId() == accountNumber) 
			return account;
		return null;
		}
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM(null);
		atm.run();
		
		
	};
	
	

}
