package models;
import java.util.Random;

public class Deck {

	Card[] deck = new Card[52];
    private int cardsDrawn;

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
		
        this.cardsDrawn = 0;
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
		
        this.cardsDrawn = 0;
	}
	
	public Card getCard(int index) {
		return deck[index];
	}
	
    public Card drawCard() {
        if (this.cardsDrawn < deck.length) {
            return deck[this.cardsDrawn++];
        } else {
            System.out.println("Embaralhando novamente...");
            this.shuffle();
            return null;
        }
    }
	
    public void dealCard(Hand hand) {
        Card drawnCard = drawCard();
        if (drawnCard != null) {
            hand.addCard(drawnCard);
        } else {
            System.out.println("Não há mais cartas para distribuir.");
        }
    }
   
	public void printDeck() {
	    for (Card card : deck) {
	        System.out.println("Naipe: " + card.getSuit() + ", Valor: " + card.getValue());
	    }
	}
}
