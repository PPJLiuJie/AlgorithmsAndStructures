package com.java.lj.algorithm;

/**
 * 面试题3
 */
public class Question_3 {

	public static void main(String[] args) {
		
		MyPrintln.start("arrayFind");
		
		/**
		 二维数组，该二维数组中从左至右递增，从上至下递增。
		设计一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
		 
		 1	2	8	9
		 2	4	9	12
		 4	7	10	13
		 6	8	11	15
		 
		 */
		
		int[][] arr = new int[4][4];
		
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 8;
		arr[0][3] = 9;
		
		arr[1][0] = 2;
		arr[1][1] = 4;
		arr[1][2] = 9;
		arr[1][3] = 12;
		
		arr[2][0] = 4;
		arr[2][1] = 7;
		arr[2][2] = 10;
		arr[2][3] = 13;
		
		arr[3][0] = 6;
		arr[3][1] = 8;
		arr[3][2] = 11;
		arr[3][3] = 15;
		
		boolean result = arrayFind(arr, 4, 4, 7);
		
		System.out.println(result);
		
		MyPrintln.end("arrayFind");
	}

	public static boolean arrayFind(int[][] arr, int rows, int columns, int num) {

		boolean result = false;

		// 查找的次数
		int findTimes = 0;

		// 右上角数字对应的行和列
		int currRow = 0;
		int currLolumn = columns - 1;

		if (arr != null && rows > 0 && columns > 0) {
			while (currRow < rows && currLolumn >= 0) {
				++findTimes;
				int rtNum = arr[currRow][currLolumn];
				if (rtNum == num) {
					result = true;
					break;
				} else if (rtNum > num) {
					--currLolumn;
				} else {
					++currRow;
				}
			}
		}

		System.out.println("查找的次数:" + findTimes);
		return result;
	}

}
