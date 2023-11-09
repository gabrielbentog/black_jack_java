package models;

public class Player {
	
	private String name;
	private int bet;
	private int bank;
    private Hand hand;

	public Player(String name) {
		this.name = name;
        this.hand = new Hand();
		this.bet = 0;
		this.bank = 50;
	}
	
    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
    
    public int getBet() {
        return bet;
    }
    
    public int getBank() {
        return bank;
    }
    
    public void placeBet(int amount) {
    	if(this.bank >= amount) {
    		this.bet += amount;
    		this.bank -= amount;
    	} else {
            System.out.println("Você não tem fundos suficientes para fazer essa aposta.");
    	}
    }
    
    public void takeCard(Deck deck) {
        deck.dealCard(this.hand);
    }
    
    public void showHand() {
        System.out.println("Cartas de " + this.name + ":");
        this.hand.printHand();
    }
}
