package com.java.lj.algorithm;

/**
 * 排序
 */
public class Arrange {

	public static void main(String[] args) {
		
		int[] arr = {77,99,44,55,22,88,11,66,33};
//		bubbleSort(arr);
//		selectionSort(arr);
		insertSort(arr);
		System.out.println(intArrToStr(arr));
	}

	/**
	 * 冒泡排序(数组长度为len)<br>
	 * 
	 * 第一轮:<br>
	 * 1.比较arr[0]和arr[1]两个元素<br>
	 * 2.如果arr[0]大于arr[1]，则两个元素交换位置<br>
	 * 3.向右移动一个位置，继续比较arr[1]和arr[2]<br>
	 * 4.当移动至倒数第二个位置，比较arr[len-2]和arr[len-1]，第一轮结束，此时arr[len-1]就是数组中最大的数<br>
	 * 第二轮:<br>
	 * 1.从头开始比较arr[0]和arr[1],...,当移动至倒数第三个位置，比较arr[len-3]和arr[len-2]，第二轮结束，此时arr[len-2]就是数组中第二大的数<br>
	 * ....<br>
	 * ....<br>
	 * <br>
	 * (n-1) + (n-2) + (n-3) + ... + 1  约等于  1/2(n^2)
	 * 时间复杂度为O(n^2)
	 */
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 选择排序(数组长度为len)<br>
	 * 
	 * 用一个临时变量minIndex存储最小值的下标<br>
	 * 1.从arr[0]至arr[len-1]遍历数组，比较arr[minIndex]和arr[j]的值(j的取值范围为[0,len-1])<br>
	 * 2.如果arr[minIndex]>arr[i]，则minIndex=i<br>
	 * 3.第一轮遍历结束后，交换arr[0]和arr[minIndex]的位置，此时arr[0]就是数组中的最小值<br>
	 * 
	 * 4.同理，从arr[1]至arr[len-1]遍历数组，第二轮遍历结束后，arr[1]就是数组中的第二小的值<br>
	 * ...
	 * ...
	 * 时间复杂度为O(n^2)，但是选择排序无疑要比冒泡排序快，因为元素交换位置的次数要比冒泡排序少
	 */
	public static void selectionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	/**
	 * 插入排序
	 */
	public static void insertSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j > 0 && arr[j] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	
	/**
	 * 快速排序
	 */
	
	/**
	 * 对象排序
	 */
	
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
