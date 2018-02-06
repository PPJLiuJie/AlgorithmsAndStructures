package com.java.lj.algorithm;

/**
 * 字符的排列组合
 */
public class PermutationOfChar {

	public static void main(String[] args) {
		
		MyPrintln.start("arrageOfChar");
		char[] ch = "abc".toCharArray();
		arrageOfChar(ch, 0, ch.length - 1);
		MyPrintln.end("arrageOfChar");
		
		MyPrintln.start("combinationOfChar");
		combinationOfChar(ch);
		MyPrintln.end("combinationOfChar");
		
		MyPrintln.start("permutation");
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9'};
		char[] charResult = new char[1];
		permutation(charSet, charResult, charResult.length, 0);
		MyPrintln.end("permutation");
	}

	/**
	 * 字符的组合<br>
	 * 长度不变，允许重复字符，且必须按顺序输出<br>
	 * 如'0'、'1'两个字符的组合按顺序输出:"00"、"01"、"10"、"11"，按其所对应的二进制的值递增的顺序
	 * @param charSet 字符集
	 * @param charResult 结果
	 * @param strLen 字符串长度
	 * @param index 当前下标
	 */
	public static void permutation(char[] charSet, char[] charResult, int strLen, int index) {
		if (index == strLen) {
			System.out.println(charResult);
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
	 * 字符的全组合<br>
	 * 长度无限制，ab和ba为同一种组合，abc、acb、bac、bca、cab、cba为同一种组合<br>
	 * 且不允许重复字符
	 */
	public static void combinationOfChar(char[] ch) {
		/*
		 1 1 1 1 1 1 1
		 g f e d c b a
		 
		 设数组的总长度为n，每一位的取值为0或1，则一共有(2^n-1)种取值
		 参考自:https://segmentfault.com/a/1190000002710424
		 */
		
		int len = ch.length;
		int n = (1<<len) - 1;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			/*
			// i转成二进制
			String binary_n = Integer.toBinaryString(i);
			
			// 二进制的字符串表现形式
			StringBuilder tempSb = new StringBuilder(binary_n);
			// 理解，为什么要反转字符串
			tempSb = tempSb.reverse();
			
			char[] tempCh = tempSb.toString().toCharArray();
			
			for(int k = 0; k < tempCh.length; k++) {
				if ('1' == tempCh[k]) {
					sb.append(ch[k]);
					System.out.print(ch[k]);
				}
			}
			
			System.out.println();
			sb.delete(0, sb.length());
			*/
			
			// 上面的方式，是将二进制转成字符串，然后获取该字符串中字符'1'的所有下标，然后根据该下标就能获取到对应的字符
			
			// 这里介绍一种更简单的方式
			for (int j = 0; j < len; j++) {
				// i&(1<<j) != 0 这个表达式的意思是：i的二进制表示形式的第j位为'1'
				if ((i & (1<<j)) != 0) {
					sb.append(ch[j]);
				}
			}
			System.out.println(sb.toString());
			
			// 清空
			sb.delete(0, sb.length());
		}
	}
	
	
	/**
	 * 字符的全排列(长度不变，不允许重复字符)<br>
	 * 比如abc的排列为:abc、acb、bac、bca、cab、cba
	 */
	public static void arrageOfChar(char[] ch, int from, int to) {

		// 空数组不处理
		if (to < 0) {
			return;
		}
		// 只有一个元素的数组直接打印
		if (to == 0) {
			System.out.println(ch);
			return;
		}

		/**
		 * 为什么在"from == to"的时候才打印？
		 * 这是一个难点，参考:https://segmentfault.com/a/1190000002710424 这个链接对应的网页中有个示意图
		 */
		if (from == to) {
			System.out.println(ch);
		} else {
			for (int i = from; i <= to; i++) {
				swap(ch, from, i);
				arrageOfChar(ch, from + 1, to);
				swap(ch, i, from);
			}
		}
	}

	/**
	 * 字符数组的某两个元素互换位置
	 */
	private static void swap(char[] ch, int j, int k) {
		char temp = ch[j];
		ch[j] = ch[k];
		ch[k] = temp;
	}
}
