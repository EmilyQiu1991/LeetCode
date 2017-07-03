/**
 * 
 */
package medium;
import java.util.*;
/**
 * @author qiuyu
 *
 */
public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord="a";
		String endWord="a";
		String[] list={"b"};
		List<String> list1 = new LinkedList<String>(Arrays.asList(list));

		System.out.println(ladderLength(beginWord,endWord,list1));
				
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(endWord);
        int res=1;
        Queue<String> queue = new LinkedList<String>();
        addNextNode(beginWord,wordList,queue);
        while(!queue.isEmpty()){
        	res++;//this should be before the return statement, or there will be one less than correct result
        	int size=queue.size();
        	for(int i=0;i<size;i++){
        		String s=queue.poll();
        		if(s.equals(endWord)) return res;
        		addNextNode(s,wordList,queue);
        	}
        	
        }
        return 0; //here return 0 ,not res
    }
	private static void addNextNode(String word, List<String> wordList,Queue<String> queue) {
		char[] wordArr=word.toCharArray();
		for(int i=0;i<wordArr.length;i++){
			char letter=wordArr[i];
			for(int k=0;k<26;k++){
				wordArr[i]=(char) ('a'+k);
				if(wordList.contains(String.valueOf(wordArr))&&!String.valueOf(wordArr).equals(word)){//solution has another condition , wordArr is not endword, don't know why
					queue.offer(String.valueOf(wordArr));
					wordList.remove(String.valueOf(wordArr));
				}
				
			}
			wordArr[i]=letter;
		}
		
	}

}
