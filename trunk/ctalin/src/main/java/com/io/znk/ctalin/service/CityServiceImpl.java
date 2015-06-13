package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.City;
import com.io.znk.ctalin.repository.jpa.CityRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cr;

    @Override
    public List<City> findAll() {
        List<City> ret = new ArrayList();
        ret = this.cr.findAll();
        return ret;
    }

    @Override
    public boolean deleteCity(City cit) {
        try {
            this.cr.delete(cit);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public City updateCity(City cit) {
        City uach = cr.save(cit);
        return uach;
    }

    @Override
    public City findCity(City cit) {
        if (cit.getCityID() != null && !cit.getCityID().equals("")) {
            return this.cr.findOne(cit.getCityID());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
