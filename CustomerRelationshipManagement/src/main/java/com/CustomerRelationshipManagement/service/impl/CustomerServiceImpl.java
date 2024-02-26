package com.CustomerRelationshipManagement.service.impl;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}


	@Override
	public String insertCustomer(Customer customer) {
		String msg = customerDao.insertCustomer(customer);
		return msg;
	}

}
