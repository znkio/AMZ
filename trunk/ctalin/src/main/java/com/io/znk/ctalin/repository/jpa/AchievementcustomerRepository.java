/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.repository.jpa;

import com.io.znk.ctalin.model.jpa.Achievementcustomer;
import com.io.znk.ctalin.model.jpa.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AchievementcustomerRepository extends JpaRepository<Achievementcustomer, String> {
    public List<Achievementcustomer> findByCustomerID(Customer customerID);
}
