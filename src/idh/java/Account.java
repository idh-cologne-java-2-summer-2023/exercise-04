package idh.java;

import java.util.Random;

public class Account {

	private String id;
	private int balance = 500;
	private Bank institute;

	public Account(Bank reference) {
		institute = reference;
		setId("");
	}

	public Account(String id, Bank reference) {
		institute = reference;
		setId(id);
	}
	
	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id.equals("")) {
			Random rnd = new Random();
			while (id.length() < 5) {
				int digit = rnd.nextInt(0, 10);
				id += Integer.toString(digit);
			}
		} else if (institute.validID(id)) {
			this.id = id;
		} else {
			System.out.println("ID was automatically generated because of invalid ID input..");
			setId("");
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Bank getInstitute() {
		return institute;
	}

	public void setInstitute(Bank institute) {
		this.institute = institute;
	}

}
