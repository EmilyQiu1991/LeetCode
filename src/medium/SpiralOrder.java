package medium;
import java.util.*;
public class SpiralOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		SpiralOrder s = new SpiralOrder();
		s.spiralOrder(matrix);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> re = new ArrayList<Integer>();
		helper(matrix,0,matrix.length-1,0,matrix[0].length-1,re);
		return re;
    }
    public void helper(int[][] matrix, int rs, int re, int cs, int ce, List<Integer> list){
        if(rs>re||cs>ce) return;
        // up row
        for(int i=cs;i<=ce;i++){
            list.add(matrix[rs][i]);
        }
        //right col
        for(int i=rs+1;i<re;i++){
            list.add(matrix[i][ce]);
        }
        //down row
        if(re>rs){
	        for(int i=ce;i>=cs;i--){
	            list.add(matrix[re][i]);
	        }
        }
        //left col
        if(ce>cs){
	        for(int i =re-1;i>rs;i-- ){
	            list.add(matrix[i][rs]);
	        }
        }
        helper(matrix,rs+1,re-1,cs+1,ce-1,list);
    }
	

}
