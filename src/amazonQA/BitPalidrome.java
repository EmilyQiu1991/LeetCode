package amazonQA;

public class BitPalidrome {

	public static void main(String[] args) {
		BitPalidrome b  = new BitPalidrome();
		System.out.println(b.isPalindrome(0));//true 0
		System.out.println(b.isPalindrome(9));//true 1001
		System.out.println(b.isPalindrome2(10));//false 1010

	}
	public int isPalindrome(int i){
		String s = Integer.toBinaryString(i);
		int start = 0, end = s.length()-1;
		while(start < end){
			if(s.charAt(start)!=s.charAt(end)){
				return 0;
			}
			start ++;
			end --;
		}
		return 1;
	}
	public boolean isPalindrome2(int n)
	{
		for(int i=0;i<16;i++){
			if((n>>i)!=(n>>(31-i))) 
					return false;
		}
		return true;
	}
}
