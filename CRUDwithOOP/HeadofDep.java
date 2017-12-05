package com.fusemachines.backend.assignment.CRUDUsingOOP;

import java.io.IOException;

public class HeadofDep extends Employee implements Person {
	// private final String Post = "HOD";
	private int countGuysUnderHim;

	public HeadofDep(int count) throws IOException {
		super("jaa");
		this.countGuysUnderHim = count;
	}

	public int getCountGuysUnderHim() {
		return countGuysUnderHim;
	}

	public void setCountGuysUnderHim(int countGuysUnderHim) {
		this.countGuysUnderHim = countGuysUnderHim;
	}

	@Override
	public void DescribePerson() {
		// TODO Auto-generated method stub
		super.DescribePerson();
		System.out.println("He heads the " + this.getDepartment() + " and has " + countGuysUnderHim + " working for him.");
	}

	@Override
	public String toString() {
		return super.toString() + "HeadofDep [countGuysUnderHim=" + countGuysUnderHim + "]\n";
	}
	
	
	

}
