package idh.java;
import java.util.ArrayList;
import java.util.Iterator;

public class Bank{
	
	Bank[] accounts;
	
	public String bankName;
	public int accountId;

	
public Bank (String bankName, int accountId){
	this.bankName = bankName;
	this.accountId = accountId;
	
}

//Bank Account Iterator as inner class
public class BankIterator implements Iterator<Account> {
	
	Account accounts;
	int pointer = 0;
	
	public BankIterator (Account accounts) {
		this.accounts = accounts;
	}
	
	
	
	@Override
	public boolean hasNext() {
		return pointer < 7;
	}
	
	
	@Override
	public Account next() {
		pointer++;
		return null;
	}
	
	
	
}
}
