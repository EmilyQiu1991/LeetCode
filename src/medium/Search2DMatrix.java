package medium;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix,3));

	}
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int rowCount=matrix.length;
        int colCount=matrix[0].length;
        int[] newArray=new int[rowCount*colCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                newArray[i*colCount+j]=matrix[i][j];
            }
        }
        int l=0,r=newArray.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(newArray[mid]==target){
                return true;
            }else if(newArray[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }

}
