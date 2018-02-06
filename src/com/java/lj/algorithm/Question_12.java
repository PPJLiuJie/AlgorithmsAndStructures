package com.java.lj.algorithm;

/**
 * 面试题12
 */
public class Question_12 {

	public static void main(String[] args) {
		printOneToMaxOfNDigits_1(2);
		
		char[] ch = {'0','1','3','0','0','5'};
		char[] ch1 = {'2','1','3','0','0','5'};
		char[] ch2 = {'4','1','3','0','5','0'};
		
		printNum(ch);
		printNum(ch1);
		printNum(ch2);
	}

	/**
	 * 输入数字n，按顺序打印出从1到最大的n为十进制数。
	 * 比如输入3，则打印出1、2、3、...、999
	 */
	
	
	/**
	 * 第一种方式(没有考虑大数据的问题)
	 */
	public static void printOneToMaxOfNDigits_1(int n) {
		
		int num = 1;
		int i = 0;
		while(i < n) {
			num *= 10;
			++i;
		}
		
		for (int j = 0; j < num; j++) {
			System.out.println(j);
		}
	}
	
	/**
	 * 第二种方式
	 */
	public static void printOneToMaxOfNDigits_2(int n) {
		char[] ztn = {'0','1','2','3','4','5','6','7','8','9'};
		char[] ch = new char[n];
		// 首先给数组的每个元素都赋值为'0'
		for (int i = 0; i < n; i++) {
			ch[i] = '0';
		}
		
	}
	
	/**
	 * 字符的全排列
	 */
	public static void allArrange(char[] ch, int length, int index) {
		
		
	}
	
	/**
	 * 打印字符数组表示的数字
	 */
	public static void printNum(char[] ch) {
		// 是否可以开始打印
		boolean canPrint = false;
		int len = ch.length;
		
		for (int i = 0; i < len; i++) {
			
			if (ch[i] == '0' && !canPrint) {
				continue;
			}
			
			canPrint = true;
			System.out.print(ch[i]);
		}
		System.out.println();
	}
}
