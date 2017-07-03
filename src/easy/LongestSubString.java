package easy;
import java.util.*;
public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	 public static int lengthOfLongestSubstring(String s) {
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        int head=0;
	        int res=0;
	        char[] charArray= s.toCharArray();
	        for(int i=0;i<charArray.length;i++){
	        	//destory the condition, move head
	            if(map.containsKey(charArray[i])&&head<=map.get(charArray[i])){
	                head= map.get(charArray[i])+1;
	            }
	            map.put(charArray[i],i);
	            res=Math.max(res,i-head+1);
	        }
	        return res;
	    }
	 /** 
	 * @param s allow at most 2 distinct characters
	 * @return
	 */
	public static int lengthOfLongestSubstring2(String s){
		int res=0;
		int head=0;
		Map<Character,Integer> map= new HashMap<Character,Integer>();
		Set<Character> set = new Set
		char[] chars= s.toCharArray();
		for(int i=0;i<chars.length;i++){
			if(!map.containsKey(chars[i])){
				map.put(chars[i], 0);
			}
			map.put(chars[i], map.get(chars[i])+1);
			while(map.size()>2){
				map.put(chars[head], map.get(chars[i])-1);
				if(map.get(chars[head])==0){
					map.remove(chars[head]);
				}
				head++;
				
			}
			res=Math.max(res,i-head+1);
		}
		return res;
	 }
 
}
