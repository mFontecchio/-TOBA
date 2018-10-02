/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.reportsServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import toba.dbUtil.DBUtil;
import toba.user.User;

/**
 *
 * @author mFontecchio
 */
@WebServlet(name = "ReportsServlet", urlPatterns = {"/admin/ReportsServlet"})
public class ReportsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/admin/login_error.jsp";
        String action = request.getParameter("action");
        
        if (action==null) {
            action = "fail";
        }
        if (action.equals("fail")) {
            url = "/admin/login_error.jsp";
        }
        else if (action.equals("viewReport")) {
            HttpSession session = request.getSession();
            List<User> newUsers = selectNewUsers();
            session.setAttribute("newUsers", newUsers);
            
            url = "/admin/reports.jsp";
        }
        else if (action.equals("exportReport")) {
            List<User> newUsers = selectNewUsers();
            
            //print reports to xml file for download.
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("New users");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Users Registered this month");
            
            try {
                int r = 2;
                for (User user: newUsers) {
                    row = sheet.createRow(r);
                    row.createCell(0).setCellValue(user.getRegisteredDate().toString());
                    row.createCell(1).setCellValue(user.getUserId());
                    row.createCell(2).setCellValue(user.getUserName());
                    r++;
                }
            } catch (Exception e) {
                this.log(e.toString());
            }
            response.setHeader("content-disposition",
                    "attachment; filename=users.xls");
            response.setHeader("cache-control", "no-cache");
            
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.close();
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    //Select Users Method
    public static List<User> selectNewUsers() {
        Date todaysDate = new Date();
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                //"WHERE month(u.registeredDate) = month(CURRENT_DATE); ";
                "WHERE EXTRACT(YEAR FROM u.registeredDate) = EXTRACT(YEAR FROM :todayM) " +
                "AND EXTRACT(MONTH FROM u.registeredDate) = EXTRACT(MONTH FROM :todayM)";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("todayM", todaysDate);
        
        List<User> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        }finally {
            em.close();
        }
        return users;
    }
}
