package com.fusemachines.backend.assignment.CRUDUsingOOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Employee implements Person, CRUDOps {
	private static Integer count = 0;
	private int employeeID;
	private String firstName;
	private String lastName;
	private String post;
	private String department;
	
	public Employee() {
		
	}

	public Employee(String s) throws IOException{
//		this();
		String countFilePath = "count.txt";
		File countFile = new File(countFilePath);
		File tempFile = new File("temp.txt");
		try (Scanner reader = new Scanner(countFile); Writer writer1 = new FileWriter(tempFile)) {
			while (reader.hasNextLine() == true) {
				count = Integer.parseInt(reader.nextLine());
				
			}
			count ++;
			writer1.write(count.toString());
			countFile.delete();
			tempFile.renameTo(countFile);
		}
		
	
		this.employeeID = count;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please give me the empoyee details of employee >> ");
		System.out.print("Enter firstname: ");
		this.firstName = sc.nextLine();
		System.out.print("Enter lastname: ");
		this.lastName = sc.nextLine();
		System.out.print("Enter post: ");
		this.post = sc.nextLine();
		System.out.print("Enter department: ");
		this.department = sc.nextLine();
//		sc.close();
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	
	public String getDepartment() {
		return department;
	}

	private void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void DisplayName() {
		System.out.println("Name: " + firstName + " " + lastName);

	}
	
	public void DescribePerson() {
		System.out.println("the employee id: " + employeeID + " is a " + post + " at Department of " + department);
	}

	public void addData() throws IOException {
		String employeeFilePath = "employee.txt";

		try (Writer writer = new FileWriter(employeeFilePath, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(this, writer);
			writer.write("\n");
		}
	}

	

	@Override
	public void deleteData(Integer id) throws IOException {
		boolean flag = false;
		String employeeFilePath = "employee.txt";
		String newEmployeeFilePath = "tempName.txt";
		File employeeFile = new File(employeeFilePath);
		File newEmployeeFile = new File(newEmployeeFilePath);
		try (Scanner reader = new Scanner(employeeFile); Writer writer1 = new FileWriter(newEmployeeFile, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				Employee toBeDeleted = gson.fromJson(reader.nextLine(), Employee.class);

				if (toBeDeleted.getEmployeeID() != id) {
					Gson gson1 = new GsonBuilder().create();
					gson1.toJson(toBeDeleted, writer1);
					writer1.write("\n");
				}
				else {
					flag = true;
				}
			}
			employeeFile.delete();
			newEmployeeFile.renameTo(employeeFile);
			if(flag ) {
				System.out.println("the record with id: " + id + " has been deleted");

			}
			else {
				System.out.println("there is no such employee with id: " + id);

			}
		}
		
	}

	@Override
	public void updateData(Integer id) throws IOException{
		boolean Flag = false;
		String employeeFilePath = "employee.txt";
		String newEmployeeFilePath = "tempName.txt";
		File employeeFile = new File(employeeFilePath);
		File newEmployeeFile = new File(newEmployeeFilePath);
		try (Scanner reader = new Scanner(employeeFile); Writer writer1 = new FileWriter(newEmployeeFile, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				Employee toBeUpdated = gson.fromJson(reader.nextLine(), Employee.class);

				if (toBeUpdated.getEmployeeID() != id) {
					Gson gson1 = new GsonBuilder().create();
					gson1.toJson(toBeUpdated, writer1);
					writer1.write("\n");
				}
				else {
					Gson gson2 = new GsonBuilder().create();
					Employee e = new Employee("fire");
					e.setEmployeeID(id);
					gson2.toJson(e, writer1);
					writer1.write("\n");
					Flag = true;
					
				}
			}
			employeeFile.delete();
			newEmployeeFile.renameTo(employeeFile);
			if(Flag ) {
				System.out.println("the record with id: " + id + " has been updated");

			}
			else {
				System.out.println("there is no such employee with id: " + id);

			}
		}
	}

	@Override
	public void showOneData(Integer id) throws IOException{
		String employeeFilePath = "employee.txt";
		File employeeFile = new File(employeeFilePath);
		try (Scanner reader = new Scanner(employeeFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				Employee toBeShown = gson.fromJson(reader.nextLine(), Employee.class);

				if (toBeShown.getEmployeeID() != id) {
					System.out.println(toBeShown.toString());
				}
				else {
					System.out.println("there is no such employee with id: " + id);
				}
			}
			
		}
		
				
	}

	@Override
	public void showAllData() throws IOException {
		boolean Flag = false;
		String employeeFilePath = "employee.txt";
		File employeeFile = new File(employeeFilePath);
		try (Scanner reader = new Scanner(employeeFile)) {
			while (reader.hasNextLine() == true) {
				Flag = true;
				Gson gson = new GsonBuilder().create();
				Employee toBeShown = gson.fromJson(reader.nextLine(), HeadofDep.class);

					System.out.println(toBeShown.toString());
				
			}
			if(!Flag) {
				System.out.println("the file is empty. no records to show.");

			}
			
		}
		
	}





	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", post="
				+ post + ", department=" + department + "]\n";
	}
	
	
	
	
	
	
	
	
	
	
}
