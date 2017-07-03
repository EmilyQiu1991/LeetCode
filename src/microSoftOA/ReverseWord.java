package microSoftOA;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeWord("b big ball is running");
	}

	
	public static void removeWord(String s){
		//a big ball is running
		int i=0;
		while(s.charAt(i)=='b'){
			int j= i;
			while(j<s.length()&&s.charAt(j)!=' '){
				j++;
			}
			s = s.substring(j+1,s.length());
		}
		for(i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				if(s.charAt(i+1)=='b'){
					int j= i+1; // j is point b in big
					while(j<s.length()&&s.charAt(j)!=' '){
						j++;
					}
					//"a"+" ball is running"
					s= s.substring(0, i)+s.substring(j,s.length());
					//i is a 
					i=i-1;
				}
			}
		}
		System.out.println(s);
	}

}
