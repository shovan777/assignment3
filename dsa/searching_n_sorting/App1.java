package com.searchsort.binary;

import java.util.Arrays;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		Integer[] data = new Integer[1000];
		new RandomGen(data);
		// Integer[] data = {9, 8, 7, 6};
		int n = data.length;
		// Integer[] data_merge = data.clone();
		// Integer[] data_quick = data.clone();
		// Integer[] data_insertion = data.clone();
		boolean isSorted = false;
		// System.out.println(data);
		// data[0] = 6;
		System.out.println("the following array has been randomly chosen for you: ");
//		System.out.println(Arrays.deepToString(data));
		// System.out.println(Arrays.deepToString(data_merge));
		while (true) {
			System.out.println("\n****************************\n");
			// System.out.println(Arrays.toString(data));
			System.out.println("the array above is a randomly generated array of 1000 numbers between 0-999");
			System.out.println("You can perform following operations with it.");
			System.out.println("1 Insertion Sort\n2 Merge Sort\n3 Quick Sort\n4 Binary Search\n5 Analysis\n6 quit");
			System.out.println("Enter the number on right to perform desired operation:");
			System.out.print(">> ");
			int key = 1;
			Scanner sc = new Scanner(System.in);
			key = Integer.parseInt(sc.nextLine());

			switch (key) {
			case 1:
				long startTime = System.currentTimeMillis();
				new InsertionSort<Integer>(data);
				long stopTime = System.currentTimeMillis();
				long totalTime = stopTime - startTime;
				System.out.println("data sorted in " + totalTime + "ms");
				System.out.println(Arrays.deepToString(data));
				isSorted = true;
				break;

			case 2:
				startTime = System.currentTimeMillis();
				new MergeSort(data);
				stopTime = System.currentTimeMillis();
				totalTime = stopTime - startTime;
				System.out.println("data sorted in " + totalTime + "ms");
				System.out.println(Arrays.deepToString(data));
				isSorted = true;
				break;

			case 3:
				startTime = System.currentTimeMillis();
				QuickSort sorted_array = new QuickSort();
				sorted_array.sort(data, 0, n - 1);
				stopTime = System.currentTimeMillis();
				totalTime = stopTime - startTime;
				System.out.println("data sorted in " + totalTime + "ms");
//				System.out.println(Arrays.deepToString(data));

				isSorted = true;
				break;

			case 4:
				if (isSorted) {
					System.out.println("enter the number you want to search for:");
					System.out.println(">> ");
					int num = sc.nextInt();					
					startTime = System.currentTimeMillis();
					new BinaryFind<Integer>(data, num);
					stopTime = System.currentTimeMillis();
					totalTime = stopTime - startTime;
					System.out.println("data found in " + totalTime + "ms");
					// isSorted = false;
				} else {
					System.out.println("please sort the data using any of the sorters");
				}
				break;

			case 5:
				int counter = 0;
				double totalTimeInsertion = 0;
				double totalTimeMerge = 0;
				double totalTimeQuick = 0;

				for (int i = 0; i <= 100; i++) {
					Integer[] data_analysis = new Integer[10000];
					new RandomGen(data_analysis);
					// Integer[] data = {9, 8, 7, 6};
					int n_analysis = data_analysis.length;
					Integer[] data_merge = data_analysis.clone();
					Integer[] data_quick = data_analysis.clone();
					Integer[] data_insertion = data_analysis.clone();
					// Merge sort
					startTime = System.currentTimeMillis();
					new MergeSort(data_merge);
					stopTime = System.currentTimeMillis();
					totalTime = stopTime - startTime;
					totalTimeMerge += totalTime;

					// Insertion sort
					startTime = System.currentTimeMillis();
					new InsertionSort<Integer>(data_insertion);
					stopTime = System.currentTimeMillis();
					totalTime = stopTime - startTime;
					totalTimeInsertion += totalTime;

					// QuickSort
					startTime = System.currentTimeMillis();
					QuickSort sortedArray = new QuickSort();
					sortedArray.sort(data_quick, 0, n_analysis - 1);
					stopTime = System.currentTimeMillis();
					totalTime = stopTime - startTime;
					totalTimeQuick += totalTime;

					// update counter
					counter++;

				}

				System.out.println("following are the average runtimes for the different sorts");
				System.out.println("1. Merge Sort: " + totalTimeMerge / counter + " ms");
				System.out.println("2. Quick Sort: " + totalTimeQuick / counter + " ms");
				System.out.println("3. Insertion Sort: " + totalTimeInsertion / counter + " ms");
				break;

			case 6:
				sc.close();
				System.exit(0);				
				break;

			default:
				System.out.println("enter a valid operation.");
				break;
			}

		}
	}

}
