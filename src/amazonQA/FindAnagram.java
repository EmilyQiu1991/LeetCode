package amazonQA;

import java.util.ArrayList;

public class FindAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<Integer> findAnagrams(String s, String p) {
     	List<Integer> result= new ArrayList<Integer>();
		int[] map = new int[128];
		for(char c:p.toCharArray()){
			map[c]++;// suppose p is abc, map would be (a,1)(b,1)(c,1);
		}
		int i=0,np=p.length(),ns=s.length();
		
		while(i<=ns-np){
			boolean success = true;
			int[] temp = map.clone();
			for(int j=i;j<i+np;j++){
				if(--temp[s.charAt(j)] < 0){
	 				success=false;
	 				break;
				}
			}
			if(success)
				result.add(i);
			i++;
		}
		return result;
 }

}
