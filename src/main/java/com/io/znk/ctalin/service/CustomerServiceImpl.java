package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.repository.jpa.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository cur;

    
    @Override
    public List<Customer> findAll() {
        List<Customer> ret = new ArrayList();
        ret = this.cur.findAll();
        return ret;
    }

    @Override
    public boolean deleteCustomer(Customer cus) {
        try {
            this.cur.delete(cus);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Customer updateCustomer(Customer cus) {
        Customer uach = this.cur.save(cus);
        return uach;
    }

    @Override
    public Customer findCustomer(Customer cus) {
        if (cus.getCustomerId() != null && !cus.getCustomerId().equals("")) {
            return this.cur.findOne(cus.getCustomerId());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

    

}
