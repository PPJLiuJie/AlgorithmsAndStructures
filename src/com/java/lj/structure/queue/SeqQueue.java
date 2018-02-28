package com.java.lj.structure.queue;

import java.io.Serializable;

/**
 * 顺序队列(采用循环列表实现)
 */
@SuppressWarnings("unchecked")
public class SeqQueue<T> implements Queue<T>, Serializable {

	private static final long serialVersionUID = 5735258911195438149L;

	private static final int DEFAULT_SIZE = 10;
	
	private T elementData[];
	/**
	 * front为队头元素的下标，rear则指向下一个入队元素的下标
	 */
	private int front, rear;
	private int size;
	
	public SeqQueue() {
		elementData = (T[]) new Object[DEFAULT_SIZE];
		front = 0;
		rear = 0;
	}
	
	public SeqQueue(int capacity) {
		elementData = (T[]) new Object[capacity];
		front = 0;
		rear = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public boolean add(T data) {
		
		
		
		return false;
	}

	@Override
	public boolean offer(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearQueue() {
		// TODO Auto-generated method stub

	}

}
