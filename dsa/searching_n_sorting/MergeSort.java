package com.searchsort.binary;

public class MergeSort {
	// private Comparable<T>[] objects;

	public MergeSort(Integer[] objects) {
		// this.objects = objects;
		MergeSorter(objects, 0, objects.length - 1);
	}

	private void MergeSorter(Integer[] objects, int start, int end) {
		if(start < end) {
			int middle = (int) Math.floor((start + end) / 2);
			MergeSorter(objects, start, middle);
			MergeSorter(objects, middle + 1, end);
			Merge(objects, start, middle, end);
		}
//		else {
//			return;
//		}
//		

	}

	private void Merge(Integer[] objects, int start, int middle, int end) {
		int i, j, k;
		int n1 = middle - start + 1;
		int n2 = end - middle;
		int[] left = new int[n1];
		int[] right = new int[n2];
		// Integer[] right = new Integer[end - middle];

		for (int i1 = 0; i1 < left.length; i1++) {
			left[i1] = objects[start + i1];
		}

		for (int i1 = 0; i1 < right.length; i1++) {
			right[i1] = objects[middle + 1 + i1];
		}

		i = 0;
		j = 0;
		k = start;
		while(i<n1 && j<n2) {
			if (left[i] <= right[j]) {
				objects[k] = left[i];
				i++;
			} else {
				objects[k] = right[j];
				j++;
			}
			k++;
		}
		
		/* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            objects[k] = left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            objects[k] = right[j];
            j++;
            k++;
        }
		
		
		
		/**
		 * the method below is clearly flawed and not clear in the implementation of merge short
		 * the method above is much clearer and does not depend on 'or' and 'and' operations
		 */
//		for (int k = start; k <= end; k++) {
//			if ((j >= right.length) || ((i<left.length)&&(left[i] <= right[j]))) {
//				objects[k] = left[i];
//				i++;
//			} else {
//				objects[k] = right[j];
//				j++;
//			}
//		}
	}

}
