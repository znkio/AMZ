package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.RewardReceived;
import java.util.List;


public interface RewardReceivedService {

	List<RewardReceived> findAll();
        
        boolean deleteRewardReceived(RewardReceived rere);
        
        RewardReceived updateRewardReceived(RewardReceived rere);
        
        RewardReceived findRewardReceived(RewardReceived rere);
        
}
