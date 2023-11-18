package models;

public class Card {
	private String suit;
	private int value;
	
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }
	
    public String getSuit() {
        return suit;
    }

    public int getValue() {
    	return value;
    }
    
	public String getValueName(){

		if (this.value == 1) {		
			return "Ace";
		}
		else if (this.value == 2) {
			return "Dois";
		}
		else if (this.value == 3) {
			return "Tres";
		}
		else if (this.value == 4) {
			return "Quatro";
		}
		else if (this.value == 5) {
			return "Cinco";
		}
		else if (this.value == 6) {
			return "Seis";
		}
		else if (this.value == 7) {
			return "Sete";
		}
		else if (this.value == 8) {
			return "Oito";
		}
		else if (this.value == 9) {
			return "Nove";
		}
		else if (this.value == 10) {
			return "Dez";
		}
		else if (this.value == 11) {
			return "Jack";
		}
		else if (this.value == 12) {
			return "Rainha";
		}
		else if (this.value == 13) {
			return "Rei";
		} 
		return "Nao encontrado";
	}
}
