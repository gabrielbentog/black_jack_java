package models;
import java.util.Scanner;

public class BlackJack {
	private Scanner scan = new Scanner(System.in);
	private int qnt_users;
	
	public void start() {
		System.out.println("You're started the BLACKJACK!");
		System.out.println("");
		
		do {
			System.out.print("Quantas pessoas vão jogar [1 a 8]: ");
			qnt_users = scan.nextInt();
		} while (qnt_users > 6 || qnt_users <= 0);
	}
	
}
