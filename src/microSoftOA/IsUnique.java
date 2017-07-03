package microSoftOA;

public class IsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//time O(N) n is length of s
	//space O(1) because for loop will never iterate through more than 128 characters
	public boolean isUnique(String s){
		//assume there is only the character set is ASCII
		//create an array of boolean values, where the flag at index i 
		//indicates whether character i in the alphabet is contained in the string
		boolean[] char_set = new boolean[128];
		for(int i=0;i<s.length();i++){
			if(char_set[s.charAt(i)]){
				//this is the second time I see this character
				//return false immediately
				return false;
			}
			char_set[s.charAt(i)]=true;
		}
		return true;
	}
	//space efficient by using bit vector
	public boolean isUnique1(String s){
		int checker = 0;
		for(int i=0;i<s.length();i++){
			int val = s.charAt(i)-'a';
			//check the bit value at index val
			//here we use a trick to test a bit at specific position
			if((checker&(1<<val))==1){
				return false;
			}
			//ok, that bit is 0, set that bit
			//here we use another trick to set a bit
			checker|= (1<<val);//inclusive or
		}
		return true;
	}

}

