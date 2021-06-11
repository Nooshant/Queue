package com.duke.queue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	private static int CACHE_SIZE;
	private HashSet<Integer> hashSet;
	private java.util.Deque<Integer> doublyQueue;

	LRUCache(int size) {
		this.CACHE_SIZE = size;
		hashSet = new HashSet<Integer>(size);
		doublyQueue = new LinkedList<Integer>();
	}

	public void refer(int data) {

		if (!hashSet.contains(data)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int removed = doublyQueue.removeFirst();
				hashSet.remove(removed);
			}
		} else {
			doublyQueue.remove(data);
		}
		doublyQueue.add(data);
		hashSet.add(data);
	}

	public void display() {
		Iterator<Integer> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.refer(2);
		cache.refer(2);
		cache.refer(1);
		cache.display();
	}

}
