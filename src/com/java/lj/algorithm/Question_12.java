package com.java.lj.algorithm;

/**
 * 面试题12
 */
public class Question_12 {

	public static void main(String[] args) {
		
		MyPrintln.start("printOneToMaxOfNDigits_1");
		printOneToMaxOfNDigits_1(2);
		MyPrintln.end("printOneToMaxOfNDigits_1");
		
		MyPrintln.start("printOneToMaxOfNDigits_2");
		printOneToMaxOfNDigits_2(2);
		MyPrintln.end("printOneToMaxOfNDigits_2");
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
		
		for (int j = 1; j < num; j++) {
			System.out.println(j);
		}
		
	}
	
	/**
	 * 第二种方式
	 */
	public static void printOneToMaxOfNDigits_2(int n) {
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9'};
		char[] charResult = new char[n];
		permutation(charSet, charResult, charResult.length, 0);
	}
	
	/**
	 * @see PermutationOfChar#permutation(char[], char[], int, int)
	 */
	public static void permutation(char[] charSet, char[] charResult, int strLen, int index) {
		if (index == strLen) {
			printNum(charResult);
			return;
		}
		for (int j = 0; j < charSet.length; j++) {
			char temp = charResult[index];
			charResult[index] = charSet[j];
			permutation(charSet, charResult, strLen, index + 1);
			charResult[index] = temp;
		}
	}
	
	/**
	 * 打印字符数组表示的数字
	 * 比如{'0','5','2','0'}打印结果为:520，{'5','5','2','0'}打印结果为:5520
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
		// 如果字符数组的所有元素都是'0'，则无需打印
		if (canPrint) {
			System.out.println();
		}
	}
}
