package com.CustomerRelationshipManagement.service;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService {
	
	String insertCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public void  deleteCustomerById(int id);

}
