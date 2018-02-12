package com.java.lj.structure.stack;

/**
 * 栈接口
 */
public interface Stack<T> {

	/**
	 * 压栈
	 */
	void push(T t);

	/**
	 * 出栈，返回栈顶元素，同时从栈中删除该元素
	 */
	T pop();

	/**
	 * 返回栈顶元素
	 */
	T peek();
	
	/**
	 * 栈是否为空
	 */
	boolean isEmpty();
}
