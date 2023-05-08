package idh.java;

public abstract class Accountlterator implements Iterable<Account> {
	
	Account account;
	int aktuell = 0;

	public Accountlterator(Account account) {
		this.account = account;

	}
	
	public int hasNext(){
		return aktuell;
	}
	
	public Account next() {
		aktuell++;
		return account.setBalance(aktuell);
	}

}
