package microSoftOA;

public class CountNegativeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{-3, -2, -1,  1},
						{-2,  2,  3,  4},
						{4,   5,  7,  8}};
		CountNegativeNumbers c = new CountNegativeNumbers();
		System.out.println(c.countNegative(matrix));
	}
	public int countNegative(int[][] matrix){
		int count=0;
		int i=0,j=matrix[0].length-1;//start from right top corner
		while(i<matrix.length&&j>=0){
			if(matrix[i][j]<0){
				count+= j+1;//for row i, position j is negative, 0 - j are all negative
				i++;
			}else{
				j--;
			}
		}
		return count;
	}

}
