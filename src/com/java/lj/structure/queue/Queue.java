package com.java.lj.structure.queue;

/**
 * 队列接口
 */
public interface Queue<T> {

	/**
	 * 返回队列长度
	 */
	int size();

	/**
	 * 判断队列是否为空
	 */
	boolean isEmpty();

	/**
	 * 入列，成功返回true，失败返回false
	 */
	boolean add(T data);
	
	/**
	 * 如果可能，将指定的元素插入此队列。<br>
	 * 使用可能有插入限制（例如容量限定）的队列时，offer方法通常要优于add方法，因为后者只能通过抛出异常使插入元素失败。
	 */
	boolean offer(T data);
	
	/**
	 * 返回队头元素，不执行删除操作，若队列为空，返回null
	 */
	T peek();
	
	/**
	 * 返回队头元素，不执行删除操作，若队列为空，抛出异常:NoSuchElementException
	 */
	T element();
	
	/**
	 * 出队，执行删除操作，返回队头元素，若队列为空，返回null
	 */
	T poll();
	
	/**
	 * 出队，执行删除操作，若队列为空，抛出异常:NoSuchElementException
	 */
	T remove();
	
	/**
	 * 清空队列
	 */
	void clearQueue();
}
