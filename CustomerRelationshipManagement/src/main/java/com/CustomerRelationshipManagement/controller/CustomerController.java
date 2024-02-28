package com.CustomerRelationshipManagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/insert")
	public String inserCustomer(@RequestBody Customer customer) {
		
		String msg = customerService.insertCustomer(customer);
		
		return msg;
		
	}
	@GetMapping("/all")
	public List<Customer>getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/get/{id}")
	public Customer getCustomer (@PathVariable int id) {
		Customer customer =customerService.getCustomerById(id);
		
		return customer;
	}
		
		

	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateEntity(@PathVariable int id, @RequestBody Customer customer) {
	        Optional<Customer> optionalEntity = customerDao.findById(id);
	        if (!optionalEntity.isPresent()) {
	            return ResponseEntity.notFound().build();
	        }

	        Customer existingEntity = optionalEntity.get();
	        existingEntity.setAge(customer.getAge());
	        existingEntity.setFirstName(customer.getFirstName());
	        existingEntity.setLastName(customer.getLastName());
	        existingEntity.setEmail(customer.getEmail());
	        existingEntity.setMobileNumber(customer.getMobileNumber());
	        customerDao.save(existingEntity); // Save the updated entity

	        return ResponseEntity.ok(existingEntity);
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public void deleteCustomerById(@PathVariable int id) {
	    	customerService.deleteCustomerById(id);
	    }
}
