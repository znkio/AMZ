package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.RewardCrit;
import java.util.List;


public interface RewardCritService {

	List<RewardCrit> findAll();
        
        boolean deleteRewardCrit(RewardCrit recr);
        
        RewardCrit updateRewardCrit(RewardCrit recr);
        
        RewardCrit findRewardCrit(RewardCrit recr);
        
}
