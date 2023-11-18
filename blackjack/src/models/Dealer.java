package models;

public class Dealer {
	private Hand hand = new Hand();

    public void takeCard(Deck deck) {
        deck.dealCard(this.hand);
    }
    
    public void showFirstCard() {
    	Card card = this.hand.cards.get(0);
    	System.out.print("Carta virada do dealer: ");
        System.out.println(card.getValue() + " de " + card.getSuit());
    }
    
    public void showHand() {
        System.out.println("Cartas do dealer:");
        this.hand.printHand();
    }
    
    public Hand getHand() {
        return hand;
    }
    
    public int calculateHandValue() {
        int total = 0;

        for (Card card : this.getHand().cards) {
            int value = card.getValue();
            if (value > 10) {
                total += 10; // Cartas faciais valem 10 pontos
            } else {
                total += value; // Para valores normais de cartas (2-10)
            }
        }
        return total;
    }
}
