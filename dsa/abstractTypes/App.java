package com.backend.dsa.abstract_types;

public class App {

	public static void main(String[] args) {

		// Stack stackit = new Stack(1);
		// // System.out.println(stackit);
		// System.out.println(stackit.size());
		// stackit.push(5);
		// stackit.push(2);
		// stackit.pop();
		// stackit.pop();
		// System.out.println(stackit);
		//
		// // Integer[] a = new Integer[5];
		// // System.out.println(Arrays.toString(a));
		
		Queue q = new Queue(4);
		System.out.println(q);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		
		q.enqueue(8);
////		q.enqueue(9);
		 
		 
		// q.enqueue(6);
		 System.out.println(q);

	}

}
