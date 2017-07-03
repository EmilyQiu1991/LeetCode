package ooDesign;

public  class Card {
	private boolean available= true;
	
	/**
	 * number or face that's on card- a number 2 through 10, or 11 for Jack,12 for queue, 13 for king, or 1 for Ace
	 */
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c,Suit s){
		faceValue=c;
		suit=s;
	}
}
