package com.java.lj.structure.queue;

import java.io.Serializable;
import java.util.NoSuchElementException;

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

		if (data == null) {
			throw new NullPointerException("The data can not be null");
		}

		// 队满，抛出异常
		if (isFull()) {
			throw new IllegalStateException("The capacity of SeqQueue has reached its maximum");
		}

		elementData[rear] = data;
		rear = (rear + 1) % elementData.length;
		size++;

		return true;
	}

	@Override
	public boolean offer(T data) {

		if (data == null) {
			throw new NullPointerException("The data can not be null");
		}

		// 队满，扩容
		if (isFull()) {
			ensureCapacity(elementData.length * 2 + 1);
		}

		elementData[rear] = data;
		rear = (rear + 1) % elementData.length;
		size++;

		return true;
	}

	@Override
	public T peek() {
		return elementData[front];
	}

	@Override
	public T element() {
		if (isEmpty()) {
			throw new NoSuchElementException("The SeqQueue is empty");
		}
		return peek();
	}

	@Override
	public T poll() {
		T temp = elementData[front];
		front = (front + 1) % elementData.length;
		size--;

		return temp;
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("The SeqQueue is empty");
		}
		return poll();
	}

	@Override
	public void clearQueue() {
		for (int i = front; i != rear; i = (i + 1) % elementData.length) {
			elementData[i] = null;
		}
		front = rear = 0;
		size = 0;
	}

	/**
	 * 扩容
	 * 
	 * @param capacity
	 *            扩容后的容量
	 */
	private void ensureCapacity(int capacity) {
		// 如果需要拓展的容量比现在数组的容量还小,则无需扩容
		if (capacity < size) {
			return;
		}

		T[] old = elementData;
		elementData = (T[]) new Object[capacity];
		int j = 0;
		// 复制元素
		for (int i = front; i != rear; i = (i + 1) % old.length) {
			elementData[j++] = old[i];
		}
		// 回复front、rear指向
		front = 0;
		rear = j;
	}

	/**
	 * 判断是否队满<br>
	 * 参考《大话数据结构》第4章——4.12 循环队列
	 */
	private boolean isFull() {
		return (front == (rear + 1) % elementData.length);
	}
}
