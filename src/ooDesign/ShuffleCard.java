package ooDesign;
import java.util.*;
public class ShuffleCard {
	public static void main(String args[]){
		List<Integer> cards= new ArrayList<Integer>();
		for(int i=0;i<7;i++){
			cards.add(i);
		}
		for(int a:shuffle(cards)){
			System.out.print(a+" ");
		}
	}
	public static int[] shuffle(int[] cardsArr){
		List<Integer> cards= new ArrayList<Integer>();
		
		for (int index = 0; index < cardsArr.length; index++)
		{
			cards.add(cardsArr[index]);
		}
		List<Integer> res= new ArrayList<Integer>();
		for(int i=7;i>0;i--){
			int randomIndex=(int) (Math.random()*i);
			res.add(cards.get(randomIndex));
			cards.remove(randomIndex);
		}
		int[] resArray = new int[res.size()];
		for(int i=0;i<res.size();i++){
			resArray[i]=res.get(i);
		}
		return resArray;
	}
	
}
