package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.CompanyCat;
import java.util.List;


public interface CompanyCatService {

	List<CompanyCat> findAll();
        
        boolean deleteCompanyCat(CompanyCat comc);
        
        CompanyCat updateCompanyCat(CompanyCat comc);
        
        CompanyCat findCompanyCat(CompanyCat comc);
        
}
