package com.sample.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.dao.entity.Customer;
import com.sample.dao.entity.CustomerExample;
import com.sample.exception.DataNotFoundException;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerMapper mapper;
	
	public List<Customer> findAll() {
		CustomerExample c = new CustomerExample();
		c.createCriteria().andIdIsNotNull();
		List<Customer> customerList = mapper.selectByExample(c);
		return customerList;
	}
	
	public Customer findById(int id) throws DataNotFoundException {
		Customer customer = mapper.selectByPrimaryKey(id);
		if(customer == null) throw new DataNotFoundException();
		return customer;
	}
	
	public void update(Customer customer) {
		mapper.updateByPrimaryKey(customer);
	}
}
