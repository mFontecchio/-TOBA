/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.transactionServlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.account.Account;
import toba.accountDB.AccountDB;
import toba.transaction.Transaction;
import toba.transactionDB.TransactionDB;
import toba.user.User;

/**
 *
 * @author mFontecchio
 */
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/user/Account_transactions.jsp";
        
        String action = request.getParameter("action");
        
        if (action==null) {
            action = "fail";
        }
        else if (action.equals("addFunds")) {
            //BigDecimal credit = new BigDecimal(request.getParameter("amount"));
            String credit = request.getParameter("amount");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            
            Account account;
            final Object lock = request.getSession().getId().intern();
            synchronized(lock) {
                account = (Account) session.getAttribute("account");
            }
            
            account.Credit(credit);
            Transaction transaction = new Transaction(account, true, credit);
            AccountDB.update(account);
            TransactionDB.insert(transaction);
            List<Transaction> transactions = TransactionDB.selectTransactions(account);
            session.setAttribute("transactions", transactions);
            url = "/user/Account_activity.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}