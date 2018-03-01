package com.java.lj.structure.queue;

import java.io.Serializable;
import java.util.NoSuchElementException;

import com.java.lj.structure.linked.Node;

/**
 * 链式队列
 */
public class LinkedQueue<T> implements Queue<T>, Serializable {

	private static final long serialVersionUID = 8751600931705879080L;

	/**
	 * 队头和队尾元素
	 */
	private Node<T> front, rear;
	
	private int size;
	
	/**
	 * 用于控制最大容量，默认128，add方法使用
	 */
	private int maxSize = 128;
	
	public LinkedQueue() {
		front = rear = null;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	@Override
	public boolean isEmpty() {
		return (front == null && rear == null);
	}

	@Override
	public boolean add(T data) {
		if (data == null) {
			throw new NullPointerException("The data can not be null");
		}
		
		if (size >= maxSize) {
			throw new IllegalStateException("The capacity of LinkedQueue has reached its maximum");
		}
		
		Node<T> n = new Node<T>(data);
		if (front == null) {// 空队列插入
			front = n;
		} else {// 非空队列，尾部插入
			rear.next = n;
		}
		rear = n;
		size++;
		return true;
	}

	@Override
	public boolean offer(T data) {
		if (data == null) {
			throw new NullPointerException("The data can not be null");
		}
		
		Node<T> n = new Node<T>(data);
		if (front == null) {// 空队列插入
			front = n;
		} else {// 非空队列，尾部插入
			rear.next = n;
		}
		rear = n;
		size++;
		return true;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : front.data;
	}

	@Override
	public T element() {
		if (isEmpty()) {
			throw new NoSuchElementException("The LinkedQueue is empty");
		}
		return front.data;
	}

	@Override
	public T poll() {
		if (isEmpty()) {
			return null;
		}
		
		T t = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return t;
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("The LinkedQueue is empty");
		}
		
		T t = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return t;
	}

	@Override
	public void clearQueue() {
		this.front = null;
		this.rear = null;
		size = 0;
	}

}
