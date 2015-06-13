package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Nomos;
import com.io.znk.ctalin.repository.jpa.NomosRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NomosServiceImpl implements NomosService {

    @Autowired
    NomosRepository nr;

    @Override
    public List<Nomos> findAll() {
        List<Nomos> ret = new ArrayList();
        ret = this.nr.findAll();
        return ret;
    }

    @Override
    public boolean deleteNomos(Nomos nom) {
        try {
            this.nr.delete(nom);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Nomos updateNomos(Nomos nom) {
        Nomos unom = this.nr.save(nom);
        return unom;
    }

    @Override
    public Nomos findNomos(Nomos nom) {
        if (nom.getNomosID() != null && !nom.getNomosID().equals("")) {
            return this.nr.findOne(nom.getNomosID());
        }else{
            throw new RuntimeException("Tried to update with a null primnry key");
        }        
    }

}
