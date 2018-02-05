package com.java.lj.algorithm;

/**
 * 面试题10
 */
public class Question_10 {

	public static void main(String[] args) {
		
		MyPrintln.start("getCountOf_1");
		System.out.println(getCountOf_1(0));
		System.out.println(getCountOf_1(127));
		// 注意：负数是以补码的形式存储的
		System.out.println(getCountOf_1(-128));
		MyPrintln.end("getCountOf_1");
		
		MyPrintln.start("judge");
		System.out.println(judge(-2));
		System.out.println(judge(-1));
		System.out.println(judge(0));
		System.out.println(judge(2));
		System.out.println(judge(4));
		System.out.println(judge(6));
		System.out.println(judge(8));
		System.out.println(judge(2048));
		MyPrintln.end("judge");
		
		MyPrintln.start("getCountOfChange");
		System.out.println(getCountOfChange(10, 13));
		System.out.println(getCountOfChange(0, 127));
		System.out.println(getCountOfChange(10, 127));
		MyPrintln.end("getCountOfChange");
	}
	
	/**
	 * 一、求整数的二进制表示中有多少个1
	 */
	public static int getCountOf_1(int n) {
		/**
		 * 应用了 n&(n-1)能将n的二进制表示中的最右边的1翻转为0的事实。
		 * 只需要不停地执行n&(n-1)，直到n变成0为止，那么翻转的次数就是原来n的二进制表示中1的个数
		 */
		int count = 0;
		while (n != 0) {
			count++;
			n &= n - 1;
		}
		return count;
	}
	
	/**
	 * 二、用一条语句判断一个整数是不是2的整数次方
	 */
	public static boolean judge(int n) {
		/**
		 * 一个整数如果是2的整数次方，那么他的二进制表示中有且只有一位是1，而其他位都是0
		 * 根据getCountOf_1()中的分析，把这个整数减去1之后再和它自己做与运算，这个整数中唯一的1就会变成0
		 */
		return (n & (n - 1)) == 0;
	}
	
	
	/**
	 * 三、输入两个整数m和n
	 * 计算需要改变m的二进制表示中的多少位才能得到n
	 * 比如10的二进制表示为1010，13的二进制表示为1101，需要改变1010中的3位才能得到1101
	 */
	public static int getCountOfChange(int n, int m) {
	
		/**
		 * 首先，求这两个数的异或，异或的规则就是：如果a和b两个值不同，则异或结果为1，如果a和b两个值结果相同，则异或值为0
		 * 然后统计异或结果中1的个数
		 */
		
		return getCountOf_1(n ^ m);
	}
}
