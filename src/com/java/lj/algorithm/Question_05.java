package com.java.lj.algorithm;

import java.util.Stack;

import com.java.lj.structure.linked.Node;

/**
 * 面试题5
 */
public class Question_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 题目：
	 * 输入一个链表的头结点，从尾到头反向打印出每个结点的值
	 */
	
	/**
	 * 方式一：
	 * 用栈实现。从头到尾遍历链表，将结点放入栈中。遍历完后，从栈顶开始逐个输出结点的值。
	 */
	public static void printListReversingly_Iteratively(Node<String> node) {
		
		Stack<Node<String>> nodes = new Stack<>();
		
		Node<String> tempNode = node;
		while(tempNode != null) {
			nodes.push(tempNode);
			tempNode = tempNode.next;
		}
		
		while(!nodes.empty()) {
			System.out.println(nodes.pop().data);
		}
	}
	
	/**
	 * 方式二：
	 * 递归(递归在本质上就是一个栈结构)
	 */
	public static void printListReversingly_Recursively(Node<String> node) {
		if (node != null) {
			if (node.next != null) {
				printListReversingly_Recursively(node.next);
			}
			System.out.println(node.data);
		}
	}
	
}
