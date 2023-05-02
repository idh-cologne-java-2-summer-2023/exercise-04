package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	ATM atm;
	int currentAccount= -1;// sowie i-te position bei nem array
	
	public AccountIterator (ATM atm2) {
		this.atm = atm2;
	}

	@Override
	public boolean hasNext() {
		return currentAccount < atm.size()-1;
	}

	@Override
	public Account next() {
		
		currentAccount++;
		return atm.getAccount(currentAccount);
	}

}
	/**Iterator weiß jetzt wo bin ich gerade im ATM
	 * Was ist das nächste Objekt was ich zurück geben muss
	 * und gibt es noch nächste Objekte
	 * 
	 * */



