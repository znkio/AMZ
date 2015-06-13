package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Company;
import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    boolean deleteCompany(Company com);

    Company updateCompany(Company com);

    Company findCompany(Company com);

    List<Company> findProximal(String longitude, String latitude,String radius);
}
