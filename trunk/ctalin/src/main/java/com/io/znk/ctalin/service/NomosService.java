package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Nomos;
import java.util.List;


public interface NomosService {

	List<Nomos> findAll();
        
        boolean deleteNomos(Nomos nom);
        
        Nomos updateNomos(Nomos nom);
        
        Nomos findNomos(Nomos nom);
        
}
