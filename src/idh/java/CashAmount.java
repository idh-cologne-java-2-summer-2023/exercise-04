package idh.java;

public class CashAmount {
	private static int availableMoney;
	
	public CashAmount (int newavailableMoney) {
		availableMoney = newavailableMoney;
	}
	
	public static void reduceMoney (int reduceAmount) {
		availableMoney -=reduceAmount;
	}

	public static int getAvailableMoney() {
		return availableMoney;
	}

	public static void setAvailableMoney(int availableMoney) {
		CashAmount.availableMoney = availableMoney;
	}
	
}
