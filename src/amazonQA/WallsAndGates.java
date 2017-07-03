package amazonQA;
import java.util.*;
public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void wallsAndGates(int[][] rooms) {
	        //Push all gates into queue first. Then for each gate update its neighbor cells and push them to the queue.
	        //Repeating above steps until there is nothing left in the queue.
	        Queue<int[]> queue = new LinkedList<int[]>();
	        for(int i=0;i<rooms.length;i++){
	            for(int j=0;j<rooms[0].length;j++){
	                if(rooms[i][j]==0){
	                    queue.offer(new int[]{i,j});
	                }
	            }
	        }
	        while(!queue.isEmpty()){
	          int[] top = queue.poll();
	          int row = top[0], col= top[1];
	          //left
	          if(isValid(rooms,row-1,col)){
	              rooms[row-1][col] =1+ rooms[row][col];
	              queue.offer(new int[]{row-1,col});
	          }
	          //right
	          if(isValid(rooms,row+1,col)){
	              rooms[row+1][col] =1+ rooms[row][col];
	              queue.offer(new int[]{row+1,col});
	          }
	          //up
	          if(isValid(rooms,row,col-1)){
	              rooms[row][col-1] =1+ rooms[row][col];
	              queue.offer(new int[]{row,col-1});
	          }
	          //down
	          if(isValid(rooms,row,col+1)){
	              rooms[row][col+1] =1+ rooms[row][col];
	              queue.offer(new int[]{row,col+1});
	          }
	        }
	    }
	    public boolean isValid(int[][] rooms, int row, int col){
	        return row>=0&& row<rooms.length&&col>=0&&col<rooms[0].length&& rooms[row][col]== Integer.MAX_VALUE;
	    }

}
