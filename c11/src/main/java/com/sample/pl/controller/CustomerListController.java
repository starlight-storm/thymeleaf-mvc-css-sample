package com.sample.pl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sample.bl.dto.CustomerDto;
import com.sample.bl.service.CustomerService;
import com.sample.exception.DataNotFoundException;

@Controller
public class CustomerListController {

    @Autowired
    private CustomerService customerService;

// --ページネーション
//    private static int PAGE_SIZE = 3;

    @GetMapping(value = "/")
    public String home() {
        return "forward:/customer";
    }
    
// --ページネーション
//    @GetMapping(value = "/customer")
//    public String showAllCustomers(@RequestParam(value = "page", defaultValue = "0") String page, Model model) {
// 
//        PagedListHolder<CustomerDto> customers = new PagedListHolder<>(customerService.findAll());
//        customers.setPage(Integer.parseInt(page));
//        customers.setPageSize(PAGE_SIZE);
        
        @GetMapping(value = "/customer")
        public String showAllCustomers(Model model) {
            List<CustomerDto> customers = customerService.findAll();      
            model.addAttribute("customers", customers);
            return "customer/list";
        }

    @GetMapping(value = "/customer/{customerId}")
    public String showCustomerDetail(@PathVariable int customerId, Model model)
                                        throws DataNotFoundException{
        CustomerDto customerDto = customerService.findById(customerId);
        model.addAttribute("customer", customerDto);
        return "customer/detail";
    }
    
//    @ExceptionHandler(DataNotFoundException.class)
//    public String handleException() {
//        return "/customer/notfound";
//    }

}
