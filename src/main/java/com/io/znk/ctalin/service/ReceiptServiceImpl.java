package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Company;
import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Receipt;
import com.io.znk.ctalin.repository.jpa.CompanyRepository;
import com.io.znk.ctalin.repository.jpa.ReceiptRepository;
import com.io.znk.ctalin.repository.jpa.RewardReceivedRepository;
import com.io.znk.ctalin.repository.jpa.RewardsRepository;
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
    @Autowired
    RewardsRepository rewardsRepository;
    @Autowired
    RewardReceivedRepository receivedRepository;
    @Autowired
    CompanyRepository companyRepository;

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
        if (cus.getReceiptId() == null) {
            return null;            
        }
        return this.cur.findOne(cus.getReceiptId());

    }

    @Override
    public List<Receipt> findByCustomer(Customer customer) {
        return this.cur.findByCustomerID(customer);
    }

    //main receipt registration method.All events here!
    @Override
    public Receipt createReceipt(Receipt receipt) {
        //check if it was a customer request
        if (receipt.getCustomerID() != null && triggeredRewards()) {
            //do something with push notifications
        }

        Company co = receipt.getCompanyID();
        if (co == null) {
            return null;
        } else {
            //search if company is registered.By AFM.the only safe choice
            Company rco = this.companyRepository.findByCompanyAFM(co.getCompanyAFM());
            if (rco != null) {
                //check if the company has claimed its profile
                if (rco.getProvisional()) {
                    //merge them(naively at nulls)
                    if (rco.getAddress() == null && co.getAddress() != null) {
                        rco.setAddress(co.getAddress());
                    }
                    if (rco.getLatitude() == null && co.getLatitude() != null) {
                        rco.setLatitude(co.getLatitude());
                    }
                    if (rco.getLongitude() == null && co.getLongitude() != null) {
                        rco.setLongitude(co.getLongitude());
                    }
                    if (rco.getTitle() == null && co.getTitle() != null) {
                        rco.setTitle(co.getTitle());
                    }
                    if (rco.getFsid() == null && co.getFsid() != null) {
                        rco.setFsid(co.getFsid());
                    }
                    if (rco.getFbid() == null && co.getFbid() != null) {
                        rco.setFbid(co.getFbid());
                    }
                    if (rco.getPhone() == null && co.getPhone() != null) {
                        rco.setPhone(co.getPhone());
                    }
                    rco = this.companyRepository.save(rco);
                    receipt.setCompanyID(rco);
                }
            } else {
                co.setProvisional(true);
                co.setVerified(false);

                co = this.companyRepository.save(co);
                receipt.setCompanyID(co);
            }
            return this.cur.save(receipt);
        }
    }

    private boolean triggeredRewards() {
        //rewards logic here
        return false;
    }
}
