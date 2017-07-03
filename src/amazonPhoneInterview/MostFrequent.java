package amazonPhoneInterview;
import java.util.*;
public class MostFrequent {

	public static void main(String[] args) {
		String s=" I like blue  bb cc aa";
		
		String[] words= s.trim().split(" ");
		MostFrequent a= new MostFrequent();
		
		System.out.println(a.mostFrequentWord(s));
	}
	/**
	 * @param s most frequent/commom/maximum repeating word in a sentence
	 * @return
	 */
	public String mostFrequentWord(String s){
		if(s==null||s.length()==0) return s;
		Map<String, Integer> map = new HashMap<String,Integer>();
		String[] words= s.trim().split(" ");
		String res=words[0];
		for(String str:words){
			if(!map.containsKey(s)){
				map.put(str, 0);
			}
			map.put(str, map.get(str)+1);
			if(map.get(str)>map.get(res)){
				res=str;
			}
			
		}
		return res;
	}

}
