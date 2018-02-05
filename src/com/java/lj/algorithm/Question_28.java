package com.java.lj.algorithm;

/**
 * 面试题28
 */
public class Question_28 {

	public static void main(String[] args) {
		
		char[] ch = "abcde".toCharArray();
		
		MyPrintln.start("permutation");
		permutation(ch, 0, ch.length - 1);
		MyPrintln.end("permutation");
		
		MyPrintln.start("combination");
		combination(ch);
		MyPrintln.end("combination");
	}


	/**
	 * 一、字符的排列(条件:长度不变，不能有重复字符)
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
	 * 二、字符的组合
	 * 长度无限制，ab和ba为同一种组合，abc、acb、bac、bca、cab、cba为同一种组合
	 */
	public static void combination(char[] ch) {
		/*
		 1 1 1 1 1 1 1
		 g f e d c b a
		 
		 设数组的总长度为n，每一位的取值为0或1，则一共有(2^n-1)种取值
		 参考自:https://segmentfault.com/a/1190000002710424
		 */
		
		int len = ch.length;
		int n = (1<<len) - 1;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			
			// i转成二进制
			String binary_n = Integer.toBinaryString(i);
			
			// 二进制的字符串表现形式
			StringBuilder tempSb = new StringBuilder(binary_n);
			// 理解，为什么要反转字符串
			tempSb = tempSb.reverse();
			
			char[] tempCh = tempSb.toString().toCharArray();
			
			for(int k = 0; k < tempCh.length; k++) {
				if ('1' == tempCh[k]) {
					sb.append(ch[k]);
					System.out.print(ch[k]);
				}
			}
			
			System.out.println();
			
			// 清空
			sb.delete(0, sb.length());
		}
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
