package com.searchsort.binary;

public class BinaryFind<T> {
	private Comparable<T>[] objects;
	@SuppressWarnings("unused")
	private T item;

	public BinaryFind(Comparable<T>[] objects, T item) {
		this.objects = objects;
		this.item = item;
		// int len = objects.length;
		int minIndex = 0;
		int maxIndex = objects.length - 1;
		binarySearch(item, minIndex, maxIndex);

	}

	public void binarySearch(T item, int minIndex, int maxIndex) {
		if (minIndex == maxIndex) {
			if (objects[0].compareTo(item) == 0) {
				System.out.println("object found at index: 0");
				return;
			} else {
				System.out.println("there is no such object");
				return;
			}
		} else {
			int midIndex = (int) Math.floor((maxIndex + minIndex) / 2);
			int compareVal = objects[midIndex].compareTo(item);
			if (compareVal == 0) {
				System.out.println("object found at index: " + midIndex);	
				return;
			}
			else if(compareVal == 1) {
				maxIndex = midIndex - 1;
				binarySearch(item, minIndex, maxIndex);
			}
			else {
				minIndex = midIndex + 1;
				binarySearch(item, minIndex, maxIndex);
			}

		}
	}

}
