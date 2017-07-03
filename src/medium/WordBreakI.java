package medium;

import java.util.*;

public class WordBreakI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
       //         "icecream","and","go","i","like","ice","cream"};
		//wordBreak("ilike",Arrays.asList(dictionary));
		String dic[]={"aaaa","aaa"};
		wordBreak("aaaaaaa",Arrays.asList(dic));
	}

	/**
	 * The idea is simple, we consider each prefix and search it in dictionary. 
	 * If the prefix is present in dictionary, we recur for rest of the string (or suffix). 
	 * If the recursive call for suffix returns true, we return true, 
	 * otherwise we try next prefix. If we have tried all prefixes and none of them resulted in a solution, we return false.
	 * @param wordDict
	 * O(2^n)
	 * @return
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		if(s==null||s.length()==0) return true;
		for(int i=1;i<=s.length();i++){
			String prefix=s.substring(0, i);//the length of prefix is i-0, if i==s.length(), prefix==s
			String suffix=s.substring(i,s.length());
			if(wordDict.contains(prefix)&& wordBreak(suffix,wordDict)){
//				if(i<s.length()){
//				  wordBreak(s.substring(i,s.length()),wordDict);
//				}else{
//					return true;
//				}
				return true;
			}
		}
		return false;
	}
	

}
