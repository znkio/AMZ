/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.repository.jpa;

import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Rewardreceived;
import com.io.znk.ctalin.model.jpa.Rewards;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardReceivedRepository extends JpaRepository<Rewardreceived, String> {

    List<Rewardreceived> findByRewardIDAndCustomerID(Rewards rewardID, Customer customerID);
}
