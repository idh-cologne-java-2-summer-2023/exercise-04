package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.lang.Iterable;

public class ATM {

	// Aufgabe 2.1
	// Ich habe versucht die Class Bank.java mit dieser ATM class zu verbinden
	// Anschließend soll die Funktion auf
	private Bank bank;

	//ATM soll mit bank verbunden werden
	public ATM(Bank bank) {
		this.bank = bank;
	}

	//ATM soll über Accounts und bank die Konten und den Kontostand überprüfen 
	public void MoneyWithdraw(Account account, int betrag) {
		// Hier kann man über auf die Konten zugreifen
		List<Account> accounts = bank.getAccount();
		if (accounts.contains(account)) {
			account.withdraw(betrag);
		}

		//Aufgabe 2.2 
		//Ich habe versucht Bank mit Accounts zu Iterieren und Account iterator mit Account zu verbinden
		//Leider kriege ich keine korrekte Ausgabe und konnte nicht herausfinden, woran 
		//Der Fehler lag
	
		for (Account acc : bank) {
			if (acc.equals(account)) {
				acc.withdraw(betrag);
				return;
			}

		}
	}

	// initial cash in the ATM
	int cash = 100;

	// accounts known to the ATM
	Account[] accounts = new Account[5];

	public ATM() {
		// create accounts with varying balances
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

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();

		//Die While Schleife aus Aufgabe 1
		AccountIterator iter = new AccountIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getId());
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
