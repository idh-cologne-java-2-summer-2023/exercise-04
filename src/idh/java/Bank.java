package idh.java;

public class Bank {

	
	/*
	 * 1.Fügen Sie eine neue Klasse Bank hinzu, die eine Anzahl an Konten speichern kann. Ein Geldautomat speichert dann eine Referenz auf eine Bank, anstelle der einzelnen Konten. Welcher Bank ein Geldautomat gehört, bekommt der Konstruktor des Geldautomaten übergeben. 
	 */
	
	int AnzahlKonten;
	String BankName;
	
	public Bank(String name, int konten) {
		AnzahlKonten = konten;
		BankName = name;
	}
	
Bank postbank = new Bank("Postbank", 300);
Bank deutscheBank = new Bank("Deutsche Bank", 440);
Bank sparkasse = new Bank("Sparkasse", 100);
	
	
}
