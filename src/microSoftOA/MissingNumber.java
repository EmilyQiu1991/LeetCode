package microSoftOA;

/**
 * @author qiuyu
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * Given an array containing n distinct numbers taken from 1, 2, ..., n, n+1, find the one that is missing from the array.
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, 4,5,6};
		MissingNumber m = new MissingNumber();
		System.out.println(m.missNumber(arr));
		System.out.println(m.missNumber2(arr));
	}
	public int missNumber(int[] arr){
		if(arr==null||arr.length==0) return 1;
		for(int i=0;i<arr.length;i++){
			//put arr[i] at arr[i]-1
			if(arr[i]-1<arr.length && arr[i]!=i+1){
				swap(arr,i,arr[i]-1);
				i--;
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=i+1) 
				return i+1;
		}
		return arr[arr.length-1]+1;
	}
	public void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}
	public int missNumber2(int[] arr){
		int countNum = arr.length+1;
		int sum = 0;
		for(int a : arr){
			sum= sum+a;
		}
		return (1+countNum)*countNum/2 - sum;
	}
}
