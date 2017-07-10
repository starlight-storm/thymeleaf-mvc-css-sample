package sample.customer.application;

import static sample.customer.util.values.CustomerGraduateValues.JAPAN;
import static sample.customer.util.values.CustomerGraduateValues.OTHER;
import static sample.customer.util.values.CustomerTypeValues.GOLD;
import static sample.customer.util.values.CustomerTypeValues.SILVER;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import sample.customer.domain.Customer;

@Service("customerService")
public class MockCustomerService implements CustomerService {
    private Map<Integer, Customer> customerMap
                            = new LinkedHashMap<Integer, Customer>();

    private int nextId = 1;

    private boolean isExists(int id) {
        return customerMap.containsKey(id);
    }

    public List<Customer> findAll() {
    	List<Customer> list = new LinkedList<Customer>();
    	for (Customer customer : customerMap.values()) {
    		list.add(newCustomer(customer));
    	}
        return list;
    }

    public Customer findById(int id) throws DataNotFoundException {
        if (!isExists(id)) {
            throw new DataNotFoundException();
        }
        return newCustomer(customerMap.get(id));
    }

    public Customer register(Customer customer) {
        customer.setId(nextId++);
        customerMap.put(customer.getId(), newCustomer(customer));

        return customer;
    }

    public void update(Customer customer) throws DataNotFoundException {
        if (!isExists(customer.getId())) {
            throw new DataNotFoundException();
        }
        customerMap.put(customer.getId(), newCustomer(customer));
    }

    public void delete(int id) throws DataNotFoundException {
        if (!isExists(id)) {
            throw new DataNotFoundException();
        }
        customerMap.remove(id);
    }

    @PostConstruct
    public void initCustomer() {
        nextId = 1;

        register(new Customer("太郎", "東京都新宿区", "taro@aa.bb.cc", GOLD.getValue(), JAPAN.getValue()));
        register(new Customer("ジロー", "東京都豊島区", "jiro@aa.bb.cc", GOLD.getValue(), OTHER.getValue()));
        register(new Customer("三郎", "東京都板橋区", "sabu@aa.bb.cc", SILVER.getValue(), JAPAN.getValue()));
    }

    private Customer newCustomer(Customer orig) {
    	Customer dest = new Customer();
    	try {
    		BeanUtils.copyProperties(dest, orig);
    	} catch (Exception e) {
    		throw new RuntimeException("Exception threw in Customer copy ", e);
    	}
    	return dest;
    }
}
