package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;


public class ATM {
	
	// initial cash in the ATM
	int cash = 100;

	// accounts known to the ATM
	static Account[] accounts = new Account[5];
	//original
	//Account[] accounts = new Account[5];

	
	//Constructor für ATM
	public ATM() {
		// create accounts with varying balances
		// ToDo: Irgendwie den Banknamen einbauen
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
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
		cash += amount;
		System.out.println("Ok, here is your money, enjoy!");

	};
	
	//Innere Klasse AccountIterator!
		public class AccountIterator implements Iterator<Account> {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Account next() {
				// TODO Auto-generated method stub
				return null;
			}
		
		}
		
		
			

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
		
	
		//Arraylist erstellen
				ArrayList<Account> AccountListe = new ArrayList<>(accounts.length);
				
				//accounts-Array in ArrayList übertragen für Iterator
				for(int i = 0; i < accounts.length; i++) { 
				AccountListe.add(accounts[i]);
				
				}
				//Iterator schaffen
				Iterator<Account> AccountIterator = AccountListe.iterator();
				//zugriff per While-Schleife auf accounts
				while(AccountIterator.hasNext()) {
					Account AccountID = AccountIterator.next();
				}
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
