package sample.customer.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sample.customer.application.CustomerService;
import sample.customer.application.DataNotFoundException;
import sample.customer.domain.Customer;

@Controller
public class CustomerListController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public String home() {
        return "forward:/customer";
    }
    
    @GetMapping(value = "/customer")
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping(value = "/customer/{customerId}")
    public String showCustomerDetail(@PathVariable int customerId, Model model)
                                        throws DataNotFoundException{
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }
    
//    @ExceptionHandler(DataNotFoundException.class)
//    public String handleException() {
//        return "/customer/notfound";
//    }

}
