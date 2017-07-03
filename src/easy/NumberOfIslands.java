package easy;
import java.util.*;
public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { {'1','0','1','1','1'},
						  {'1','0','1','0','1'},
						  {'1','1','1','0','1'}};
		System.out.println(numIslands2(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					count++;
					// dsf to mark the adjcent to 0
					dsfExplore(grid, row, col);
				}
			}
		}
		return count;
	}

	private static void dsfExplore(char[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
			return;
		if (grid[row][col] == '0')
			return;
		grid[row][col] = '0';// this is the point of this method
		// mark it's adjcent recursively
		dsfExplore(grid, row - 1, col);// up
		dsfExplore(grid, row + 1, col);// down
		dsfExplore(grid, row, col - 1);// left
		dsfExplore(grid, row, col + 1);// right
	}
	
	public static int numIslands2(char[][] grid) {
	       int res=0;
	        if(grid==null||grid.length==0||grid[0].length==0) return res;
	        Queue<Pair> queue = new LinkedList<Pair>(); 
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1'){//ok, find a island
	                	System.out.println("check start from i:"+i+"; j"+j);
	                    res++;
	                    queue.offer(new Pair(i,j));//put into queue
	                    grid[i][j]='0';//set as visited
	                    while(!queue.isEmpty()){
	                        Pair indexPair=queue.poll();
	                        int row=indexPair.row;
	                        int col=indexPair.col;
	                        System.out.println("row :" +row +"; col:"+col);
	                        //check up 
	                        if(row>0&&grid[row-1][col]=='1'){
	                           queue.offer(new Pair(row-1,col));
	                           grid[row-1][col]='0';
	                        }
	                        //check left
	                        if(col>0&&grid[row][col-1]=='1'){
	                            queue.offer(new Pair(row,col-1));
	                            grid[row][col-1]='0';
	                        }
	                        //check right
	                        if(col<grid[0].length-1&&grid[row][col+1]=='1'){
	                            queue.offer(new Pair(row,col+1));
	                            grid[row][col+1]='0';
	                        }
	                        //check down
	                        if(row<grid.length-1&&grid[row+1][col]=='1'){
	                            queue.offer(new Pair(row+1,col));
	                            grid[row+1][col]='0';
	                        }
	                    }
	                }
	            }
	        }
	        return res;
	    }
	static class Pair{
        int row;
        int col;
        Pair(int x, int y){
            row=x;
            col=y;
        }
    }
	public static void solve(char[][] board) {
        Queue<Pair> queue= new LinkedList<Pair>();
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(i==0||i==board.length-1||j==0||j==board[0].length-1){//check up,down,left, right boundary
        			if(board[i][j]=='O'){//start from this point to do BFS, mark its adjacent to 'B'
        				queue.offer(new Pair(i,j));
        				board[i][j]='B';
        				while(!queue.isEmpty()){
        					Pair pair=queue.poll();
        					int row= pair.row;
        					int col= pair.col;
        					//check up 
	                        if(row>0&&board[row-1][col]=='O'){
	                           queue.offer(new Pair(row-1,col));
	                           board[row-1][col]='B';
	                        }
	                        //check left
	                        if(col>0&&board[row][col-1]=='O'){
	                            queue.offer(new Pair(row,col-1));
	                            board[row][col-1]='B';
	                        }
	                        //check right
	                        if(col<board[0].length-1&&board[row][col+1]=='O'){
	                            queue.offer(new Pair(row,col+1));
	                            board[row][col+1]='B';
	                        }
	                        //check down
	                        if(row<board.length-1&&board[row+1][col]=='O'){
	                            queue.offer(new Pair(row+1,col));
	                            board[row+1][col]='B';
	                        }
        				}
        			}
        		}
        	}
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='O'){
        			board[i][j]='X';
        		}
        		if(board[i][j]=='B'){
        			board[i][j]='O';
        		}
        	}
        }
    }
	
	
	
	
}
