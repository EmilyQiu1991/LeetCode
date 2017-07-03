package medium;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char[][] board = {{'A','B','C','E'} ,
    		   			 {'S','F','C','S'},
    		   			 {'A','D','E','E'}};
       WordSearch w = new WordSearch();
      System.out.println( w.exist(board, "ABCCED"));
	}
	 public boolean exist(char[][] board, String word) {
		 for(int i=0;i<board.length;i++){
			 for(int j=0;j<board[0].length;j++){
				 if(board[i][j]!=word.charAt(0)){
					 continue;
				 }	 
				 if(backtrack(board,i,j,word,0)){
					 return true;
				 }			
			 }
		 }
		 return false;
	 }
	 public boolean backtrack(char[][] board,  int i, int j, String word,int index){
		 if(index==word.length()){
			 return true;
		 }
		 if(i<0||i>board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index)){
			 return false;
		 }
		
		 board[i][j]='#';
		 boolean res = backtrack(board,i-1,j,word,index+1)
				 ||backtrack(board,i+1,j,word,index+1)
				 ||backtrack(board,i,j-1,word,index+1)
				 ||backtrack(board,i,j+1,word,index+1);
		 board[i][j] = word.charAt(index);
		 return res;
	 }
}
