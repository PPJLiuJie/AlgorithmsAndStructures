package com.java.lj.structure.stack;

public class Test {

	public static void main(String[] args) {
		testSeqStack();
		testLinkedStack();
	}
	
	private static void testSeqStack() {
		SeqStack<String> seqStack = new SeqStack<>();
		seqStack.push("A");
		seqStack.push("B");
		seqStack.push("C");
		
		int s = seqStack.size();
		
		for (int i = 0; i < s; i++) {
			System.out.println("seqStack.pop->" + seqStack.pop());
		}
		
//		System.out.println("seqStack.peek->" +  seqStack.peek());
	}
	
	private static void testLinkedStack() {
		LinkedStack<String> linkedStack = new LinkedStack<>();
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		
		int s = linkedStack.size();
		
		for (int i = 0; i < s; i++) {
			System.out.println("linkedStack.pop->" + linkedStack.pop());
		}
		
//		System.out.println("linkedStack.peek->" + linkedStack.peek());
	}

	
	
}
