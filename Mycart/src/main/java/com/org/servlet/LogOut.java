 
package com.org.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
try{
resp.setContentType("text/html");
    PrintWriter out = resp.getWriter(); 
    HttpSession session = req.getSession();
session.removeAttribute("current-user");
resp.sendRedirect("LogIn");

}
catch(Exception e){
e.printStackTrace();
}


    }
    
}
