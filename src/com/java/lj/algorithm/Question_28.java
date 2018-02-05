package com.java.lj.algorithm;

/**
 * 面试题28
 */
public class Question_28 {

	public static void main(String[] args) {
		
		char[] ch = "abcd".toCharArray();
		permutation(ch, 0, ch.length - 1);
	}


	/**
	 * 一、字符串的排列组合(条件:长度变，不能有重复字符)
	 */
	public static void permutation(char[] ch, int from, int to) {
		// 空数组不处理
		if (to < 0) {
			return;
		}
		// 只有一个元素的数组直接打印
		if (to == 0) {
			System.out.println(ch);
			return;
		}
		
		/**
		 * 为什么在"from == to"的时候才打印？
		 * 这是一个难点，参考:https://segmentfault.com/a/1190000002710424
		 * 这个链接对应的网页中有个示意图
		 */
		if (from == to) {
			System.out.println(ch);
		} else {
			for (int i = from; i <= to; i++) {
				swap(ch, from, i);
				permutation(ch, from + 1, to);
				swap(ch, i, from);
			}
		}
	}
	
	/**
	 * 二、字符串排列组合
	 * 长度无限制，ab和ba为同一种组合，abc、acb、bac、bca、cab、cba为同一种组合
	 */
	public static void Combination(char[] ch) {
		
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
