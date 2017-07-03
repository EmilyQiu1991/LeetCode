package easy;
import java.util.*;
public class PermutationInString {

	public static void main(String[] args) {
		PermutationInString p = new PermutationInString();
		p.checkInclusion("ab", "eidbaooo");
	}
	public boolean checkInclusion(String s1, String s2) {
        if(s1.length()==0||s2.length()==0||s1.length()>s2.length()){
            return false;
        }
        int[] map = new int[128];
        for(char c:s1.toCharArray()){
        	//or default value if there is no such a key
        	map[c]++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
        	int[] copy = map.clone();
        	int j=0;
        	for(j=0;j<s1.length();j++){
        		copy[s2.charAt(i+j)]--;
        		if(copy[s2.charAt(i+j)]<0){
        			break;
        		}
        		
        	}
        	if(j==s1.length()){
    			return true;
    		}
        }      
        return false;
    }
}