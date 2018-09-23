/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import toba.account.Account;

/**
 *
 * @author mFontecchio
 */
@Entity
@Table(name = "History")
public class Transaction implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    
    private boolean credit;
    @Column(name="amount", precision=19, scale=2)
    private BigDecimal amount;
    
    @ManyToOne
    private Account account;
    
    public Transaction() {
        
    }
    
    public Transaction(Account account, boolean type, String amount ) {
        this.account = account;
        this.credit = type;
        this.amount = new BigDecimal(amount);
        this.transactionDate = new Date();
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
    public Date getTransactionDate(){
        return transactionDate;
    }
    public boolean isCredit(){
        return credit;
    }
    public void setCredit(boolean credit) {
        this.credit = credit;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    public Account getAccount(){
        return account;
    }
}

