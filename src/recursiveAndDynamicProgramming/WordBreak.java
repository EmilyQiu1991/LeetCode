package recursiveAndDynamicProgramming;
import java.util.*;
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0){
        	return false;
        }
        boolean[] t = new boolean[s.length()+1];
        //initial
        t[0]=true;
        for(int i=1;i<t.length;i++){
        	for(int j=0;j<wordDict.size();j++){
        		String word = wordDict.get(j);
        		if(word.length()<=i&&s.substring(i-word.length()+1, i+1).equals(word) && t[i-word.length()]){
        			t[i]=true;
        		}
        	}
        }
        return t[s.length()];
    }
    public List<List<String>> wordBreak(String s, List<String> wordDict) {
        
    }
    public void backtrack(String s, List<List<String>> list, List<String> tempList, int start, String s){
    	if(start<0){
    		list.add(new ArrayList)
    	}
    }

}
