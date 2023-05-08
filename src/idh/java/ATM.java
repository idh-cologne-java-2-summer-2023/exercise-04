package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int cash = 100;
	
	Bank jp = new Bank();

	public ATM(Bank banktype) {
		this.jp = banktype;
	}
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine()) - 1;
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	// it is no longer possible to check if the account exists. I don't know how to solve this.
	public void cashout(int accountNumber, int amount) {
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}	
		Account Calaccount = getAccount(accountNumber);
		
		// check for balance of the account
		if (amount > Calaccount.balance) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		// withdraw
		Calaccount.withdraw(amount);
		cash += amount;
		System.out.println("Ok, here is your money, enjoy! \nbalance remaining " + Calaccount.balance);

	};
	/**
	 * creates new Bank Obj jp and launches Atm with jp
	 */
	public static void main(String[] args) {
		Bank jp = new Bank();
		ATM atm = new ATM(jp);
		atm.run();
	};	
	
	/**
	 * get Account info from bank 
	 * 
	 */
	protected Account getAccount(int id) {
		for (Account account : jp) {
			if (account.getId() == id) 
				return account;
		}
		return null;
		
	}
	


	

}
