package algorithm;

import java.util.ArrayList;

/**
 * @author qiuyu
 *This class implements a HashTable, use a array of LinkedList to deal with collision(chaining)
 */
public class MyHashMap<K,V> {
	private static class LinkedListNode<K,V>{
		public LinkedListNode<K,V> next;
		public LinkedListNode<K,V> prev;
		public K key;
		public V value;
		public LinkedListNode(K k,V v){
			key=k;
			value=v;
		}
	}
	private ArrayList<LinkedListNode<K,V>> arr;

	public MyHashMap(int capacity){
		 arr = new ArrayList<LinkedListNode<K, V>>();
		 arr.ensureCapacity(capacity);//  Optional optimization
		 for (int i = 8; i < capacity; i++) {
		arr.add(null);
		 }
	}
}
