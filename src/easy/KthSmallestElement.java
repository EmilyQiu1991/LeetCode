package easy;

import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		int[][] matrix = {
				  { 1,  5,  9},
		          {2, 6, 10},
		          {7, 11, 15}};
		    int k = 5;
		    System.out.println(kthSmallest2(matrix,k));
	}
	 public static int kthSmallest(int[][] matrix, int k) {
	        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	        for(int row=0;row<matrix.length;row++){
	        	for(int col=0;col<matrix[0].length;col++){
	        		heap.offer(matrix[row][col]);
	        	}
	        }
	        int result=0;
	        for(int i =1;i<=k;i++){
	        	result=heap.poll();
	        }
	        return result;
	 }
	 public static int kthSmallest2(int[][] matrix, int k) {
	        int n = matrix.length;
	        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
	        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
	        for(int i = 0; i < k-1; i++) {
	            Tuple t = pq.poll();
	            System.out.println("poll Tuple x: "+t.x+"; y:"+t.y);
	            if(t.x == n-1) continue;
	            
	            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
	            System.out.println("offer Tuple x: "+(t.x+1)+"; y:"+t.y);
	        }
	        return pq.poll().val;
	    }
	}

	class Tuple implements Comparable<Tuple> {
	    int x, y, val;
	    public Tuple (int x, int y, int val) {
	        this.x = x;
	        this.y = y;
	        this.val = val;
	    }
	    
	    @Override
	    public int compareTo (Tuple that) {
	        return this.val - that.val;
	    }
	

}
