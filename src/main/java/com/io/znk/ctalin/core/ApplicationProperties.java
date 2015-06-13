/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexis-Dionisis
 */
@Service
public class ApplicationProperties {
    private Map<String,String> applicationProperties;
    
    public String getProperty(String key){
        
        if(this.applicationProperties == null){
            this.applicationProperties=createApplicationProperties();
        }
        
        return this.applicationProperties.get(key);
    }
    
    private Map<String,String> createApplicationProperties(){
        Map<String,String> props = new HashMap<>();
        props.put("foursquare.user", "Q0UFMZFSGOTTKNVZ3CQ2XCYJJKTLEJRFXISM1ALSPNYVRR2U");
        props.put("foursquare.pass", "IJUGGUKL24X4ZYD0QVJKJYKLP0N1DXULWHCWDBS0ESZ1QNN2");
        props.put("foursquare.version", "20151006");
        return props;
    }
    
}
