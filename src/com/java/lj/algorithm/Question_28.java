package com.java.lj.algorithm;

/**
 * 面试题28
 */
public class Question_28 {

	public static void main(String[] args) {
		
		char[] ch = "abcd".toCharArray();
		
		MyPrintln.start("permutation");
		// 一、字符的排列
		PermutationOfChar.arrageOfChar(ch, 0, ch.length - 1);
		MyPrintln.end("permutation");
		
		MyPrintln.start("combination");
		// 二、字符的组合
		PermutationOfChar.combinationOfChar(ch);
		MyPrintln.end("combination");
	}


	/**
	 * 三、正方体顶点
	 */
	public static void cube() {
		
		// TODO ...
	}
	
	/**
	 * 四、国际象棋
	 */
	public static void chess() {
		
		// TODO ...
		
	}
	
	/**
	 * 字符数组的某两个元素互换位置
	 */
	public static void swap(char[] ch, int j, int k) {
		char temp = ch[j];
		ch[j] = ch[k];
		ch[k] = temp;
	}
}
