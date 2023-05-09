package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;
	Bank bank;
	
	//Testbank Kreissparkasse Köln
	static  Bank ksk = new Bank("Kreissparkasse Koeln");		
	
	
	/*	Zu Aufgabenteil 1
	 * // accounts known to the ATM
	public Account[] accounts = new Account[5];*/
	
	public ATM(Bank bank) {
		this.bank = bank;
		/*
		 * Zu Aufgabenteil 1
		 * // create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}*/
		
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
		System.out.println(this.bank.getName());
		System.out.println("Ok, here is your money, enjoy!");
		System.out.println("Verbleibendes Guthaben: " + account.balance);
		System.out.println("Cash im Automaten: " + cash + "\n");

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		//ATM als Sparkassenautomaten initialisieren
		ATM atm = new ATM(ksk);
		atm.run();
	};
	
	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	
	/*	
	 * 
	 * Lösung zu Aufgabe 1 (While Schleife mit Iterator)
	 * 
	 * protected Account getAccount(int id) {
		AccountIterator iter = new AccountIterator(accounts);	
		while (iter.hasNext()) {
				if (iter.next().getId() == id) 
				return iter.next();
		}
		return null;
	}
	*/
	
	protected Account getAccount(int id, Bank bank) {
		
		for(Account konten : bank) {
			if(konten.getId() == id) {
			System.out.println("\nID ist: " + konten.getId() + " Guthaben ist: " + konten.getBalance()); 
			return konten;
			}
		}
		return null;
	}

}
