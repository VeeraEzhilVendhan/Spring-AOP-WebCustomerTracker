package com.webapp.project.customer.dao;

import java.util.List;

import com.webapp.project.customer.entity.Customer;
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveUpdateCustomer(Customer customer);

	public Customer readCustomer(int id);
	
	public void deleteCustomer(int id);
}
