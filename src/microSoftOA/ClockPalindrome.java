package microSoftOA;
import java.util.*;
public class ClockPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generatePalindrome();
	}
	public static List<String> generatePalindrome(){
		List<String> list = new ArrayList<String>();
		for(int hour=1;hour<=12;hour++){
			//generate first digit of min
			if(hour<10){
				int min = hour;//second digit of min must the same as hour
				for(int i=0;i<=5;i++){
					int curMin=i*10+min;
					if(i==0)
						list.add(hour+":0"+curMin);
					else
						list.add(hour+":"+curMin);
				}
			}else{
				int temp = hour;
				int min=0;
				while(temp!=0){
					min=min*10+temp%10;
					temp = temp/10;
				}
				list.add(hour+":"+min);
			}
		}
		for(String s: list){
			System.out.print(s+"  ");
		}
		return list;
	}

}
