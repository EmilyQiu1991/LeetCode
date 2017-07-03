package easy;

public class FactoralTrailingZeros {

	public static void main(String[] args) {
		int n=6;
		
		int countOf2=0;
		int i=2;
		int countOfi = 0;
		while(i<=n){
			countOfi++;
			countOf2+=countOfi;
			i=i*2;
		}
		System.out.println(countOf2);
		
	}

}
