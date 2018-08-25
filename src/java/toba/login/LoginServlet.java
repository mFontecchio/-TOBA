/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            
            //Username and password compare. This will be vastly different
            //when working with the DB. For now we will keep it simple but this
            //will be a seperate validator method later.
            if (userName.equals("jsmith@toba.com") && password.equals("letmein")) {
                url = "/user/Account_activity.html";
            }
            else {
                url = "/user/Login_failure.html";
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
