package sample.customer.application;

import java.util.LinkedList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.common.customer.domain.model.Customer;
import sample.common.customer.domain.repository.CustomerRepository;
import sample.common.exception.DataNotFoundException;
import sample.customer.domain.dto.CustomerDto;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private Mapper beanMapper;

	@Override
	public List<CustomerDto> findAll() {
		List<Customer> customerList = repository.findAll();
		List<CustomerDto> customers = new LinkedList<CustomerDto>();
		for (Customer customer : customerList) {
			CustomerDto dto = beanMapper.map(customer, CustomerDto.class);
			customers.add(dto);
    	}
		return customers;
	}

	@Override
	public CustomerDto findById(int id) throws DataNotFoundException {
        Customer customer = repository.findById(id);
        return beanMapper.map(customer, CustomerDto.class);
	}

	@Override
	public void update(CustomerDto customerDto) throws DataNotFoundException {
		Customer customer = beanMapper.map(customerDto, Customer.class);
		repository.update(customer);
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
