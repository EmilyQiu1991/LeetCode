package easy;
import java.util.*;
public class SortCharByFre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCharByFre a = new SortCharByFre();
		System.out.println(a.frequencySort("tree"));
	}
	 public String frequencySort(String s) {
	       int maxCount=0;
	       Map<Character,Integer> map=new HashMap<Character,Integer>();
	       for(int i=0;i<s.length();i++){
	           char letter = s.charAt(i);
	           if(!map.containsKey(letter)){
	               map.put(letter,0);
	           }
	           map.put(letter,map.get(letter)+1);
	           if(map.get(letter)>maxCount){
	               maxCount=map.get(letter);
	           }
	       }
	       
	       //create an array of String
	       StringBuilder[] arr= new StringBuilder[maxCount+1];
	       for(int i=0;i<arr.length;i++){
	    	   arr[i]=new StringBuilder();
	       }
	       for(char c:map.keySet()){
	           int frequency = map.get(c);
	           StringBuilder str=arr[frequency];
	           for(int i=0;i<frequency;i++){
	               str.append(c);
	           }
	           arr[frequency] = str;
	       }
	       //build string
	       StringBuilder sb= new StringBuilder();
	       for(int i=arr.length-1;i>=0;i--){
	           sb.append(arr[i]);
	       }
	       return sb.toString();     
	    }

}
