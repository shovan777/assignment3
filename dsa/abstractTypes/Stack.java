package com.backend.dsa.abstract_types;

import java.util.Arrays;

public class Stack {
	private int maxSize;
	private int top = -1;
	private Integer[] stackArray;

	public Stack(int maxSize) {
		/*
		 * Each element of the array is assigned to null at default
		 */
		this.maxSize = maxSize;
		stackArray = new Integer[maxSize];
	}

	public Stack() {
		this(10);
	}

	public void push(int element) {
		if(top == (maxSize - 1)) {
			System.out.println("there is no more space, create a new stack");
			return;
		}
		top++;
		stackArray[top] = element;
		System.out.println(element + " added at index: " + top);
	}

	public Integer pop() {
		if(top == -1) {
			System.out.println("stack is empty, push some stuff to pop it");
			return 0;
		}
		Integer topElement = stackArray[top];
		stackArray[top] = null;
		top--;
		System.out.println(topElement + " removed and top points to " + top);
		return topElement;
	}

	public Integer peek() {
		Integer topElement = stackArray[top];
		System.out.println("the topElement is: " + topElement + "lying at index: " + top);
		return topElement;
	}

	public int size() {
		return maxSize;
	}

	@Override
	public String toString() {
		return "Stack [stackArray=" + Arrays.toString(stackArray) + "]";
	}

}
