package models;
import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack {
	private Scanner scan = new Scanner(System.in);
	private int qnt_users;
	private ArrayList<Player> players;
	private Deck deck;
	private Dealer dealer = new Dealer();
	public void start() {
		System.out.println("You're started the BLACKJACK!");
		System.out.println("");
		createPlayers();
		deck = new Deck();
		shuffleDeck();
        dealInitialCards();
        showHands();
	}
	
	private void createPlayers() {
        boolean valid = false;

        do {
            try {
                System.out.print("Quantas pessoas vão jogar [1 a 8]: ");
                qnt_users = scan.nextInt();
                scan.nextLine(); // Limpa a quebra de linha após a leitura do número
                if (qnt_users >= 1 && qnt_users <= 8) {
                    valid = true;
                } else {
                    System.out.println("Por favor, insira um número entre 1 e 8.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
                scan.nextLine(); // Limpa a entrada incorreta
            }
        } while (!valid);

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
	
	private void shuffleDeck() {
		deck.shuffle();
	}
	
    private void dealInitialCards() {
    	for (int j = 0; j < 2; j++) {
            for (Player player : players) {
            	if (player.getBank() > 0)
            	{
            		deck.dealCard(player.getHand());
            	}
            }
        	deck.dealCard(dealer.getHand());
    	}
    }
    
    private void showHands() {
        System.out.println("\nEstado inicial das mãos dos jogadores:");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.print(player.getName() + ": ");
            player.showHand();
        }
        System.out.print("Dealer: ");
        dealer.showHand();
    }
}