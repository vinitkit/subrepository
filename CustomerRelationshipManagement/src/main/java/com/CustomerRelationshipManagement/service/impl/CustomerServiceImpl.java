package com.CustomerRelationshipManagement.service.impl;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public void insertCustomer(Customer customer) {
		Customer cust = customerDao.save(customer);
		System.out.println(cust + "serviceimpl");
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerDao.findById(id).get();
		return customer;

	}

	@Override
	public void deleteCustomerById(int id) {
		customerDao.deleteById(id);
	
	}


}
