package models;

public class Dealer {
	private Hand hand = new Hand();

    public void takeCard(Deck deck) {
        deck.dealCard(this.hand);
    }
    
    public void showHand() {
        System.out.println("Cartas do dealer:");
        this.hand.printHand();
    }
    
    public Hand getHand() {
        return hand;
    }
}
