package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Customer;
import java.util.List;


public interface CustomerService {

	List<Customer> findAll();
        
        boolean deleteCustomer(Customer cus);
        
        Customer updateCustomer(Customer cus);
        
        Customer findCustomer(Customer cus);
}
