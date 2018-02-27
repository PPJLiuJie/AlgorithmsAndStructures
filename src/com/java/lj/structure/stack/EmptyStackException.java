package com.java.lj.structure.stack;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {

	public EmptyStackException() {
		super();
	}
	
	public EmptyStackException(String msg) {
		super(msg);
	}
}
