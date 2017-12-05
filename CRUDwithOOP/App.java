package com.fusemachines.backend.assignment.CRUDUsingOOP;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try {
			while (true) {
				System.out.println("please select one of operations from below: by entering numbers 1-2");
				System.out.println("1 employee operations: ");
				System.out.println("2 quit");
				System.out.print("enter num: ");
				@SuppressWarnings("resource")
				Scanner sr = new Scanner(System.in);
				String choice = sr.nextLine();
				if (choice.contentEquals("2")) {
					System.exit(0);
				} else {
					System.out.println("please select one of operations from below: by entering numbers 1-");
					System.out.println("1 add normal employee");
					System.out.println("2 add HOD");
					System.out.println("3 update employee record");
					System.out.println("4 delete employee record");
					System.out.println("5 show all record");
					System.out.println("6 quit");
					System.out.print("Enter a number (1-6): ");
					choice = sr.nextLine();
					if (choice.contentEquals("6")) {
						System.exit(0);
					} else if (choice.contentEquals("1")) {
						// sr.close();
						Employee e = new Employee("janku");
						e.addData();
						e.DescribePerson();
					} else if (choice.contentEquals("2")) {
						// Polymorphism
						System.out.print("Enter the number of people under him: ");
						String counter = sr.nextLine();
						Employee e = new HeadofDep(Integer.parseInt(counter));
						e.addData();

						// Polymorphism
						e.DescribePerson();
					} else if (choice.contentEquals("3")) {
						Employee e = new Employee();
						e.showAllData();
						System.out.print("\nenter the index of employee record you want to update: ");
						int id = Integer.parseInt(sr.nextLine());
						e.updateData(id);
						e.showOneData(id);
					} else if (choice.contentEquals("4")) {
						Employee e = new Employee();
						e.showAllData();
						System.out.print("\nenter the index of employee record you want to dlete: ");
						int id = Integer.parseInt(sr.nextLine());
						e.deleteData(id);
						e.showAllData();
					} else if (choice.contentEquals("5")) {
						Employee e = new Employee();
						e.showAllData();
					}

				}
			}
		} catch (IOException e) {
			System.out.println("the employee file has not been created to read the employees' data");
		}

	}

}
