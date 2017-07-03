import java.util.*;
public class StrongPassword {
	
	
	public static void main(String[] args) {
		Map<Character,Character> map= new HashMap<Character,Character>();
		map.put('a', '@');
		map.put('s', '$');
		map.put('e', '3');
		Set<String> set = new HashSet<String>();
		StrongPassword a = new StrongPassword();
		String s="pass";
		a.strongPassword(set, s.toCharArray(), 0, map);
		for(String str:set){
			System.out.println(str);
		}
	}
	public void strongPassword(Set<String> set, char[] s,int index,Map<Character,Character> map){
		if(index==s.length){
			return;
		}
		if(map.containsKey(s[index])){
			char original=s[index];
			s[index]=map.get(s[index]);
			set.add(String.valueOf(s));
			strongPassword(set,s,index+1,map);
			s[index]=original;
		}
		strongPassword(set,s,index+1,map);
	}

}
