package medium;
import java.util.*;
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="leetcode";
		List<String> dic = new LinkedList<String>();
		dic.add("leet");
		dic.add("code");
		WordBreak a = new WordBreak();
		a.wordBreak(s, dic);
	}
	 public boolean wordBreak(String s, List<String> wordDict) {
		 String s2=s;
		 int len = s2.length();
		 boolean[] possible=new boolean[len+1];
		 
		 possible[0] = true;
		 
		 for(int i=1;i<=len;i++){
			 System.out.print("i: "+i);
			 for(int k=0;k<i;k++){
				  System.out.println(";  k: "+k +"  substring : "+s2.substring(k, i));
				 possible[i]=possible[k]&&wordDict.contains(s2.substring(k, i));
				 System.out.println("possible "+i +"  :  "+possible[i]);
				 if(possible[i]) break;
			 }
		 }
		 return possible[len-1];
	 }

}
