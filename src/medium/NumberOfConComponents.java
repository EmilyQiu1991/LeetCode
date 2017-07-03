package medium;
import java.util.*;
public class NumberOfConComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("c");
		List<String> list2 = new ArrayList<String>();
		list2.add("b1");
		list2.add("b2");
		Collections.sort(list2);
		for(String s : list2){
			System.out.println(s);
		}
		
	}
	
}
