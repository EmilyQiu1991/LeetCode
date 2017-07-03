package microSoftOA;

public class NumberOfIslands {

	//dfs 0 is sea, 1 is island
	public int numIslands(boolean[][] grid) {
		 if(grid == null || grid.length == 0 || grid[0].length == 0){
			 return 0;
		 }
		 int res = 0;
		 for(int i=0;i<grid.length;i++){
			 for(int j=0;j<grid[0].length;j++){
				 if(grid[i][j]){
					 res ++;
					 dfs(grid,i,j);//mark its direct and indirect neighbor to false
				 }
			 }
		 }
		 return res;
	}
	private void dfs(boolean[][] grid, int i, int j) {
		if(i<0 || i >grid.length-1 || j< 0 ||j>grid[0].length-1 || !grid[i][j]){
			return;
		}
		grid[i][j]=false; // remember to mark it as false, or there will be stackoverflow,
		dfs(grid, i-1,j);//up
		dfs(grid, i+1,j);//down
		dfs(grid, i, j-1);//left
		dfs(grid, i, j+1);//left
	}

}
