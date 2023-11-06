package models;
import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack {
	private Scanner scan = new Scanner(System.in);
	private int qnt_users;
	private ArrayList<Player> players;
	private Deck deck;
	
	public void start() {
		System.out.println("You're started the BLACKJACK!");
		System.out.println("");
		createPlayers();
		deck = new Deck();
	}
	
	private void createPlayers() {
        boolean inputValid = false;

        do {
            try {
                System.out.print("Quantas pessoas vão jogar [1 a 8]: ");
                qnt_users = scan.nextInt();
                scan.nextLine(); // Limpa a quebra de linha após a leitura do número
                if (qnt_users >= 1 && qnt_users <= 8) {
                    inputValid = true;
                } else {
                    System.out.println("Por favor, insira um número entre 1 e 8.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
                scan.nextLine(); // Limpa a entrada incorreta
            }
        } while (!inputValid);

		
		players = new ArrayList<Player>();
		
		for (int i = 0; i < qnt_users ; i++) {
			System.out.print("Nome do jogador " + (i + 1) + ": ");
			String name = scan.nextLine();
			Player player = new Player(name);
			players.add(player);
		}
		
		System.out.println("Jogadores: ");
		for (int i = 0; i < players.size(); i++) {
		    Player player = players.get(i);
		    System.out.println("[" + (i + 1) + "] - " + player.getName());
		}
	}
	
	private void shuffle_deck() {
		deck.shuffle();
	}
}