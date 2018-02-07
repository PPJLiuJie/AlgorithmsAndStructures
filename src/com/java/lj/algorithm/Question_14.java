package com.java.lj.algorithm;

/**
 * 面试题14
 */
public class Question_14 {

	public static void main(String[] args) {

		int[] arr = {4,58,56,23,44,85,69,88};
		
		MyPrintln.start("arrange_1");
		arrange_1(arr);
		MyPrintln.end("arrange_1");
		
		MyPrintln.start("arrange_2");
		arrange_2(arr);
		MyPrintln.end("arrange_2");
	}

	/**
	 * 题目:
	 * 输入一个整数数组，实现一个函数来调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
	 */
	
	
	/**
	 * 第一种方式<br>
	 * 如果不考虑时间的复杂度，从头扫描这个数组，每碰到一个偶数，拿出这个数字，并把这个数字后面的所有数字往前挪一位。
	 * 挪完之后在数组的末尾有一个空位，这时把该偶数放入这个空位。
	 */
	public static void arrange_1(int[] arr) {
		// 数组的长度
		int len = arr.length;
		// 下标
		int start = 0;
		int end = len - 1;
		
		/**
		 * count表示while循环的次数
		 * 每循环一次，表示处理了一个元素
		 */
		int count = len;
		
		while(count > 0) {
			if (arr[start] %2 == 0) {
				int temp = arr[start];
				for (int i = 0; i < len - start - 1; i++) {
					arr[start + i] = arr[start + 1 + i];
				}
				arr[end] = temp;
			} else {
				start++;
			}
			count--;
		}
		System.out.println(intArrToStr(arr));
	}
	
	/**
	 * 第二种方式<br>
	 */
	public static void arrange_2(int[] arr) {
		
		int len = arr.length;
		int start = 0;
		int end = len -1;
		
		for (int i = start; i <= end; i++) {
			// 如果start对应的元素为偶数，且end对应的元素为奇数，则互换位置
			if (arr[start] %2 == 0 && arr[end] %2 != 0) {
				swap(arr, start, end);
				start++;
				end--;
			} 
			// 如果start对应的元素为奇数，则start指向其后一个元素
			else if (arr[start] %2 != 0) {
				start++;
			} 
			// 如果end对应的元素为偶数，则end指向其前一个元素
			else if (arr[end] %2 == 0) {
				end--;
			}
		}
		System.out.println(intArrToStr(arr));
	}
	
	private static void swap(int[] arr, int j, int k) {
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
	
	/**
	 * int类型的数组，转成字符串表示
	 */
	private static String intArrToStr(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i != arr.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
