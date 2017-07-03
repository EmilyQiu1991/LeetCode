package easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-13200));
	}
    public int reverse(int x) {
        long res = 0; 
        while(x!=0){
        	System.out.println(x%10);
            res =res*10+ x%10;
            x= x/10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}
