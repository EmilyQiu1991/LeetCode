package medium;

public class WordDictionary {

	public static void main(String[] args) {
		//","search","search","search"]
		//["b."],["a.d"],["."]]
		WordDictionary w = new WordDictionary();
		w.addWord("at");
		w.addWord("and");
		w.addWord("an");
		w.addWord("add");
		System.out.println(w.search("a"));
		System.out.println(w.search(".at"));
		w.addWord("bat");
		
		System.out.println(w.search(".at"));
		System.out.println(w.search("an."));
		System.out.println(w.search("a.d."));
		
		System.out.println(w.search("b."));
		System.out.println(w.search("a.d"));
		System.out.println(w.search("."));
	}
	 TrieNode root;
	    public class TrieNode{
	        boolean isCompleteWord;
	        TrieNode[] children = new TrieNode[26];
	    }
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        char[] arr = word.toCharArray();
	        TrieNode cur = root;
	        for(int i = 0; i<arr.length;i++){
	            TrieNode node=cur.children[arr[i]-'a'];
	            if(node==null){
	                node = new TrieNode();
	                cur.children[arr[i]-'a']=node;
	            }
	            if(i==arr.length-1) node.isCompleteWord=true;
	            cur = cur.children[arr[i]-'a'];
	        }
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return searchHelper(word,0,root);
	    }
	    public boolean searchHelper(String word, int k, TrieNode node){
	        if(k==word.length()) {
	        	return node.isCompleteWord?true:false;// this is the conditon to exit,if k==word.length(),return don't let it do below again
	        }
	        TrieNode[] children =node.children;
	        if(word.charAt(k)=='.'){
	             for(TrieNode child:children){
	            	 //this condition is really tricky , if one of the branch return false, continue check next branch
	            	 //until one of the branch return true, if no branch return true, go down below return statement
	                if(child!=null&&searchHelper(word,k+1,child)) return true;
	             }
	        }else{
//	            if(children[word.charAt(k)-'a']==null){
//	                return false;
//	            }else{
//	                return searchHelper(word,k+1,children[word.charAt(k)-'a']);
//	            }
	        	return children[word.charAt(k)-'a']!=null&&searchHelper(word,k+1,children[word.charAt(k)-'a']);
	        }
	        return false;
	       
	    }

}
