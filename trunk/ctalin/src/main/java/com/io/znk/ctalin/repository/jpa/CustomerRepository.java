/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.repository.jpa;

import com.io.znk.ctalin.model.jpa.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author adamopoa
 */
public interface CustomerRepository  extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>{
    
}
