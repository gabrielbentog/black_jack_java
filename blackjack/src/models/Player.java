package models;

public class Player {
	
	private String name;
	private int bet;
	private int bank;
	
	public Player(String name) {
		this.name = name;
		this.bet = 0;
		this.bank = 50;
	}
	
    public String getName() {
        return name;
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
}
