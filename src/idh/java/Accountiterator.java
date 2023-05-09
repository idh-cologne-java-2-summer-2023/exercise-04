package idh.java;

public class Accountiterator {
	
	Bank bank;
	int id;
	
	
	public boolean hasNext() {
		id++;
		return id < bank.numberofaccounts;
	}
	
	@Override
	public Account next() {
		for (Account account : bank) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}

}
