package com.sample.bl.service;

import java.util.LinkedList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bl.dto.CustomerDto;
import com.sample.dao.entity.Customer;
import com.sample.dao.repository.CustomerDao;
import com.sample.exception.DataNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private Mapper beanMapper;

	@Override
	public List<CustomerDto> findAll() {
		List<Customer> customerList = dao.findAll();
		List<CustomerDto> customers = new LinkedList<CustomerDto>();
		for (Customer customer : customerList) {
			CustomerDto dto = beanMapper.map(customer, CustomerDto.class);
			customers.add(dto);
    	}
		return customers;
	}

	@Override
	public CustomerDto findById(int id) throws DataNotFoundException {
        Customer customer = dao.findById(id);
        return beanMapper.map(customer, CustomerDto.class);
	}

	@Override
	public void update(CustomerDto customerDto) throws DataNotFoundException {
		Customer customer = beanMapper.map(customerDto, Customer.class);
		dao.update(customer);
	}
	
	@Override
	public CustomerDto register(CustomerDto customer) {
		// TODO 作る予定ないよ.
		return null;
	}

	@Override
	public void delete(int id) throws DataNotFoundException {
		// TODO 作る予定ないよ.
	}
}
