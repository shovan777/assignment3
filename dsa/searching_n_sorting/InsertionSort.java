package com.searchsort.binary;

public class InsertionSort<T> {
	@SuppressWarnings("unchecked")
	public InsertionSort(Comparable<T>[] objects) {
		// using ? wildcard
		// if you use <T> instead of ?, you will have to you will have to
		// specify it in function definition

		for (int i = 0; i < objects.length; i++) {
			Comparable<T> current = objects[i];
			int j = i - 1;
			while (j >= 0 && objects[j].compareTo((T) current) > 0) {
				objects[j + 1] = objects[j];
				j--;
			}
			objects[j+1] = current;
		}

	}

}
