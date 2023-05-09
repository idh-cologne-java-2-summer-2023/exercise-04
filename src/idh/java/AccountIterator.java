package b;

import java.util.Iterator;
import java.util.List;

public class AccountIterator implements Iterator<ATM.Bankaccount> {

    private List<ATM.Bankaccount> accounts; //speichert die Liste von Konten
    private int currentIndex;

    public AccountIterator(List<ATM.Bankaccount> accounts) {
        this.accounts = accounts;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < accounts.size(); //true, wenn currentIndex > alle accounts die es gibt
    }

    @Override
    public ATM.Bankaccount next() { //wenn kein NEXT, dann throw Exception,sonst return account und dann ++ auf Index
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        System.out.println(currentIndex);
        return accounts.get(currentIndex++);
    }

    public void iterateAccounts() {
        while (hasNext()) {
            ATM.Bankaccount account = next();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Bankaccount you are logged in with:");
            System.out.println("Account ID: " + account.account.getId());
            System.out.println("Balance: " + account.getBalance() + "€");
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("ALL EXISTING BANKACCOUNTS");
        for (ATM.Bankaccount account : accounts) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Account ID: " + account.account.getId());
            System.out.println("Balance: " + account.getBalance() + "€");
            System.out.println("--------------------------------------------------------------");

        }
    }
}