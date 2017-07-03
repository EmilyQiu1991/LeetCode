package easy;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2},{3,4}};
		RotateImage a= new RotateImage();
		a.rotate(matrix);
	}
	public void rotate(int[][] matrix) {
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
