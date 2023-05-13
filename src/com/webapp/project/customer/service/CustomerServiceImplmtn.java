package com.webapp.project.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.project.customer.dao.CustomerDAO;
import com.webapp.project.customer.entity.Customer;

@Service
public class CustomerServiceImplmtn implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveUpdateCustomer(Customer customer) {
		
		customerDAO.saveUpdateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer readCustomer(int id) {
		Customer c=customerDAO.readCustomer(id);
		return c;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {	
		customerDAO.deleteCustomer(id);
		
	}

}
