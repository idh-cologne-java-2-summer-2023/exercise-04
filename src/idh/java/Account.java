package idh.java;

public class Account {

    public int accBalance;
    public int accNumber;


    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public Account(int accNumber, int accBalance ) {
        super();
        this.accNumber = accNumber;
        this.accBalance = accBalance;
    }



}
