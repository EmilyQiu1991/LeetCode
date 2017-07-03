package hard;
import java.util.*;
public class LFUCache {
	private int capacity;
	private int size;
	private Map<Integer, ItemFrequency> cache;
	
	private PriorityQueue<ItemFrequency> frequency;
	private class ItemFrequency implements Comparable<ItemFrequency>{
		int key;
		int value;
		int frequency;
		private ItemFrequency(int key,int frequency,int value){
			this.key=key;
			this.frequency=frequency;
			this.value=value;
		}
		
	

		@Override
		public int compareTo(ItemFrequency o) {
			// TODO Auto-generated method stub
			return this.frequency-o.frequency;
		}
		
	}
	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4

	}
	public LFUCache(int capacity){
		this.capacity=capacity;
		cache=new HashMap<Integer, ItemFrequency>();
		frequency= new PriorityQueue<ItemFrequency>();
	}

    public int get(int key) {
        if(cache.containsKey(key)){
        	//add frequency 1
        	updateFrequency(key);
        	return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
        	//update value, update frequency
        	ItemFrequency item= cache.get(key);
        	frequency.remove(item);
        	item.value=value;
        	item.frequency=item.frequency+1;
        	cache.put(key, item);
        	frequency.add(item);
        }else{
        	//add to cache map, ensure capacity, add frequency map
        	ItemFrequency newItem= new ItemFrequency(key,1,value);
        	cache.put(key, newItem);
        	size++;
        	//frequency.add(newItem); move this after if condition
        	//put is right now would be remove in if condition, because it have the least frequency 1
        	if(size>capacity){
        		
        		//remove from heap, remove from cache
        		ItemFrequency popedItem=frequency.poll();
        		if(popedItem!=null){
        		cache.remove(popedItem.key);
        		}else{
        			cache.clear();
        		}
        		size--;
        	}
        	frequency.add(newItem);
        }
    }
    private void updateFrequency(int key){
    	ItemFrequency item= cache.get(key);
    	frequency.remove(item);
    	item.frequency=item.frequency+1;
    	frequency.add(item);
    }

}
