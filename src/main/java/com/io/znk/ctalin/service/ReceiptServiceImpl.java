package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Company;
import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Receipt;
import com.io.znk.ctalin.model.jpa.Rewardcrit;
import com.io.znk.ctalin.model.jpa.Rewardreceived;
import com.io.znk.ctalin.model.jpa.Rewards;
import com.io.znk.ctalin.repository.jpa.CompanyRepository;
import com.io.znk.ctalin.repository.jpa.CustomerRepository;
import com.io.znk.ctalin.repository.jpa.ReceiptRepository;
import com.io.znk.ctalin.repository.jpa.RewardReceivedRepository;
import com.io.znk.ctalin.repository.jpa.RewardsRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.httpclient.URI;
import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableScheduling
@EnableAsync
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
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RewardReceivedRepository rewardReceivedRepository;

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
        if (receipt.getCustomerID() != null) {

            Company co = receipt.getCompanyID();
            if (co == null) {
                if (receipt.getReceiptId() == null || receipt.getReceiptId() == "") {
                    return null;
                }
                Receipt tempreceipt = this.cur.findOne(receipt.getReceiptId());
                if(tempreceipt!=null){
                    tempreceipt.setCustomerID(receipt.getCustomerID());
                    this.cur.save(tempreceipt);
                    return tempreceipt;
                }
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
                        receipt = this.cur.save(receipt);

                    }
                } else {
                    co.setProvisional(true);
                    co.setVerified(false);
                    co = this.companyRepository.save(co);
                    receipt.setCompanyID(co);
                    receipt = this.cur.save(receipt);
                }
                this.triggeredRewards(receipt);
                return receipt;
            }
        } else if (receipt.getCustomerID() == null && receipt.getCompanyID() != null && receipt.getCompanyID().getCompanyId() != null) {
            receipt = this.cur.save(receipt);
            String qrstring = "";
            qrstring = "receiptId=" + receipt.getReceiptId() + "&receiptNumber=" + receipt.getReceiptNumber() + "&totalAmount=" + receipt.getTotalAmount() + "&transactionDate=" + receipt.getTransactionDate().getTime() + "&vatAmount=" + receipt.getVatAmount() + "&tamiaki=" + receipt.getTamiaki();
            receipt.setQrstring(qrstring);
            receipt = this.cur.save(receipt);
            return receipt;
        }
        return null;
    }

    private boolean triggeredRewards(Receipt receipt) {
        //get total number of receipts per comp per cust
        List<Receipt> rcl = this.cur.findByCustomerID(receipt.getCustomerID());

        Integer receiptno = rcl.size();
        Double total = 0.0;
        for (Receipt rc : rcl) {
            total += rc.getTotalAmount();
        }
        List<Rewards> rwl = this.rewardsRepository.findByCompanyID(receipt.getCompanyID());
        if (rwl.size() > 0) {
            for (Rewards rw : rwl) {
                Rewardcrit rcrit = rw.getRewardCritID();
                if (this.rewardReceivedRepository.findByRewardIDAndCustomerID(rw, receipt.getCustomerID()).size() > 0) {
                    continue;
                }
                if (rcrit.getAmountMin() <= total || receiptno >= rcrit.getNumReceipts()) {
                    sendPushTelerik(rw.getDescription(), "34t5TpXF6UZmafEg");
                    Rewardreceived rwrd = new Rewardreceived();
                    rwrd.setCustomerID(receipt.getCustomerID());
                    rwrd.setRewardID(rw);
                    rwrd.setDateReceived(new Date());
                    this.rewardReceivedRepository.save(rwrd);
                }
            }
        }
        return false;
    }

    @Async
    public void sendPushTelerik(String message, String telid) {
        try {

            URI uri = new URI("http", "//api.everlive.com/v1/" + telid + "/Push/Notifications", null);
            URL oracle = new URL(uri.getEscapedURI());
            HttpURLConnection conn = (HttpURLConnection) oracle.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept",
                    "text/html,application/xhtml+xml,application/xml;application/json;q=0.9,image/webp,*/*;q=0.8");

            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            String data = "{\"Message\":\"" + message + "\"}";
            writer.write(data);
            writer.flush();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
