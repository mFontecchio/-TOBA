/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.loginRequestFilter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import toba.user.User;

/**
 *
 * @author mFontecchio
 */
public class LoginRequestFilter implements Filter{
    
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext sc = filterConfig.getServletContext();
        
        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";
        
        User user = (User) httpRequest.getAttribute("user");
        String userName = user.getUserName();
        
        logString += "user: ";
        if (userName.length() != 0)
            logString += userName;
        else
            logString += "Not found";
        
        /*Unsure of how to implement writing the log to a txt file on the server
        without it returning in the browser instead of a persistant log in one 
        of the directories.*/
        
        sc.log(logString);
        chain.doFilter(httpRequest, response);
    }
    
    @Override
    public void destroy() {
        filterConfig = null;
    }
}
