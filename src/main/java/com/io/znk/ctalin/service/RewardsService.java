package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Rewards;
import java.util.List;


public interface RewardsService {

	List<Rewards> findAll();
        
        boolean deleteRewards(Rewards rew);
        
        Rewards updateRewards(Rewards rew);
        
        Rewards findRewards(Rewards rew);
        
}
