package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	//Ich wusste nichts mit dieser Schleife anzufangen: for (Account account : bank) { ... },
	//weil ja eigentlich die Bank die Accounts verwalten soll. 
	//Daher habe ich es nicht geschafft, diese Schleife einzubauen ohne einen Syntaxfehler 
	//oder eine Exception hervorzurufen. Aufgabe c) 2. ist also unvollständig, I tried :(
	
	// initial cash in the ATM
	int cash = 100;

	Bank bank;

	public ATM(Bank bank) {
		this.bank = bank;
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
		Account account = bank.getAccount(accountNumber);
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
	public static void main(String[] args) throws Exception{
		ATM atm = new ATM(new Bank());
		atm.run();

        AccountIterator iter = new AccountIterator(new Bank());
        while(iter.hasNext()) {
            System.out.println(iter.next().getId());
        }
	};

}
