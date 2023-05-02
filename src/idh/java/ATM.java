package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	static ATM atm;
	static Bank bank;

	// initial cash in the ATM
	int cash = 100;

	public ATM() {

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
				System.out.println(bank.getName());
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
		
		AccountIterator iter = new AccountIterator(bank);
		int currentPosition = -1;
		for(Account account : bank) {
			if(account.getId() == accountNumber) {
				while (iter.hasNext()) {
					if (iter.next().getId() == accountNumber) {
						if (bank.getAccount(iter.currentPosition).getBalance() < amount) {
							System.out.println("Sorry, you're out of money.");
							return;
						}
						currentPosition = iter.currentPosition;
						break;
					}
				}

				// withdraw
				bank.getAccount(currentPosition).withdraw(amount);
				cash += amount;
				System.out.println("Ok, here is your money, enjoy!");
			}
		}
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		atm = new ATM();
		bank = new Bank("Sparkasse");
		
		atm.run();
		
		
	};

}