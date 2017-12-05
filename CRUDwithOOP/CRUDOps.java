package com.fusemachines.backend.assignment.CRUDUsingOOP;

import java.io.IOException;

public interface CRUDOps {
	public void addData() throws IOException;
	public void deleteData(Integer id) throws IOException;
	public void updateData(Integer id) throws IOException;
	public void showOneData(Integer id) throws IOException;
	public void showAllData() throws IOException;
}
