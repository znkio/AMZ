package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Rewards;
import com.io.znk.ctalin.repository.jpa.RewardsRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    RewardsRepository rwr;

    @Override
    public List<Rewards> findAll() {
        List<Rewards> ret = new ArrayList();
        ret = this.rwr.findAll();
        return ret;
    }

    @Override
    public boolean deleteRewards(Rewards rew) {
        try {
            this.rwr.delete(rew);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Rewards updateRewards(Rewards rew) {
        Rewards urew = this.rwr.save(rew);
        return urew;
    }

    @Override
    public Rewards findRewards(Rewards rew) {
        if (rew.getRewardID() != null && !rew.getRewardID().equals("")) {
            return this.rwr.findOne(rew.getRewardID());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
