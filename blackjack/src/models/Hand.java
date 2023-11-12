package models;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public void printHand() {
        for (Card card : cards) {
            System.out.println("Naipe: " + card.getSuit() + ", Valor: " + card.getValue());
        }
    }
}
