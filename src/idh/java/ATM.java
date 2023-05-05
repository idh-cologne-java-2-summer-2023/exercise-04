package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ATM {
	
	// initial cash in the ATM
	int cash = 100;

	// accounts known to the ATM
	Account[] accounts = new Account[5]; //Id to enter: 0 - 4

	public ATM(String bankName) {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
			
	}
	
	
	public int size() {
		return accounts.length;
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
	
	
//the iterator as inner class of ATM	
	public class AccountIterator implements Iterator<Account> {
		
		ATM accounts;
		int numberAccounts= 0; //counter variable
		
		public AccountIterator (ATM accounts) {
			this.accounts = accounts;
		}
		
		
		@Override
		public boolean hasNext() {
			return numberAccounts < accounts.size();
		}

		@Override
		public Account next() {
			numberAccounts++;
			return accounts.getAccount(numberAccounts);
		}		
		
	}
	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		ATM atm1 = new ATM("Sparkasse");
		atm1.run();
		
		ATM atm2 = new ATM("Deutsche Bank");
		
		ATM atm3 = new ATM("Postbank");

		
//initialize iterator with innerclass AccountIterator
		
		ATM.AccountIterator iter = atm1.new AccountIterator(atm1);
		while(iter.hasNext()) {
			System.out.println(iter.next().getId());
//doesn't print anything...I'm missing something
		}
		
		
		ArrayList<Bank> account = new ArrayList<Bank>();
		
		Bank accOne = new Bank("Postbank", 4568);
		Bank accTwo = new Bank("Postbank", 0127);
		Bank accThree = new Bank("Sparkasse", 5635);
		Bank accFour = new Bank("Sparkasse", 5635);
		Bank accFive = new Bank("Sparkasse", 7081);
		Bank accSix = new Bank ("Deutsche Bank", 9559);
		Bank accSeven = new Bank ("Deutsche Bank", 1919);
		
		account.add(accOne);
		account.add(accTwo);
		account.add(accThree);
		account.add(accFour);
		account.add(accFive);
		account.add(accSix);
		account.add(accSeven);
		
		
		for (Iterator<Bank> iter2 = account.iterator(); iter2.hasNext();) {
			Bank accounts = iter2.next();
			System.out.println(accounts);
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
