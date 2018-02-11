package com.java.lj.algorithm;

/**
 * 面试题8
 */
public class Question_08 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(findMin(arr));
		
		int[] arr1 = {5,6,7,1,1,1,1};
		System.out.println(findMin(arr1));
		
		int[] arr2 = {2,2,2,2,2};
		System.out.println(findMin(arr2));
		
		int[] arr3 = {1,1,0,1,1};
		System.out.println(findMin(arr3));
		
		int[] arr4 = {1,0,1,1,1};
		System.out.println(findMin(arr4));
		
//		int[] arr5 = {};
//		System.out.println(findMin(arr5));
//		System.out.println(findMin(null));
	}

	/**
	 * 题目:旋转数组的最小数字
	 * 
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
	 */
	
	/**
	 * 第一种方式:
	 * 依次遍历整个数组。时间复杂度为O(n)
	 * 代码略
	 */
	
	
	/**
	 * 第二种方式:<br>
	 * 使用二分查找法
	 */
	public static int findMin(int[] arr) {
		
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("The int array is null or length is zero.");
		}
		
		int len = arr.length;
		int start = 0;
		int end = len - 1;
		int center = (end -start) / 2 + start;
		
		int startElement = 0;
		int centerElement = 0;
		int endElement = 0;
		
		while(true) {
			startElement = arr[start];
			endElement = arr[end];
			centerElement = arr[center];
			
			// 如果旋转数组的 第一个元素 小于 最后一个元素，则该旋转数组就是递增的
			if (startElement < endElement) {
				return startElement;
			}
			
			if (start == end - 1) {
				break;
			}
			
			/**
			 * 1.比如递增数组{0,1,1,1,1}的旋转数组{1,1,1,0,1}的开始元素、中间元素、结尾元素都相等
			 * 2.再比如递增数组{0,1,1,1,1,2,2,2,2}的旋转数组{2,2,2,2,1,1,1,0,1}，
			 * 	  当把范围缩小到{1,1,1,0,1}的时候，也会出现开始元素、中间元素、结尾元素都相等的情况
			 * 
			 * 以上情况，只能按顺序依次遍历查找
			 */
			if (startElement == centerElement && centerElement == endElement) {
				return getMinInArr(arr, startElement, endElement);
			}
			
			if (centerElement >= startElement) {
				start = center;
				center = (end -start) / 2 + start;
			} else if (centerElement <= startElement) {
				end = center;
				center = (end -start) / 2 + start;
			}
		}
		return startElement < endElement ? startElement : endElement;
	}
	
	public static int getMinInArr(int[] arr, int start, int end) {
		int result = arr[start];
		
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < result) {
				result = arr[i];
			}
		}
		return result;
	}
}
