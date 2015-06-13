package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Company;
import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.repository.jpa.CompanyRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository cmr;
    @PersistenceContext(unitName = "entityManagerFactory")
    EntityManager em;

    @Override
    public List<Company> findAll() {
        List<Company> ret = new ArrayList();
        ret = this.cmr.findAll();
        return ret;
    }

    @Override
    public boolean deleteCompany(Company com) {
        try {
            this.cmr.delete(com);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Company updateCompany(Company com) {
        Company ucom = this.cmr.save(com);
        return ucom;
    }

    @Override
    public Company findCompany(Company com) {
        if (com.getCompanyId() != null && !com.getCompanyId().equals("")) {
            return this.cmr.findOne(com.getCompanyId());
        } else {
            throw new RuntimeException("Tried to update with a null primcmry key");
        }
    }

    @Override
    public List<Company> findProximal(String longitude, String latitude, Integer radius) {
        String querystr = "//todo the query here plus parameters";
        Query q = this.em.createNativeQuery(querystr);
        List<Company> ret = (List<Company>) q.getResultList();
        return ret;
    }
}
