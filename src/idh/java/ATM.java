package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	String name = "Sparkasse";
	public void run(int currentAccountNumber) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: \nPress x to cancel.\n");
				int amount = Integer.parseInt(br.readLine());
				if( CashAmount.getAvailableMoney()>=amount) {
					cashout(amount, currentAccountNumber);
				} else {
					System.out.println("The ATM doesn't have enough cash. Remaining cash amount: "+ CashAmount.getAvailableMoney());
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int currentAccountNumber) {
		if (amount < Bank.getAccountBalance(currentAccountNumber)) {
			Bank.withdraw(currentAccountNumber, amount);
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("Your new balance is " + Bank.getAccountBalance(currentAccountNumber)+"\n");
			CashAmount.reduceMoney(amount);
		} else {
			System.err.println("Insufficient balance");
		}

	};

	public static void main(String[] args) {
		int currentAccountNumber = 0;
		ATM atm = new ATM();
		Bank database = new Bank();
		CashAmount cashamount = new CashAmount(300);
		Scanner input = new Scanner(System.in);
		
		loop : while(true) {
		
		System.out.println("Do you want to login or create a new account?");
		String command = input.nextLine();
		
		switch(command.toLowerCase()){
		case "login": {
			System.out.println("Enter your Account number please");
			int accountNumber = input.nextInt();
			System.out.println("Enter your Pin: ");	
			int pin = input.nextInt();
			
			if(Bank.authenticateUser(accountNumber, pin)) {
				currentAccountNumber = accountNumber;
				atm.run(currentAccountNumber);
			}
			else {
				System.err.println("Invalid credentials");
			}	
			break;
		}
		case "new": {
			System.out.println("Alright, enter your name please");
			//Muss noch gemacht werden
			break;
		}
		case "showcash": {
			System.out.printf("Available Money %s\n", CashAmount.getAvailableMoney());
			break;
		}
		case "exit": {
			System.out.println("Have a nice day!");
			break loop;
		}
		}
	}
};
}
