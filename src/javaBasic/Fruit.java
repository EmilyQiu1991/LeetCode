package javaBasic;

import java.util.Arrays;
import java.util.Comparator;

public class Fruit implements Comparable<Fruit> {
	private String fruitName;
	private String fruitDesc;
	private int quantity;
	
	@Override
	public int compareTo(Fruit o) {
		
		return this.quantity-o.getQuantity();
	}

	public String getFruitDesc() {
		return fruitDesc;
	}

	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}
	public static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>(){
		public int compare(Fruit fruit1, Fruit fruit2){
			
			return fruit1.getFruitName().toLowerCase().compareTo(fruit2.getFruitName().toLowerCase());
		}
	};
	public static void main(String args[]){

		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70);
		Fruit apple = new Fruit("Apple", "Apple description",100);
		Fruit orange = new Fruit("Orange", "Orange description",80);
		Fruit banana = new Fruit("Banana", "Banana description",90);

		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;

		Arrays.sort(fruits);
		Arrays.sort(fruits,FruitNameComparator);
		int i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() +
			", Quantity : " + temp.getQuantity());
		}

	}

}
