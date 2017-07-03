package medium;

public class TicTacToe {
	private char[][] grid;
	private int n;
	public static void main(String args[]){
		TicTacToe t = new TicTacToe(2);
//		t.move(0, 0, 1);
//		t.move(0, 2, 2);
//		t.move(2, 2, 1);
//		t.move(1, 1, 2);
//		t.move(2, 0, 1);
//		t.move(1, 0, 2);
//		t.move(2, 1, 1);
		t.move(0, 0, 2);
		t.move(0, 1, 1);
		t.move(1, 1, 2);
	}
	public TicTacToe(int n){
		grid = new char[n][n];
		this.n=n;
	}
	
	public int move(int row,int col, int player){
		if(player==1){
			grid[row][col]='X';
		}else{
			grid[row][col]='O';
		}
		return isWin(row,col,player);
	}
	private int isWin(int row, int col, int player) {
		boolean rowWin = true,colWin=true,diagonalWin = true, diagonal1Win = true;
		//check row
		for(int i=0;i<n;i++){
			if(grid[row][i]!=grid[row][col]) {
				rowWin=false;
				break;
			}
		}
		//check col
		for(int i=0;i<n;i++){
			if(grid[i][col]!=grid[row][col]) {
				colWin = false;
				break;
			}
		}
		//check diagonal
		if(row+col==n-1){
			for(int i=0;i<n;i++){
				if(grid[i][n-1-i]!=grid[row][col]){
					diagonalWin=false;
					break;
				}
			}
		}else{
			diagonalWin= false;
		}
		//check another diagonal
		if(row==col){
			for(int i=0;i<n;i++){
				if(grid[i][i]!=grid[row][col]){
					diagonal1Win=false;
					break;
				}
			}
		}else{
			diagonal1Win = false;
		}
		return rowWin||colWin||diagonalWin||diagonal1Win?player:0;
	}


}
