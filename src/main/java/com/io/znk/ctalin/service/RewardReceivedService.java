package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Rewardreceived;
import java.util.List;


public interface RewardReceivedService {

	List<Rewardreceived> findAll();
        
        boolean deleteRewardReceived(Rewardreceived rere);
        
        Rewardreceived updateRewardReceived(Rewardreceived rere);
        
        Rewardreceived findRewardReceived(Rewardreceived rere);
        
}
