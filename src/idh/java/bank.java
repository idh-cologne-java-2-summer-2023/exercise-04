package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class bank {

	Account[] accounts = new Account[5];
	
	public bank(){
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
		
	}
	
	//ich bin leicht von Aufgabe 2 überfordert
	
}
