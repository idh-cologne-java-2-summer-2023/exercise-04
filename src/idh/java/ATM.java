package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    int atmBalance = 1000; // ATM balance

    Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashOut(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");                            //Input for account number and withdraw amount.
                   int tempAccountNumber = Integer.parseInt(br.readLine());

                   for (Account acc : bank){                                                //checks for input account number in bank array
                       if (acc.getAccNumber() == tempAccountNumber){
                           System.out.print("Your balance: " + acc.getAccBalance()+ '\n');  //if input account number is valid, shows account balance
                           System.out.print("Enter the amount to withdraw: ");
                           int amount = Integer.parseInt(br.readLine());                    //saves the input withdraw in amount
                           cashOut(amount, acc);
                       }
                   }
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashOut(int amount, Account acc) {                                          //gets the amount and the input account
        if (amount <= 0){                                                                   //checks if input amount is bigger or equal to zero
            System.out.println("error, invalid input!");
        }
        else if (atmBalance >= amount && amount <= acc.accBalance) {                        //checks if enough cash is in atm and in account
            acc.accBalance -= amount;                                                       //subtracts the cash from Account
            atmBalance -= amount;                                                           //..
            System.out.println("Ok, here is your money, enjoy!");
        } else if (amount > acc.accBalance){                                                //checks for cash in account
            System.out.println("Sorry, not enough money in the bank.");
        } else {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");      //shows if no cash in atm
        }

    }
    /**
     * Launches the ATM
     */
    public static void main(String[] args) throws Exception {
        Bank bog = new Bank("Bank of Germany", 6);

        bog.addMember(1234, 1000);
        bog.addMember(2345, 2000);
        bog.addMember(3456, 77000);
        bog.addMember(4567, 9999999);
        bog.addMember(5678, 100018711);
        bog.addMember(6789, 10002);

        ATM atm = new ATM(bog);

        atm.run();

    }



    }





