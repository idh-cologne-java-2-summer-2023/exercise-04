package idh.java;
import java.util.Iterator;
import java.util.Random;

	public class Bank implements Iterable<Account>  {
		
		static Account[] tempaccounts = new Account[5];
		
		public Bank() {
			// create accounts with varying balances
			Random random = new Random();
			for (int i = 0; i < tempaccounts.length; i++) {
				tempaccounts[i] = new Account(i, random.nextInt(1000));
			}
		}
		@Override
		public Iterator<Account> iterator() {
			// TODO Auto-generated method stub
			return new Accitr(tempaccounts);
		}

	}

