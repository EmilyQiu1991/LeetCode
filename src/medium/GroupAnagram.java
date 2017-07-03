package medium;
import java.util.*;
public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		
		//create a hash map to map the sorted string value and its anagram is given array
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		//go through each string is array, sort it to find the key in map, add it to value
		for(String s : strs){
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
			res.add(entry.getValue());
		}
		return res;
	}

}
