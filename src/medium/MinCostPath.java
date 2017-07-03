package medium;

import java.util.List;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost={{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(minCost(cost));
	}
	public static int minCost(int[][] cost){
		if(cost==null||cost.length==0||cost[0].length==0) return 0;
		int rowCount=cost.length;
		int colCount=cost[0].length;
		int[][] minCost=new int[rowCount][colCount];
		
		minCost[0][0]=cost[0][0];
		//set min cost for first row 
		for(int i=1;i<colCount;i++){
			minCost[0][i]=minCost[0][i-1]+cost[0][i];
		}
		//set min cost for first col
		for(int i=1;i<rowCount;i++){
			minCost[i][0]=minCost[i-1][0]+cost[i][0];
		}
		for(int i=1;i<rowCount;i++){
			for(int j=1;j<colCount;j++){
				minCost[i][j]=cost[i][j]+min(minCost[i-1][j],minCost[i][j-1],minCost[i-1][j-1]);
			}
		}
		return minCost[rowCount-1][colCount-1];
		//have populated minCostMatrix, than back tracking
	}
	public void getMinCostPath(int[][] minCost,int[][] cost,int row, int col, List<Integer> path){
		if(row<0||col<0) return; 
		if(row==0){
			while(col>=0){
				path.add(cost[row][col--]);
				return;
			}
		}
		if(col==0){
			while(row>=0){
				path.add(cost[row--][col]);
				return;
			}
		}
		path.add(cost[row][col]);
		//determin go left, go up, or go diagnal left up
		IndexPair min = getMinIndexPair(new IndexPair(row-1,col),new IndexPair(row,col-1),new IndexPair(row-1,col-1),minCost);
		getMinCostPath(minCost,cost,min.row,min.col,path);
	}
	public static int min(int x,int y,int z){
		return Math.min(x, Math.min(y, z));
	}
	public IndexPair getMinIndexPair(IndexPair pair1,IndexPair pair2,IndexPair pair3, int[][] minCost){
		IndexPair min=pair1;
		if(minCost[pair2.row][pair2.col]<minCost[min.row][min.col])
			min=pair2;
		if(minCost[pair3.row][pair3.col]<minCost[min.row][min.col])
			min=pair3;
		return min;
	}
	class IndexPair{
		int row;
		int col;
		IndexPair(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
}
