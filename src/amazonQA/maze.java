package amazonQA;

import java.util.Queue;
import java.util.*;
public class maze {
	static boolean res=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
				{1, 0, 1, 1, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 0, 9, 0},
				{0, 1, 1, 0, 1}};
		System.out.print(bfs(grid, new Point(0,0), new Point(3,4)));
	}

	public static boolean maze3(int[][] grid) {
		boolean[][] status=new boolean[grid.length][grid[0].length];
		for(int i=0;i<status.length;i++){
			for(int l=0;l<status[0].length;l++){
				status[i][l]=true;
			}
		}
		canPass(grid,status,0,0);
		return res;
	}
	
	public static void canPass(int[][] array,boolean[][] status,int row,int column){
		if(!isValid(array,row,column))return;
		if(array[row][column]==9){
			res=true;
			return;
		}
		System.out.println(row+"--"+column);
		if(status[row][column]){
			status[row][column]=false;
			canPass(array,status,row,column+1);
			canPass(array,status,row+1,column);
			canPass(array,status,row,column-1);
			canPass(array,status,row-1,column);
			status[row][column]=true;
		}
		
	}
	public static boolean isValid(int[][] array, int row,int column){
		if(row>=0&&row<array.length&&column>=0&&column<array[0].length&&array[row][column]!=0){
			return true;
		}
		return false;
	}
	public static int bfs(int[][] matrix, Point start, Point end){
		//check whether source and destination have value 1
		if(matrix[start.row][start.col]!=1||matrix[start.row][start.col]!=1){
			return -1;
		}
		int m  = matrix.length, n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(start);
		int level = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				Point p = queue.poll();
				if(p.row==end.row&&p.col==end.col){
					return level;
				}
				visited[p.row][p.col] = true;
				if(isValid1(matrix,p.row-1,p.col,visited)){//left	
					queue.offer(new Point(p.row-1,p.col));
					System.out.println(p.row-1+":"+p.col);
				}
				if(isValid1(matrix,p.row+1,p.col,visited)){//right
					queue.offer(new Point(p.row+1,p.col));
					System.out.println(p.row+1+":"+p.col);
				}
				if(isValid1(matrix,p.row,p.col-1,visited)){//up
					queue.offer(new Point(p.row,p.col-1));
					System.out.println(p.row-1+":"+p.col);
				}
				if(isValid1(matrix,p.row,p.col+1,visited)){//down
					queue.offer(new Point(p.row,p.col+1));
				}
				level++;
			}
		}
		return -1;
	}
	public static  boolean isValid1(int[][] array, int row,int column, boolean[][] visited){
		if(row>=0&&row<array.length&&column>=0&&column<array[0].length&&array[row][column]!=0&&!visited[row][column]){
			return true;
		}
		return false;
	}
	static class Point{
		int row;
		int col;
		public Point(int row,int col){
			this.row=row;
			this.col=col;
		}
	}

}
