package amazonQA;
import java.util.*;
/*19 is a happy number, 1*1+9*9=82 8*8+2*2=68 6*6+8+8=100 1*1+0*0+0*0=1*/
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n!=1){
            int sum=0;
            //calculate sum of squares of its digits 
            while(n!=0){
                int temp = n%10;
                sum += temp*temp;
                n=n/10;
            }
            if(!set.add(sum)) return false;
            //set n is the new sum and repeate the process
            n=sum;
        }
        return true;
    }
	//no extra space
	public boolean isHappy1(int n) {
		int slow = n, faster = n;
		do{
			slow = digitSquareSum(slow);
			faster = digitSquareSum(faster);
			faster = digitSquareSum(faster);
		}while(slow!=faster);
		if(slow ==1){
			return true;
		}
		return false;
			
		
	}
	public int digitSquareSum(int n){
		int sum = 0;
		 while(n!=0){
             int temp = n%10;
             sum += temp*temp;
             n=n/10;
         }
		 return sum;
	}
	

}
