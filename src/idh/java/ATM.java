package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    // initial cash in the ATM
    int cash = 100;

    // the bank that this ATM belongs to
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
        Iterator<Account> accountIterator = bank.iterator();
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                Account account = findAccount(accountIterator, accountNumber);
                if (account == null) {
                    System.out.println("Sorry, this account doesn't exist.");
                    continue;
                }
                cashout(account, amount);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void cashout(Account account, int amount) {
        // check for cash in the ATM
        if (amount > cash) {
            System.out.println("Sorry, not enough cash left.");
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
    }

    private Account findAccount(Iterator<Account> accountIterator, int accountNumber) {
        while (accountIterator.hasNext()) {
            Account account = accountIterator.next();
            if (account.getId() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        Bank bank = new Bank();
        // add some accounts to the bank
        bank.addAccount(new Account(1, 500));
        bank.addAccount(new Account(2, 1000));
        bank.addAccount(new Account(3, 750));
        ATM atm = new ATM(bank);
        atm.run();
    }
}
