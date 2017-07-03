package microSoftOA;
import java.util.*;
public class WordSearch2 {

	public static void main(String[] args) {

	}
	 public List<String> findWords(char[][] board, String[] words) {
		 List<String> res = new ArrayList<String>();
		 //build trie
	     TrieNode trie = buildTrie(words);
	     //start backtracking
	     for(int i = 0;i < board.length;i++){
	    	 for(int j = 0 ;j<board[0].length;j++){
	    		 backtrack(board,i,j,trie,res);
	    	 }
	     }
	     return res;
	 }
	private void backtrack(char[][] board, int i, int j, TrieNode trie, List<String> res) {
		//validate row index i, and col index j
		if(i<0||i>=board.length||j<0||j>=board[0].length){
			return;
		}
		//validate prefix exists in trie and whether board[i][j] has been visited
		char c = board[i][j];
		if(c=='#'){
			return;
		}
		//now c is not visited 
		TrieNode node = trie.next[c-'a'];//this statement must come after # visited check, or there will be #-a =62,outofIndex
		if(node==null){
			return;
		}
		board[i][j] = '#';//set as visited to avoid visited here again
		//check whether find the word
		if(node.word!=null){
			res.add(trie.next[c-'a'].word);
			node.word=null;// don't forget to set the word to null to avoid dup in res
		}
		//ok, right now, we can continue backtrack adjecent cell
		backtrack(board,i-1,j,node,res);//up
		backtrack(board,i+1,j,node,res);//down
		backtrack(board,i,j-1,node,res);//left
		backtrack(board,i,j+1,node,res);//right
		board[i][j] = c; 
	}
	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();//root value
		for(String word: words){//insert each word to trie
			// use a pointer to point root node initially
            //and run deeper and deeper as looping through each character in a word
			//reset it to root at the beginning of each loop
			TrieNode p = root; 
			char[] arr = word.toCharArray();
			for(char c:arr){
				if(p.next[c-'a']==null){
					p.next[c-'a'] = new TrieNode();
				}
				p=p.next[c-'a'];
			}
			//at the end of loop,where does p point, p point to last character node of word
			//fill the word at last character node of the word
			p.word = word;
		}
		return root;
	}
	class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;//put the word at the last node, like isCompleteWord
		//but here ,we need the word at end of search
	}
}
