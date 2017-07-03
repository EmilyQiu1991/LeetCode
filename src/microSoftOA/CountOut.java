package microSoftOA;
import java.util.*;
public class CountOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countout(3,3));
	}
	public static ArrayList<Integer> countout(int n, int k){
		ArrayList<Integer> winner = new ArrayList<Integer>();
		int[] order = new int[n];
		int p = 0;
		for(int i=0;i<n;i++){
			order[i]= i+1;
		}
		int cur = 0;
		int count = 0;
		while(count<n-k+1){
			while(order[p]==0){
				p = (p+1)%n;
			}
			cur++;
			if(cur==k){
				order[p]  = 0;
				cur = 0;
				count++;
			}
			p = (p+1)%n;
		}
		for(int i=0;i<n;i++){
			if(order[i]!=0){
				winner.add(order[i]);
			}
		}
		return winner;
	}
	public static ArrayList<Integer> countout(int n,int k){
		ArrayList<Integer> winner = new ArrayList<Integer>();
		for(int i=0;i<k;i++){
			winner.set(i, i+1);
		}
		ArrayList<Integer> count = new ArrayList<Integer>();
		while(winner.size()>1){
			
		}
	}

}
