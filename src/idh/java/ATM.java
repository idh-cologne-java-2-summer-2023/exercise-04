package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;
	
	// bank linked to ATM
	Bank diba = new Bank(this);
	
	public ATM() {
		
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < diba.accounts.length; i++) {
			diba.accounts[i] = new Account(i, random.nextInt(1000));
		}
		AccountIterator iterator = new AccountIterator(diba);
		while(iterator.hasNext()) {
			System.out.println(iterator.next().balance);
		}
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
				cashout(accountNumber, amount, diba);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount, Bank bank) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = getAccount(accountNumber, bank);
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
		cash -= amount;
		System.out.println("Ok, here is your money, enjoy!");
		System.out.println("Money left in account: " + account.getBalance());

	};
	
	class AccountIterator implements Iterator<Account>{
		
		Bank bank;
		int currentPosition = -1;
		
		public AccountIterator(Bank bank) {
			this.bank = bank;
		}
		
		@Override
		public boolean hasNext() {
			return currentPosition < bank.accounts.length-1;
		}

		@Override
		public Account next() {
			currentPosition++;
			return bank.accounts[currentPosition];
		}
		
	}

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
	protected Account getAccount(int id, Bank bank) {
		for (Account account : bank) {
			if (account.getId() == id) 
				return account;
		}
		return null;
	}

}
