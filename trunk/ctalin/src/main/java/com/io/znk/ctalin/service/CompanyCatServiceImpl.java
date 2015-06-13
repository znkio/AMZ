package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.CompanyCat;
import com.io.znk.ctalin.repository.jpa.CompanyCatRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyCatServiceImpl implements CompanyCatService {

    @Autowired
    CompanyCatRepository ccr;

    @Override
    public List<CompanyCat> findAll() {
        List<CompanyCat> ret = new ArrayList();
        ret = this.ccr.findAll();
        return ret;
    }

    @Override
    public boolean deleteCompanyCat(CompanyCat comc) {
        try {
            this.ccr.delete(comc);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public CompanyCat updateCompanyCat(CompanyCat comc) {
        CompanyCat uach = this.ccr.save(comc);
        return uach;
    }

    @Override
    public CompanyCat findCompanyCat(CompanyCat comc) {
        if (comc.getCatID() != null && !comc.getCatID().equals("")) {
            return this.ccr.findOne(comc.getCatID());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
