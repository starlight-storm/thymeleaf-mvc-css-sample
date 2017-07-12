package sample.customer.application;

import java.util.List;

import sample.common.exception.DataNotFoundException;
import sample.customer.domain.dto.CustomerDto;

public interface CustomerService {
    public List<CustomerDto> findAll();

    public CustomerDto findById(int id) throws DataNotFoundException;

    public CustomerDto register(CustomerDto customer);

    public void update(CustomerDto customer) throws DataNotFoundException;

    public void delete(int id) throws DataNotFoundException;
}
