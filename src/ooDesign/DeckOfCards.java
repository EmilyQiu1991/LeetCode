package ooDesign;

public class DeckOfCards {
	private Card cards[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards a = new DeckOfCards();
		
		for(Card c:a.shuffle()){
			System.out.println(c.faceValue +"    "+c.suit);
		}
	}
	public DeckOfCards(){
		this.cards= new Card[52];
		int i=0;
		for(int faceValue=1;faceValue<=13;faceValue++){
			for(Suit s: Suit.values()){
				Card card= new Card(faceValue, s);
				cards[i]=card;
				i++;
			}
			
		}
	}
	public Card[] shuffle(){
		Card[] copy =cards.clone();
		for(int i=0;i<copy.length;i++){
			int k = (int)(Math.random()*(i+1));
			Card temp = copy[k];
			copy[k]= copy[i];
			copy[i]=temp;
		}
		return copy;
	}
}
