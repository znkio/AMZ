package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Achievementcustomer;
import java.util.List;


public interface AchievementcustomerService {

	List<Achievementcustomer> findAll();
        
        boolean deleteAchievementcustomer(Achievementcustomer ach);
        
        Achievementcustomer updateAchievementcustomer(Achievementcustomer ach);
        
        Achievementcustomer findAchievementcustomer(Achievementcustomer ach);
}
