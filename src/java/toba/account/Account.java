/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import toba.transaction.Transaction;
import toba.user.User;

/**
 *
 * @author mFontecchio
 */
@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column(name="balance", precision=19, scale=2)
    private BigDecimal balance;
    
    @ManyToOne
    private User user;
    
    @OneToMany
    private List<Transaction> transactions;
    
    public Account(){
        
    }
    
    public Account(User user, BigDecimal initBalance) {
        this.balance = initBalance;
        this.user = user;
    }
    
    public Long getAccountId() {
        return accountId;
    }
    
    public BigDecimal getBalance(){
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public User getUser(){
        return user;
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    //Credit/Debit methods
    public void Credit(String addFunds) {
        //this.balance = addFunds.add(this.balance);
        BigDecimal credit = new BigDecimal(addFunds);
        this.balance = credit.add(balance);
    }
    public void Debit(BigDecimal subFunds) {
        this.balance = subFunds.subtract(this.balance);
    }
}
