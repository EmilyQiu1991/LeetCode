package hard;

import java.util.*;

/**
 * this data structure add node only to start
 * remove node from tail
 */
public class LRUCache {
	private int capacity;
	private int size;
	private Map<Integer, DLinkedNode> cache;
	private DLinkedNode head, tail;
	private class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
		private DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, DLinkedNode>();
		head = new DLinkedNode(0, 0);
		tail = new DLinkedNode(0, 0);

		head.post = tail;
		tail.pre = head;
	}
	public int get(int key) {
		if (cache.containsKey(key)) {
			DLinkedNode node = cache.get(key);
			moveToHead(node);
			return node.value;
		}
		return -1;
	}
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node==null) {
			// create a new node
			DLinkedNode newNode = new DLinkedNode(key, value);
			// put into cache
			// put to cache and put into list
			cache.put(key, newNode);
			addNodeToHead(newNode);
			size++;
			// if cache is full, reach to its capacity
			if (size > capacity) {
				DLinkedNode deletedNode = tail.pre;
				removeNode(deletedNode); // remove from list
				cache.remove(deletedNode.key);// remove from cache
				size--;// size decrease by 1
			}
			
			
		}else{
			node.value=value;
			moveToHead(node);
		}
	}

	private void moveToHead(DLinkedNode existedNode) {
		removeNode(existedNode);
		addNodeToHead(existedNode);
	}

	public void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		pre.post = node.post;
		post.pre = pre;
	}

   /**
 * @param node 
 */
public void addNodeToHead(DLinkedNode node) {
		DLinkedNode post = head.post;
		head.post = node;
		node.post = post;
		post.pre = node;
		node.pre = head;
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println("cache.get(1):" + cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println("cache.get(2):" + cache.get(2)); // returns -1 (not
															// found)
		cache.put(4, 4); // evicts key 1
		System.out.println("cache.get(1):" + cache.get(1)); // returns -1 (not
															// found)
		System.out.println("cache.get(3):" + cache.get(3)); // returns 3
		System.out.println("cache.get(4):" + cache.get(4)); // returns 4

	}

}
