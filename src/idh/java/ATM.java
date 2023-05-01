package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    // initial cash in the ATM
    int cash = 1000;

    // reference to the bank containing the accounts
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
                System.out.print("Enter your account number (4 digits): ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                // iterate through the accounts in the bank to find the account with the given accountNumber
                Account account = null;
                for (Account a : bank) {
                    if (a.getId() == accountNumber) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Sorry, this account doesn't exist.");
                    continue;
                }

                if (amount > account.getBalance()) {
                    System.out.println("Sorry, you do not have enough money.");
                    continue;
                }

                if (amount > cash) {
                    System.out.println("Sorry, not enough cash left.");
                    continue;
                }

                account.withdraw(amount);
                cash += amount;
                System.out.println("Ok, here is your money, enjoy!");

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }



    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account(1234, 100));
        bank.addAccount(new Account(9876, 300));
        bank.addAccount(new Account(0504, 420));
        bank.addAccount(new Account(1308, 210));
        bank.addAccount(new Account(0007, 400));

        ATM atm = new ATM(bank);
        atm.run();
    }
}