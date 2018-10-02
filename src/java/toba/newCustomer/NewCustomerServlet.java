/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.newCustomer;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.account.Account;
import toba.accountDB.AccountDB;
import toba.passwordUtil.PasswordUtil;
import toba.user.User;
import toba.userDB.UserDB;

/**
 *
 * @author mFontecchio
 */
public class NewCustomerServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/user/New_customer.jsp";
        ArrayList<String> formData = new ArrayList<>();
        BigDecimal startingBalance = new BigDecimal("25.00");
        
        String action = request.getParameter("action");
        if (action==null) {
            action = "fail";
        }
        else if (action.equals("addCustomer")) {
            
            formData.add(request.getParameter("firstName"));
            formData.add(request.getParameter("lastName"));
            formData.add(request.getParameter("phoneNumber"));
            formData.add(request.getParameter("address"));
            formData.add(request.getParameter("city"));
            formData.add(request.getParameter("state"));
            formData.add(request.getParameter("zipCode"));
            formData.add(request.getParameter("email"));
            
           //Create user and account objects
            User user = new User(formData.get(0), formData.get(1), formData.get(2), formData.get(3), formData.get(4), 
                    formData.get(5), formData.get(6), formData.get(7));
            
            Account account = new Account(user, startingBalance);
            
            String message;
            
            //Invalid/Missing Field
            if (validateForm(formData)) {
                message = "Please fill out all fields.";
                request.setAttribute("user", user);
                url = "/user/New_customer.jsp";
            }
            //All fields complete
            else {
                message = "";
                url = "/user/Success.jsp";
                
                String saltedPass = user.getPassword() + user.getSalt();
                try {
                    user.setPassword(PasswordUtil.hashPassword(saltedPass));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(NewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                UserDB.insert(user);
                AccountDB.insert(account);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("account", account);
            }
            request.setAttribute("message", message);
        }
        //redirect response
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    public static boolean validateForm(ArrayList<String> form){
            boolean inValid = false;
            for (String i: form) {
                if (i.isEmpty()) {
                    inValid = i.isEmpty();
                    break;
                }
            }
            return inValid;
        }
}
