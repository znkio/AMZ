package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Companycat;
import java.util.List;


public interface CompanyCatService {

	List<Companycat> findAll();
        
        boolean deleteCompanyCat(Companycat comc);
        
        Companycat updateCompanyCat(Companycat comc);
        
        Companycat findCompanyCat(Companycat comc);
        
}
