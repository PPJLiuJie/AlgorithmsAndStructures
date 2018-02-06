package com.java.lj.algorithm;

/**
 * 面试题9
 */
public class Question_9 {

	public static void main(String[] args) {
		MyPrintln.start("fibonacci");
		
		long time_1 = System.currentTimeMillis();
		fibonacci(40);
		long time_2 = System.currentTimeMillis();
				
		System.out.println("耗时:" + (time_2 - time_1) + "毫秒");
		
		fibonacciPlus(40);
		long time_3 = System.currentTimeMillis();
		
		System.out.println("耗时:" + (time_3 - time_2) + "毫秒");
		
		
		MyPrintln.end("fibonacci");
	}

	
	/**
	 * 斐波那契数列:f(0) = 0,f(1) = 1,f(n) = f(n-1) + f(n-2)<br>
	 * 求第n项的值
	 */
	public static long fibonacci(long n) {
		
		if (n <=0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	/**
	 * 改良版
	 */
	public static long fibonacciPlus(long n) {
		
		if (n <=0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}
	
}
