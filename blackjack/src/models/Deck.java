package models;
import java.util.Random;

public class Deck {

	Card[] deck = new Card[52];
	
	public Deck() {
		int count = 0;
		
		for ( int i = 1; i <= 13; i++) {
			deck[count++] = new Card("Espadas",  i);
		}
		
		for ( int i = 1; i <= 13; i++) {
			deck[count++] = new Card("Copas",  i);
		}
		
		for ( int i = 1; i <= 13; i++) {
			deck[count++] = new Card("Paus",  i);
		}
		
		for ( int i = 1; i <= 13; i++) {
			deck[count++] = new Card("Ouros",  i);
		}
	}
	
	public void shuffle() {
		Random random = new Random();
		
		for (int i = 0; i < deck.length; i++) {
			int j = random.nextInt(deck.length);
			
			// Troca as cartas de posicao
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	
	public Card getCard(int index) {
		return deck[index];
	}
	
	public void printDeck() {
	    for (Card card : deck) {
	        System.out.println("Naipe: " + card.getSuit() + ", Valor: " + card.getValue());
	    }
	}
}
