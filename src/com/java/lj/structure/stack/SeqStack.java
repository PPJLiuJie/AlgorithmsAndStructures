package com.java.lj.structure.stack;

import java.io.Serializable;

/**
 * 顺序栈
 */
@SuppressWarnings("unchecked")
public class SeqStack<T> implements Stack<T> , Serializable{

	private static final long serialVersionUID = 3332843168829583975L;

	/**
	 * 栈顶指针
	 */
	private int top = -1;
	
	/**
	 * 栈的容量大小默认为10
	 */
	private int capacity = 10;
	
	/**
	 * 存放元素的数组
	 */
	private T[] array;
	
	private int size;
	
	public SeqStack() {
		array = (T[]) new Object[this.capacity];
	}
	public SeqStack(int capacity) {
		array = (T[]) new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public void push(T t) {
		// 容量不足
		if (array.length == size) {
			// 扩容
			ensureCapacity(size * 2 + 1);
		}
		array[++top] = t;
		size++;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Empty");
		}
		size--;
		return array[top--];
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Empty");
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	/**
	 * 扩容
	 */
	public void ensureCapacity(int capacity) {
		if (capacity < size) {
			return;
		}
		
		T[] old = array;
		array = (T[]) new Object[capacity];
		
		// 复制元素
		for(int i = 0; i < old.length; i++) {
			array[i] = old[i];
		}
	}
	
	public static void main(String[] args) {
		SeqStack<String> seqStack = new SeqStack<>();
		seqStack.push("A");
		seqStack.push("B");
		seqStack.push("C");
		
		int s = seqStack.size;
		
		for (int i = 0; i < s; i++) {
			System.out.println("seqStack.pop->" + seqStack.pop());
		}
		
//		System.out.println("seqStack.peek->" +  seqStack.peek());
	}
}
