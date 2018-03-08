package com.java.lj.algorithm;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 */
public class Question_07 {

	public static void main(String[] args) {
		
		MyQueue<String> queue = new MyQueue<String>();
		
		queue.appendTail("a");
		queue.appendTail("b");
		queue.appendTail("c");
		queue.appendTail("d");
		queue.appendTail("e");
		
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			System.out.println(queue.deleteHead());
		}
		
		queue.appendTail("f");
		queue.appendTail("g");
		queue.appendTail("h");
		queue.appendTail("i");
		queue.appendTail("j");
		
		size = queue.size();
		for (int i = 0; i < size; i++) {
			System.out.println(queue.deleteHead());
		}
	}

	/**
	 * 题目：
	 * 用两个栈实现一个队列。
	 * 请实现队列的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
	 */
	
}

class MyQueue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void appendTail(T t) {
		stack1.push(t);
	}
	
	public int size() {
		return stack1.size() + stack2.size();
	}
	
	public T deleteHead() {
		
		if (stack2.size() <= 0) {
			while (stack1.size() > 0) {
				stack2.push(stack1.pop());
			}
		}
		
		if (stack2.size() == 0) {
			throw new RuntimeException("the queue is empty");
		}
		
		return stack2.pop();
	}
}
