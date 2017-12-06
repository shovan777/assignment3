package com.searchsort.binary;
import java.util.Random;

public class RandomGen {
	private Random rand = new Random();

	public RandomGen(Integer[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(1000);
		}
	}

}
