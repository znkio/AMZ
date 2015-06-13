package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.RewardReceived;
import com.io.znk.ctalin.repository.jpa.RewardReceivedRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RewardReceivedServiceImpl implements RewardReceivedService {

    @Autowired
    RewardReceivedRepository rerr;

    @Override
    public List<RewardReceived> findAll() {
        List<RewardReceived> ret = new ArrayList();
        ret = this.rerr.findAll();
        return ret;
    }

    @Override
    public boolean deleteRewardReceived(RewardReceived rere) {
        try {
            this.rerr.delete(rere);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public RewardReceived updateRewardReceived(RewardReceived rere) {
        RewardReceived urere = this.rerr.save(rere);
        return urere;
    }

    @Override
    public RewardReceived findRewardReceived(RewardReceived rere) {
        if (rere.getRewardReceivedID() != null && !rere.getRewardReceivedID().equals("")) {
            return this.rerr.findOne(rere.getRewardReceivedID());
        }else{
            throw new RuntimeException("Tried to update with a null primrerry key");
        }        
    }

}
