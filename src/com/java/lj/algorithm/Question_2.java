package com.java.lj.algorithm;

/**
 * 面试题2 单例设计模式
 */
public class Question_2 {
	
}

/**
 * 单例设计模式(恶汉式 线程安全)
 */
class Singleton_1 {
	private Singleton_1() {}
	private static Singleton_1 sInstance = new Singleton_1();
	public static Singleton_1 getInstance() {
		return sInstance;
	}
}

/**
 * 单例设计模式(懒汉式 普通版 线程不安全)
 */
class Singleton_2 {
	private Singleton_2() {}
	private static Singleton_2 sInstance;
	public static Singleton_2 getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton_2();
		}
		return sInstance;
	}
}

/**
 * 单例设计模式(懒汉式 改进版 线程不安全)
 */
class Singleton_3 {
	private Singleton_3() {}
	private static Singleton_3 sInstance;
	public static Singleton_3 getInstance() {
		// 双重判空
		if (sInstance == null) {
			synchronized (Singleton_3.class) {
				if (sInstance == null) {
					sInstance = new Singleton_3();
				}
			}
		}
		return sInstance;
	}
}

/**
 * 单例设计模式(懒汉式 改进版 线程安全)
 * 参考:http://blog.csdn.net/haoel/article/details/4028232
 */
class Singleton_4 {
	private Singleton_4() {}
	/**
	 * volatile的用法,参考:http://www.cnblogs.com/dolphin0520/p/3920373.html
	 */
	private volatile static Singleton_4 sInstance;
	public static Singleton_4 getInstance() {
		// 双重判空
		if (sInstance == null) {
			synchronized (Singleton_4.class) {
				if (sInstance == null) {
					sInstance = new Singleton_4();
				}
			}
		}
		return sInstance;
	}
}

/**
 * 单例设计模式(懒汉式 高级版)
 */
class Singleton_5 {
	private Singleton_5() {}
	/**
	 * 由于内部类在编译完成后也是一个单独的class文件，因此在不使用的情况下Inner类是不会被加载的。
	 * 同时，JVM保证在类加载的过程中static代码块在多线程或者单线程下都正确执行，且仅执行一次。
	 * 解决了延迟加载以及线程安全的问题。
	 */
	private static class Inner {
		private static Singleton_5 instanceHolder = new Singleton_5();
	}
	public static Singleton_5 getInstance() {
		return Inner.instanceHolder;
	}
}
