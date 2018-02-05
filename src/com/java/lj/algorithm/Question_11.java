package com.java.lj.algorithm;

/**
 * 面试题11
 */
public class Question_11 {

	public static void main(String[] args) {
		MyPrintln.start("power");
		System.out.println(power(0.0, 1));
		System.out.println(power(0.2, 3));
		System.out.println(power(2.0, 6));
		System.out.println(power(5, 3));
		MyPrintln.end("power");
	}

	
	/**
	 * 一、求某个数的整数次方
	 */
	public static double power(double base, int exponent) {
		
		// 0的0次方没有意义，0的负数次方也没有意义
		if (equals(base, 0.0) && exponent < 1) {
			throw new RuntimeException("输入错误");
		}
		
		double result = 0.0;
		
		if (exponent == 0) {
			result = 1.0;
		}
		
		if (exponent < 0) {
			result = 1.0 / powerWithPlus(base, Math.abs(exponent));
		}
		
		if (exponent > 0) {
			result = powerWithPlus(base, exponent);
		}
		
		return result;
	}
	
	public static double powerWithPlus(double base, int plus) {
		double result = 1.0;
		for (int i = 0; i < plus; i++) {
			result *= base;
		}
		return result;
	}
	
	public static boolean equals(double d1, double d2) {
		// double的精度可以保证十进制的15位运算，并不是小数点后15位，这里取小数点后7位
		if ((d1 - d2 < 0.0000001) && (d1 - d2 > -0.0000001)) {
			return true;
		}
		return false;
	}
}
