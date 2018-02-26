package com.java.lj.structure.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

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

		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (top == null || top.data == null);
	}

}
