/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface EmployeeDAO.
 */
//CRUD operations
public interface EmployeeDAO {
	
	/**
	 * Save.
	 *
	 * @param employee the employee
	 */
	//Create
	public void save(Employee employee);
	
	/**
	 * Obtiene el by id.
	 *
	 * @param id the id
	 * @return el by id
	 */
	//Read
	public Employee getById(int id);
	
	/**
	 * Update.
	 *
	 * @param employee the employee
	 */
	//Update
	public void update(Employee employee);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	//Delete
	public void deleteById(int id);
	
	/**
	 * Obtiene el all.
	 *
	 * @return el all
	 */
	//Get All
	public List<Employee> getAll();
}
