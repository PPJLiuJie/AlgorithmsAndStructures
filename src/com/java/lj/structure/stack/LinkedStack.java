package com.java.lj.structure.stack;

import java.io.Serializable;

import com.java.lj.structure.linked.Node;

/**
 * 链式栈
 */
public class LinkedStack<T> implements Stack<T>, Serializable {

	private static final long serialVersionUID = 6614019613801211449L;

	private Node<T> top;
	
	private int size;
	
	public LinkedStack() {
		this.top = new Node<>();
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public void push(T data) {
		if (data == null) {
			throw new StackException("data can not be null");
		}

		if (top == null) {
			top = new Node<>(data);
		} else if (top.data == null) {
			top.data = data;
		} else {
			Node<T> p = new Node<>(data, top);
			top = p;
		}
		size++;
	}

	@Override
	public T pop() {
		
		if (isEmpty()) {
			throw new EmptyStackException("Stack Empty");
		}
		
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack Empty");
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return (top == null || top.data == null);
	}

}
