package com.duke.queue;

public class Queue {

	private int front;
	private int rear;
	private int capacity;
	private int[] bucket;

	Queue(int size) {
		this.capacity = size;
		front = -1;
		rear = -1;
		this.bucket = new int[size];
	}

	//
	private boolean isFull() {
		if (rear == capacity - 1) {
			return true;
		} else if (rear == -1 || front < rear) {
			return false;
		}
		return true;
	}

	public void enqueue(int data) {
		System.out.println("Enqueue: " + data);
		if (!isFull()) {
			rear = (rear + 1) % capacity;
			bucket[rear] = data;
		} else
			System.out.println("Stack Overflow..");
	}

	public void dequeue() {
		if (rear > front) {
			front = (front + 1) % capacity;
			System.out.println("Dequeue: " + bucket[front]);
		} else {
			System.out.println("Stack Empty..");
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(10);
//		q.enqueue(20);
//		q.enqueue(30);
//		q.enqueue(40);
//		q.enqueue(50);
//		q.enqueue(60);
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
		q.dequeue();
		q.dequeue();

	}

}
