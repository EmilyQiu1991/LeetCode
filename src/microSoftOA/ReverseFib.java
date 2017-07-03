package microSoftOA;

public class ReverseFib {

	public static void main(String[] args) {
		ReverseFib r  = new ReverseFib();
		r.printReverse(21,13 );
	}
	public void printReverse(int a,int b){
		int next = a-b;
		while(next>0){
			System.out.println(next);
			a = b;
			b= next;
			next =  a-b;//f(n) = f(n-1)-f(n-2)
		}
	}
	

}
