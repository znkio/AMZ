/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "customer")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long customerId;

    @NotNull
    @Column(unique = true)
    private Long customerAFM;

    @Column
    private String customerFname;

    @Column
    private String customerLname;

    
    public Customer(Long customerId, Long customerAFM, String customerFname, String customerLname) {
        this.customerId = customerId;
        this.customerAFM = customerAFM;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
    }
    
    public Long getCustomerId() {
        return customerId;
    }

    public Long getCustomerAFM() {
        return customerAFM;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerAFM(Long customerAFM) {
        this.customerAFM = customerAFM;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }



    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerAFM=" + customerAFM + ", customerFname=" + customerFname + ", customerLname=" + customerLname + '}';
    }
        
        
        
}
