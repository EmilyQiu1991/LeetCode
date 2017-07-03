package microSoftOA;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void MakeNumbersMatch(int a, int b, int x, int y)
	{ 
		while(a != x || b != y){ 
			if(a > x){ 
				a++;
			}else { 
				a--;
		    } 
			if(b > y){ 
				b++; 
			}else{ 
				b--;  
			}
		}
	}
}
