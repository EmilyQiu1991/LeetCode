package microSoftOA;
import java.util.*;
public class MostKFrequentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,2,2,3};
		MostKFrequentElement m = new MostKFrequentElement();
		m.topKFrequent(arr, 2);
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        //create an empty min heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(k,(a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	//note  here add to heap firstly and then check size
        	heap.offer(entry);
        	//only keep  k largest entry
        	if(heap.size()>k){
        		heap.poll();
        	}
        }
        for(Map.Entry<Integer, Integer> entry: heap){
        	res.add(entry.getKey());
        	System.out.println(entry.getKey());
        }
        return res;
        
       
    }
	

}
