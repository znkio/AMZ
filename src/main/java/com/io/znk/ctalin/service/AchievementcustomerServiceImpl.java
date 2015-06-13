package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Achievementcustomer;
import com.io.znk.ctalin.repository.jpa.AchievementcustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AchievementcustomerServiceImpl implements AchievementcustomerService {

    @Autowired
    AchievementcustomerRepository ar;

    @Override
    public List<Achievementcustomer> findAll() {
        List<Achievementcustomer> ret = new ArrayList();
        ret = this.ar.findAll();
        return ret;
    }

    @Override
    public boolean deleteAchievementcustomer(Achievementcustomer ach) {
        try {
            this.ar.delete(ach);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Achievementcustomer updateAchievementcustomer(Achievementcustomer ach) {
        Achievementcustomer uach = this.ar.save(ach);
        return uach;
    }

    @Override
    public Achievementcustomer findAchievementcustomer(Achievementcustomer ach) {
        if (ach.getAchievementCustomerID()!= null && !ach.getAchievementCustomerID().equals("")) {
            return this.ar.findOne(ach.getAchievementCustomerID());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
