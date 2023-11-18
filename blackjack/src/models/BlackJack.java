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
		try {
			System.out.println("You're started the BLACKJACK!");
			System.out.println("");
			createPlayers();
			deck = new Deck();
			shuffleDeck();
	        dealInitialCards();
	        // showHands();
	        dealer.showFirstCard();
	        
	        for (Player player : players) {
	            boolean win = playerTurn(player);
	            if (win) { 
	            	break; 
	            } else {
	            	Player winner = determineWinner(players, dealer);

	                // Exibir resultado
	                if (winner != null) {
	                    System.out.println("O vencedor é: " + winner.getName());
	                } else {
	                    System.out.println("Nenhum vencedor. O dealer ganha.");
	                }
	            }
	        }
	        
	        dealerTurn();
		} catch(Exception e) {
			System.out.println("Ocorreu um erro durante o jogo: " + e.getMessage());
            e.printStackTrace();
		}
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

    private boolean playerTurn(Player player) {
        System.out.println("\nTurno do jogador: " + player.getName());

        boolean playerBusted = false;
        while (true) {
            player.showHand();
            int total = player.calculateHandValue();
            System.out.println("Total: " + total);
            if (total == 21) {
                System.out.println("Você fez um Blackjack natural! Parabéns!");
                return true;
            }
            System.out.print("Escolha (1 - Pedir carta / 2 - Parar): ");
            int choice = scan.nextInt();

            if (choice == 1) {
                deck.dealCard(player.getHand());
                int playerTotal = player.calculateHandValue();
                if (playerTotal > 21) {
                    System.out.println("Estourou! Total: " + playerTotal);
                    playerBusted = true;
                    break;
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        if (playerBusted) {
            System.out.println(player.getName() + " estourou!");
            return false;
        } else {
            System.out.println(player.getName() + " parou.");
            return false;
        }
    }

    private void dealerTurn() {
        System.out.println("\nTurno do dealer:");

        dealer.showHand();
        int dealerTotal = dealer.calculateHandValue();

        // O dealer deve pedir cartas até alcançar 17 ou mais
        while (dealerTotal < 17) {
            System.out.println("Dealer pede mais uma carta...");
            deck.dealCard(dealer.getHand());

            dealer.showHand();
            dealerTotal = dealer.calculateHandValue();
        }

        if (dealerTotal > 21) {
            System.out.println("Dealer estourou! Total: " + dealerTotal);
        } else {
            System.out.println("Dealer parou. Total: " + dealerTotal);
        }
    }
    
    private Player determineWinner(ArrayList<Player> players, Dealer dealer) {
        Player winner = null;
        int dealerTotal = dealer.calculateHandValue();

        // Se o dealer estourar, qualquer jogador que não estourar vence
        if (dealerTotal > 21) {
            for (Player player : players) {
                if (player.calculateHandValue() <= 21) {
                    winner = player;
                    break;
                }
            }
        } else {
            int maxValidTotal = 0; // Armazena o máximo total válido entre jogadores
            for (Player player : players) {
                int playerTotal = player.calculateHandValue();
                if (playerTotal <= 21 && playerTotal > maxValidTotal) {
                    maxValidTotal = playerTotal;
                    winner = player;
                }
            }
        }
        return winner;
    }
}