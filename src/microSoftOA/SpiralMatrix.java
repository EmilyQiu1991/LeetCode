package microSoftOA;
import java.util.*;
public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix a = new SpiralMatrix();
		a.spiralOrder(new int[][]{{2,3}});
		a.generateMatrix(4);

	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix==null||matrix.length==0||matrix[0].length==0){
			return res;
		}
		int rowBegin = 0, rowEnd = matrix.length-1;
		int colBegin = 0, colEnd = matrix[0].length-1;
		while(rowBegin<=rowEnd && colBegin<=colEnd){
			//from left to right for loop colBegin to colEnd
			for(int i=colBegin;i<=colEnd;i++){
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			//from right top to right bottom for loop rowBegin to rowEnd
			for(int i=rowBegin;i<=rowEnd;i++){
				res.add(matrix[i][colEnd]);
			}
			colEnd --;
			if(rowBegin<=rowEnd){
				//down row for loop from colEnd to colBegin
				for(int i= colEnd; i>=colBegin;i--){
					res.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
		    if(colBegin<=colEnd){
				//left col for loop from rowEnd to rowBegin
				for(int i=rowEnd;i>=rowBegin;i--){
					res.add(matrix[i][colBegin]);
				}
		    }
			colBegin++;
		}
		return res;
	}
	public int[][] generateMatrix(int n){
		int[][] res = new int[n][n];
		int rowStart = 0, colStart = 0;
		int num = 1;
		/*	123
			894
			765*/
		int count = n;
		while(count>0){
			//special case ,if n ==1, below all 4 loop will not execute
			if(count==1){
				res[rowStart][colStart] = num;
			}
			// fill 1 2
			for(int i=colStart;i<n-1-colStart;i++){
				res[rowStart][i]=num++;
			}
			//fill 3,4
			for(int i=rowStart;i<n-1-rowStart;i++){
				res[i][n-1-colStart]=num++;
			}
			//fill 5,6
			for(int i=n-1-colStart;i>colStart;i--){
				res[n-1-rowStart][i]=num++;
			}
			//fill 7,8
			for(int i=n-1-rowStart;i>rowStart;i--){
				res[i][colStart]=num++;
			}
			rowStart++;
			colStart++;
			count=count-2;
		}
		
		return res;
	}
	public boolean isOneEditDistance(String s, String t) {
        for(int i=0;i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length()){
                    return s.substring(i+1,s.length()).equals(t.substring(i+1,t.length()));
                }else if(s.length()>t.length()){
                    return s.substring(i+1,s.length()).equals(t.substring(i,t.length()));
                }else{
                    return s.substring(i,s.length()).equals(t.substring(i+1,t.length()));
                }
            }
        }
         return Math.abs(s.length() - t.length()) == 1;      
    }
}
