package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Achievement;
import java.util.List;


public interface AchievementService {

	List<Achievement> findAll();
        
        boolean deleteAchievement(Achievement ach);
        
        Achievement updateAchievement(Achievement ach);
        
        Achievement findAchievement(Achievement ach);
}
