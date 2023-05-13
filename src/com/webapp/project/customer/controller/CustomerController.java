package com.webapp.project.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.project.customer.entity.Customer;
import com.webapp.project.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String showCustomerList(Model theModel)
	{
		List<Customer> customerList=customerService.getCustomers();		
		theModel.addAttribute("customers", customerList);
		return "customer-list";
	}
	
	@GetMapping("/add")
	public String addCustomer(Model theModel)
	{
		Customer customer=new Customer("firstname","lastname","email");
		theModel.addAttribute(customer);
		return "customer-form";
	}
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute Customer customer)
	{
		customerService.saveUpdateCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update")
	public String updateCustomer(Model theModel, @RequestParam("customerId") int id)
	{
		Customer customer=customerService.readCustomer(id);
		theModel.addAttribute(customer);		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		customerService.deleteCustomer(id);	
		return "redirect:/customer/list";
	}
}
