package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {

	// Anfangskapital im Geldautomaten
	int cash = 100;

	// Konten, die dem Geldautomaten bekannt sind
	Account[] accounts = new Account[5];

	public ATM() {
		// Konten mit unterschiedlichem Kontostand erzeugen
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	/**
	 * Hauptbefehlsschleife des Geldautomaten. Fordert den Benutzer auf, eine Nummer einzugeben, und gibt diese Nummer an die Funktion cashout(...) weiter, die tatsächlich die Berechnung durchführt und Geld ausgibt. Wenn der Benutzer etwas anderes als eine Ganzzahl eingibt, bricht die Schleife ab und das Programm wird beendet.
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Geben Sie Ihre Kontonummer ein: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Geben Sie den abzuhebenden Betrag ein: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		// Prüfen, ob im Geldautomaten genug Geld vorhanden ist
		if (amount > cash) {
			System.out.println("Sorry, nicht genug Bargeld übrig.");
			return;
		}

		// Prüfen, ob das Konto existiert
		Account account = getAccount(accountNumber);
		if (account == null) {
			System.out.println("Sorry, dieses Konto existiert nicht.");
			return;
		}

		// Prüfen, ob genug Geld auf dem Konto ist
		if (amount > account.getBalance()) {
			System.out.println("Sorry, du hast kein Geld mehr.");
			return;
		}

		// abheben
		account.withdraw(amount);
		cash += amount;
		System.out.println("Ok, hier ist dein Geld, viel Spaß!");

	};

	/**
	 * Startet den Geldautomaten
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

	/**
	 * Ruft das Konto anhand einer ID ab.
	 *
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		for (Account account : accounts) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}

}
