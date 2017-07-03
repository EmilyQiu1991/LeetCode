package easy;
import java.util.*;
public class ConstructRect {

	public static void main(String[] args) {
		String[] s1= {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] s2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		findRestaurant(s1,s2);
 	}
	public int[] constructRectangle(int area) {
		int[] res = new int[2];
		int diff=Integer.MAX_VALUE;
        for(int i=1;i<Math.sqrt(area);i++){
        	if(area%i==0){
        		if(area/i-i<diff){
        			res[0]=i;
        			res[1]=area/i;
        		}
        	}
        }
        return res;
        
    }
	 public static String[] findRestaurant(String[] list1, String[] list2) {       
	        int indexSum=Integer.MAX_VALUE;
	        Map<String,Integer> map = new HashMap<String,Integer>();
	        List<String> res = new LinkedList<String>();
	        for(int i =0;i<list1.length;i++){
	            map.put(list1[i],i);
	        }
	        for(int i =0;i<list2.length;i++){
	        	Integer j= map.get(list2[i]);
	        	if(j!=null&&i+j<=indexSum){
	        		indexSum=i+j;
	        		if(i+j<indexSum){
	        			res= new LinkedList<>();
	        		}
	        		res.add(list2[i]);
	        	}
	           
	        }
	        return res.toArray(new String[res.size()]);
	     
	        
	    }

}
