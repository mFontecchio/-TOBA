/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.transactionDB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import toba.account.Account;
import toba.dbUtil.DBUtil;
import toba.transaction.Transaction;

/**
 *
 * @author mFontecchio
 */
public class TransactionDB {
    //Get User object for login
    public static List<Transaction> selectTransactions(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT t FROM Transaction t " +
                "WHERE t.account = :account";
        TypedQuery<Transaction> q = em.createQuery(qString, Transaction.class);
        q.setParameter("account", account);
        
        List<Transaction> transactions;
        try {
            transactions = q.getResultList();
            if (transactions == null || transactions.isEmpty())
                transactions = null;
        }finally {
            em.close();
        }
        return transactions;
    }
    
    
    //Insert Method
    public static void insert(Transaction transaction) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(transaction);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
