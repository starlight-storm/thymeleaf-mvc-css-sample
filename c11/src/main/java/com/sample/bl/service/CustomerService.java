package com.sample.bl.service;

import java.util.List;

import com.sample.bl.dto.CustomerDto;
import com.sample.exception.DataNotFoundException;


public interface CustomerService {
    public List<CustomerDto> findAll();

    public CustomerDto findById(int id) throws DataNotFoundException;

    public CustomerDto register(CustomerDto customer);

    public void update(CustomerDto customer) throws DataNotFoundException;

    public void delete(int id) throws DataNotFoundException;
}
