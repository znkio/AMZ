package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Receipt;
import com.io.znk.ctalin.repository.jpa.ReceiptRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ReceiptRepository cur;

    @Override
    public List<Receipt> findAll() {
        List<Receipt> ret = new ArrayList();
        ret = this.cur.findAll();
        return ret;
    }

    @Override
    public boolean deleteReceipt(Receipt cus) {
        try {
            this.cur.delete(cus);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Receipt updateReceipt(Receipt cus) {
        Receipt uach = this.cur.save(cus);
        return uach;
    }

    @Override
    public Receipt findReceipt(Receipt cus) {
        if (cus.getReceiptId() != null && !cus.getReceiptId().equals("")) {
            return this.cur.findOne(cus.getReceiptId());
        }else{
            throw new RuntimeException("Tried to update with a null primary key");
        }        
    }

}
