/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.login;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.account.Account;
import toba.accountDB.AccountDB;
import toba.passwordUtil.PasswordUtil;
import toba.transaction.Transaction;
import toba.transactionDB.TransactionDB;
import toba.user.User;
import toba.userDB.UserDB;

/**
 *
 * @author mFontecchio
 */
public class LoginServlet extends HttpServlet {

    //GET Method
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    //POST method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/user/login.html";
        
        String action = request.getParameter("action");
        
        if (action==null) {
            action = "fail";
        }
        if (action.equals("fail")) {
            url = "/user/Login_failure.html";
        }
        else if (action.equals("userlog")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            
            
            
            /*EH for user login, this is done to redirect to login failure
            instead of the default error page*/
            try {
                //User user = UserDB.selectUser(userName, password);
                User user = UserDB.selectUser(userName);
                Account account = AccountDB.selectAccount(user);
                List<Transaction> transactions = TransactionDB.selectTransactions(account);
                
                //salt test
                String saltedPass = password + user.getSalt();
                String hashPass = PasswordUtil.hashPassword(saltedPass);
            
                // end salt test changed from password
                if (userName.equals (user.getUserName()) && hashPass.equals(user.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("account", account);
                    session.setAttribute("transactions", transactions);
                    url = "/user/Account_activity.jsp";
                }
                else {
                    url = "/user/Login_failure.html";
                }
                
            } catch(Exception e) {
                url = "/user/Login_failure.html";
            }
        }
        else if (action.equals("reset")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String newPassword = request.getParameter("newPassword");
            
            try {
                //
                String saltedPass = newPassword + user.getSalt();
                String hashPass = PasswordUtil.hashPassword(saltedPass);
            //
                user.setPassword(hashPass);
            
                session.setAttribute("user", user);
                UserDB.update(user);
                url = "/user/Account_activity.jsp";
            } catch (Exception e) {
                url = "/user/Login_failure.html";
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
