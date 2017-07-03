package easy;

public class SetZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix ={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		int[][] matrix={{0}};
		SetZeros a = new SetZeros();
		a.setZeroes(matrix);
	}
	public void setZeroes(int[][] matrix) {
		boolean zerorow = false,zerocol=false;
		int row= matrix.length;
		int col = matrix[0].length;
		for(int i=0;i<col;i++){
			if(matrix[0][i]==0)
				zerorow=true;
		}
		for(int i=0;i<row;i++){
			if(matrix[i][0]==0){
				zerocol=true;
			}
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(matrix[i][0]==0||matrix[0][j]==0){
					matrix[i][j]=0;
				}
			}
		}
		if(zerorow){
			for(int i=0;i<col;i++){
				matrix[0][i]=0;
					
			}
		}
		if(zerocol){
			for(int i=0;i<row;i++){
				matrix[i][0]=0;
			}
		}
    }
}
