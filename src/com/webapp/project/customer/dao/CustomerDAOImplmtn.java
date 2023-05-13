package com.webapp.project.customer.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.project.customer.entity.Customer;

@Repository
public class CustomerDAOImplmtn implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {	
		
		//get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
		
		//execute the query and get result list
		List<Customer> customerList=query.getResultList();
		System.out.println(customerList);
		// return the results
		 
		return customerList;
	}

	@Override
	public void saveUpdateCustomer(Customer customer) {
		
		//get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//save customer
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer readCustomer(int id) {
		//get the current hibernate session
	    Session session=sessionFactory.getCurrentSession();
				
		//save customer
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session=sessionFactory.getCurrentSession();			
		Customer c=session.get(Customer.class, id);
		session.delete(c);		
		
	}

}
