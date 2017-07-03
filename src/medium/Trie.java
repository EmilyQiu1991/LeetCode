package medium;

import java.util.HashMap;

/**
 * @author qiuyu
 *word list validation
 */
public class Trie {
	Node root;
	public Trie(){
		root = new Node();
	}
	class Node{
        boolean isCompleteWord;
        Node[] children = new Node[26];
    }
	public static void main(String[] args) {
		Trie trie= new Trie();
		trie.insert("abc");
		trie.search("abc");
		trie.search("ab");
		trie.insert("ab");
		trie.search("ab");
		trie.insert("ab");
		trie.search("ab");
	}
	/** Inserts a word into the trie. my solution*/
    public void insert(String s) {
        // make current points to root;
		Node current = root;
		for(int i=0;i<s.toCharArray().length;i++){
			char c = s.charAt(i);	
			if(current.children[c-'a']==null){
				//if str[i] is null, create node temp,
				Node temp = new Node();
				if(i==s.toCharArray().length-1){
					temp.isCompleteWord=true;
				}
				current.children[c-'a'] = temp;//make current.children[str[i]-97] point temp
				current=temp;//and make current points to temp
			}
			else{
				//if str[i] is not null, make p points to p.children[str[i]-97]
				if(i==s.toCharArray().length-1){
					current.children[c-'a'].isCompleteWord=true;
				}
				current=current.children[c-'a'];
			}
		}
    }
	 /** Inserts a word into the trie. other's solution */
    public void insert2(String s) {
        // make current points to root;
		Node current = root;
		for(int i=0;i<s.toCharArray().length;i++){
			char c = s.charAt(i);	
			if(current.children[c-'a']==null){
				//if str[i] is null, create node temp,
				current.children[c-'a'] = new Node();//make current.children[str[i]-97] point temp
			}
			current = current.children[c-'a'];		
		}
		current.isCompleteWord=true;
    }
	
	/**
	 * @param str is the string need to be searched
	 * return if the word is in the trie
	 */
    /** Returns if the word is in the trie. */
    public boolean search(String str) {
        Node current = root;//make current points to root
		for(int i =0;i<str.toCharArray().length;i++){
			char c = str.charAt(i);// get str[i]
			//determine whether  current.childeren[c-'a'] is null
			if(current.children[c-'a']==null){// it is null, return false
				
				return false;
			}else{
				if(i==str.toCharArray().length-1){
					if(!current.children[c-'a'].isCompleteWord){
						return false;
					}
				}
				current=current.children[c-'a'];// if it exists, check next char in the str
			}
		}
		return true;
    }
    public boolean search2(String word) {
        Node ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isCompleteWord;
    }
	
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;//make current points to root
        
		for(int i =0;i<prefix.toCharArray().length;i++){
			char c = prefix.charAt(i);// get str[i]
			//determine whether  current.childeren[c-'a'] is null
			if(current.children[c-'a']==null){// it is null, return false
				return false;
			}//else{   don't need this else, stupid
				current=current.children[c-'a'];// if it exists, check next char in the str
			//}
		}
		
		return true;
    }
	

}
