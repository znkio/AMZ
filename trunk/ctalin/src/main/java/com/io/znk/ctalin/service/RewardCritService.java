package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Rewardcrit;
import java.util.List;


public interface RewardCritService {

	List<Rewardcrit> findAll();
        
        boolean deleteRewardCrit(Rewardcrit recr);
        
        Rewardcrit updateRewardCrit(Rewardcrit recr);
        
        Rewardcrit findRewardCrit(Rewardcrit recr);
        
}
