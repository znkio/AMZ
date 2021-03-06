package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Rewardcrit;
import com.io.znk.ctalin.repository.jpa.RewardCritRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RewardCritServiceImpl implements RewardCritService {

    @Autowired
    RewardCritRepository recrr;

    @Override
    public List<Rewardcrit> findAll() {
        List<Rewardcrit> ret = new ArrayList();
        ret = this.recrr.findAll();
        return ret;
    }

    @Override
    public boolean deleteRewardCrit(Rewardcrit recr) {
        try {
            this.recrr.delete(recr);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Rewardcrit updateRewardCrit(Rewardcrit recr) {
        Rewardcrit urecr = this.recrr.save(recr);
        return urecr;
    }

    @Override
    public Rewardcrit findRewardCrit(Rewardcrit recr) {
        if (recr.getRewardCritID() != null && !recr.getRewardCritID().equals("")) {
            return this.recrr.findOne(recr.getRewardCritID());
        }else{
            throw new RuntimeException("Tried to update with a null primrecrry key");
        }        
    }

}
