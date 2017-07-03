package easy;

public class IslandPrimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	  public static int islandPerimeter(int[][] grid) {
	        if(grid==null||grid.length==0||grid[0].length==0) return 0;
	        //find a island(1), res increase by 4, then find its right and down neighbor, find one, decrease by 2
	        int res=0;
	        int rowCount= grid.length;
	        int colCount=grid[0].length;
	        for(int row=0;row <grid.length;row++){
	            for(int col=0;col<grid[0].length;col++){
	                if(grid[row][col]==1){
	                    res+=4;
	                    if(row<rowCount-1&&grid[row+1][col]==1) res-=2;
	                    if(col<colCount-1&&grid[row][col+1]==1) res-=2;
	                }
	            }
	        }
	        return res;
	    }
}
