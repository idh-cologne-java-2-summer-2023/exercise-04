package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank("123Geld");
		
		Account a1 = new Account("1234", bank);
		Account a2 = new Account("4321", bank);
		Account a3 = new Account("1111", bank);
		bank.setAccounts(a1);
		bank.setAccounts(a2);
		bank.setAccounts(a3);
		a1.setBalance(1500);
		a2.setBalance(10000);

		ATM atm = new ATM(bank);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		atm.run(br);
	}
}
