package amazonQA;

public class RotateMatrix {
	public static int[][] rotate1(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] right = new int[cols][rows];
		int[][] left = new int[cols][rows];
		if (flag == 1) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					right[j][rows - 1 - i] = matrix[i][j];
				}
			}
			return right;
		} else if (flag == 0) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					left[cols - 1 - j][i] = matrix[i][j];
				}
			}
			return left;
		}
		return null;
	}

	public static void printMatrix(int[][] test) {
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print(" " + test[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] test = { { 1, 2, 3, 4, 5 }, 
						 { 6, 7, 8, 9, 10 }, 
						 { 11, 12, 13, 14, 15 } };
		printMatrix(rotate1(test, 1));
	}
	public static void rotate(int[][] matrix,int flag) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0) return;
        //reverse up down 
        int a=0,b=matrix.length-1;
        while(a<b){
            for(int i=0;i<matrix.length;i++){
                int temp = matrix[a][i];
                 matrix[a][i]=matrix[b][i];
                 matrix[b][i]=temp;
            }
            a++;
            b--;
        }
        //swap symmtry left bottom to right top
        for(int i=0;i<matrix.length;i++){
           for( int j=i+1;j<matrix[i].length;j++){
               int temp = matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
           }
        }
    }

}
