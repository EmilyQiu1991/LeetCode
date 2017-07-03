package easy;

import java.util.*;
import java.util.Collections;

public class GroupAnagram {
	static String[] str= {"eat", "tea", "tan", "ate", "nat", "bat"};
	public static void main(String[] args) {
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		groupAnagrams(str);
	}
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            // 将单词按字母排序
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        // 将列表按单词排序
        for(String key : map.keySet()){
            List<String> curr = map.get(key);
            Collections.sort(curr);
            res.add(curr);
        }
        return res;
    }

}
