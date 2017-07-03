package medium;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Solution
{ 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
	public String[] largestItemAssociation(String[][] itemAssociation)
	{
		// WRITE YOUR CODE HERE
		if(itemAssociation==null||itemAssociation.length==0||itemAssociation[0].length==0){
		    return new String[0];
		}
		Set<String> allBook = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		
		Map<String,Set<String>> map = new HashMap<String,Set<String>>();
		
		for(String[] pair : itemAssociation){
		    allBook.add(pair[0]);
		    allBook.add(pair[1]);
		    if(!map.containsKey(pair[0])){
		        map.put(pair[0],new HashSet<String>());
		    }
		    map.get(pair[0]).add(pair[1]);
		    if(!map.containsKey(pair[1])){
		        map.put(pair[1],new HashSet<String>());
		    }
		    map.get(pair[1]).add(pair[0]);
		}
     int size = 0;
     List<List<String>> wrapList = new ArrayList<List<String>>();
     for(String book: allBook){
         if(!visited.contains(book)){
             List<String> list = new ArrayList<String>();
             list.add(book);
             Collections.sort(list);
             bfs(map, visited,book,list);
             wrapList.add(list);
		    }
		}
		Collections.sort(wrapList,(a,b)->b.size()-a.size());
		String[] res = new String[wrapList.get(0).size()];
		for(int i=0;i<res.length;i++){
		    res[i] = wrapList.get(0).get(i);
		}
		
		return res;
	}
	// METHOD SIGNATURE ENDS
	private void bfs(Map<String,Set<String>> map, Set<String> visited, String book, List<String> list){
	    Queue<String> queue = new LinkedList<String>();
	    queue.offer(book);
	    visited.add(book);
	    while(!queue.isEmpty()){
	        int size = queue.size();
	        for(int i=0;i<size;i++){
	            String b = queue.poll();
	            if(!list.contains(b))
	                list.add(b);
	            for(String neighbor : map.get(b)){
	                if(!visited.contains(neighbor)){
	                    queue.offer(neighbor);
	                    visited.add(neighbor);
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		String[][] str = {{"item1","item2"},{"item4","item3"},{"item5","item4"}};
		Solution s = new Solution();
		s.largestItemAssociation(str);
 		
	}
}