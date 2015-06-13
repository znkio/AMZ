package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Achievement;
import com.io.znk.ctalin.repository.jpa.AchievementRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    AchievementRepository ar;

    @Override
    public List<Achievement> findAll() {
        List<Achievement> ret = new ArrayList();
        ret = this.ar.findAll();
        return ret;
    }

    @Override
    public boolean deleteAchievement(Achievement ach) {
        try {
            this.ar.delete(ach);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Achievement updateAchievement(Achievement ach) {
        Achievement uach = this.ar.save(ach);
        return uach;
    }

    @Override
    public Achievement findAchievement(Achievement ach) {
        if (ach.getAchievementID() != null && !ach.getAchievementID().equals("")) {
            return this.ar.findOne(ach.getAchievementID());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
