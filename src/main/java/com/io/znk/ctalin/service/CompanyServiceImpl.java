package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Company;
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
    public List<Company> findProximal(String lot, String lat, String radius) {
        String querystr = "SELECT address, title, latitude, longitude, (6371 * acos(cos(radians(?1)) * cos(radians(latitude) ) * cos( radians( longitude ) - radians(?2) ) + sin( radians(?3) ) * sin( radians( latitude ) ) ) ) AS distance FROM company HAVING distance <?4 ORDER BY distance";
        Query q = this.em.createNativeQuery(querystr).setParameter(1, lat).setParameter(2, lot).setParameter(3, lat).setParameter(4, radius);
        List<Company> ret = (List<Company>) q.getResultList();
        return ret;
    }

}
