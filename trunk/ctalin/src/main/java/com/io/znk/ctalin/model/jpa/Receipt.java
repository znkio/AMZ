/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gmotux
 */
@Entity
@Table(name = "receipt")
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r")})
public class Receipt implements Serializable {

    private static final Long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @NotNull
    @Size(min = 1, max = 36)
    private String receiptId;

    @NotNull
    private Long receiptNumber;

    @NotNull
    private Double totalAmount;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @NotNull
    private Double vatAmount;
    @JoinColumn(name = "companyID", referencedColumnName = "companyId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Company companyID;
    @JoinColumn(name = "customerID", referencedColumnName = "customerId")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Customer customerID;
    private Integer tamiaki;
    @Size(min = 1, max = 2000)
    private String qrstring;

    public String getQrstring() {
        return qrstring;
    }

    public void setQrstring(String qrstring) {
        this.qrstring = qrstring;
    }

    public Integer getTamiaki() {
        return tamiaki;
    }

    public void setTamiaki(Integer tamiaki) {
        this.tamiaki = tamiaki;
    }

    public Receipt() {
    }

    public Receipt(String receiptId) {
        this.receiptId = receiptId;
    }

    public Receipt(String receiptId, Long receiptNumber, Double totalAmount, Date transactionDate, Double vatAmount) {
        this.receiptId = receiptId;
        this.receiptNumber = receiptNumber;
        this.totalAmount = totalAmount;
        this.transactionDate = transactionDate;
        this.vatAmount = vatAmount;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Long getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptId != null ? receiptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.receiptId == null && other.receiptId != null) || (this.receiptId != null && !this.receiptId.equals(other.receiptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Receipt[ receiptId=" + receiptId + " ]";
    }

}
