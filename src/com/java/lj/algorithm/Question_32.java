package com.java.lj.algorithm;

/**
 * 面试题32
 */
public class Question_32 {

	public static void main(String[] args) {
		
		MyPrintln.start("getNumberOf1Between1AndN_1");
		System.out.println(getNumberOf1Between1AndN_1(10));// 2
		System.out.println(getNumberOf1Between1AndN_1(100));// 21
		System.out.println(getNumberOf1Between1AndN_1(1000));// 301
		System.out.println(getNumberOf1Between1AndN_1(10000));// 4001
		System.out.println(getNumberOf1Between1AndN_1(100000));// 50001
		System.out.println(getNumberOf1Between1AndN_1(1000000));// 600001
		MyPrintln.end("getNumberOf1Between1AndN_1");
		
	}
	
	
	/**
	 * 题目:
	 * 输入一个整数n，求从1到n这个n个整数的十进制表示中1出现的次数
	 * 例如输入12，从1到12这些整数中包含1的数字有1,10,11,12，这4个数字中1一共出现了5次
	 */
	
	
	/**
	 * 解法一:<br>
	 * 分别求出每个数的十进制表示中1出现的次数
	 */
	public static int getNumberOf1Between1AndN_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += getNumberOf1(i);
		}
		return count;
	}
	
	public static int getNumberOf1Between1AndN_2(int n) {
		
		// TODO ...
		
		return 0;
	}
	
	/**
	 * 求n的十进制表示中1出现的个数
	 */
	private static int getNumberOf1(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 1) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
	
}
