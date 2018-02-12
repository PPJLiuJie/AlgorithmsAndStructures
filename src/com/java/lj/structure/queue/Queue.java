package com.java.lj.structure.queue;

/**
 * 数据结构:队列(先进先出)
 */
public class Queue {

	private int maxSize;
	private long[] queArray;
	private int front;// 队头指针
	private int rear;// 队尾指针
	private int nItems;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j) {
		
		
		
	}
	
}
