package com.CustomerRelationshipManagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;
@Repository
public class CustomerDao {
	
//	@Autowired
	SessionFactory sf;

	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public String insertCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();	// used for insert update delete
		session.save(customer);
		tr.commit();
		session.close();
		return "Customer Insert successfully";
	}
}
