package com.backend.dsa.abstract_types;

import java.util.Arrays;

public class Queue {
	private int maxSize;
	private int head = -1;
	private int tail = -1;
	private Integer[] queueArray;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new Integer[maxSize];
	}

	public Queue() {
		this(10);
	}

	public void enqueue(int element) {
		if (head == -1) {
			head++;
			// System.out.println("head: " + head + " en element: " + element);
		}
		int difference = Math.abs(tail - head);
		if (difference == 0 || (difference == maxSize)) {
			System.out.println("the queue is full, make a new queue");
		} else if (difference < maxSize) {
			// if((tail == (maxSize - 1)) && head != 0) {
			if (tail == (maxSize - 1)) {
				tail = -1;

			}

		}
		tail++;

		System.out.println("head: " + head + " tail: " + tail + " en element: " + element);

		queueArray[tail] = element;
	}

	public int dequeue() {
		if (head == maxSize) {
			System.out.println("queue is empty, enqueue stuff to dequeue");
			return 0;
		}
		int headElement = queueArray[head];
		queueArray[head] = null;
		head++;
		if (head == maxSize) {
			head = -1;
			tail = -1;
		}
		System.out.println("head: " + head + " tail: " + tail + " de element: " + headElement);
		return headElement;
	}

	public int peek() {
		int headElement = queueArray[head];
		System.out.println("head: " + head + " tail: " + tail + " de element: " + headElement);
		return headElement;
	}

	public int size() {
		return maxSize;
	}

	@Override
	public String toString() {
		return "Queue [queueArray=" + Arrays.toString(queueArray) + "]";
	}

}
