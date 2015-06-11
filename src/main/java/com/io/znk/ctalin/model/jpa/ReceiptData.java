/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "receiptdata")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long receiptId; /* Μπορούμε να το χρησιμοποιήσουμε σαν CCN αφου αποτελεί το unique id του table*/
    
    @Column
    @NotNull
    private Long issuerAFM;
    
    @Column
    private Long receiptNumber;
    
    @Column
    private Date transactionDate;
    
    @Column
    private Double totalAmount;

    @Column
    private Double vatAmount;

    /***
     * το customerΑFM γίνεται update όταν ο χρήστης κανει submit την αποδειξη στο σύστημα η οποία έγινε insert από την εταιρεία. 
     * Αν δεν υπάρχει επειδή ο καταστηματάρχης ηταν offline  θα γίνεται insert από τον πελάτη.
     */
    @Column
    private Long customerAFM;

    public ReceiptData(Long receiptId, Long issuerAFM, Long receiptNumber, Date transactionDate, Double totalAmount, Double vatAmount, Long customerAFM) {
        this.receiptId = receiptId;
        this.issuerAFM = issuerAFM;
        this.receiptNumber = receiptNumber;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
        this.vatAmount = vatAmount;
        this.customerAFM = customerAFM;
    }

    
    

    public Long getReceiptId() {
        return receiptId;
    }

    public Long getIssuerAFM() {
        return issuerAFM;
    }

    public Long getReceiptNumber() {
        return receiptNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public void setIssuerAFM(Long issuerAFM) {
        this.issuerAFM = issuerAFM;
    }

    public void setReceiptNumber(Long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Long getCustomerAFM() {
        return customerAFM;
    }

    public void setCustomerAFM(Long customerAFM) {
        this.customerAFM = customerAFM;
    }

    @Override
    public String toString() {
        return "ReceiptData{" + "receiptId=" + receiptId + ", issuerAFM=" + issuerAFM + ", receiptNumber=" + receiptNumber + ", transactionDate=" + transactionDate + ", totalAmount=" + totalAmount + ", vatAmount=" + vatAmount + ", customerAFM=" + customerAFM + '}';
    }
    
    
    
    
}
