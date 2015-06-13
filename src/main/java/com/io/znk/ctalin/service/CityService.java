package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.City;
import java.util.List;


public interface CityService {

	List<City> findAll();
        
        boolean deleteCity(City cit);
        
        City updateCity(City cit);
        
        City findCity(City cit);
        
}
