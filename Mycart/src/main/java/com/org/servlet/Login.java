 
package com.org.servlet;

import com.org.dao.LoginDao;
import com.org.entities.user;
import com.org.helper.getFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html"); 
       try{
         PrintWriter out = resp.getWriter();
    String email=req.getParameter("email");
        String password = req.getParameter("password");
     
      LoginDao ob1=new LoginDao(getFactory.getSessionFactory());
    user user = ob1.getEmailAndPassword(email, password);
    
             HttpSession session = req.getSession();
     
             if(user==null)
             {
             session.setAttribute("message", "user Not Found!! Please Register First..");
             resp.sendRedirect("LogIn");
             }
             else{
                 //admin page
                 if(user.getUserType().equals("admin")){
                session.setAttribute("message", "LogIn Successfull...!!!");
                 session.setAttribute("current-user", user);
                 resp.sendRedirect("admin.jsp");
                 }
                                //normal page
                 
                if(user.getUserType().equals("normal"))
                 {
                 
                     
                        session.setAttribute("current-user", user);
resp.sendRedirect("normal.jsp");
                 
                 
                 }    
                 
                 
                 
                 
                 
             }
       }
       catch(Exception e){
       e.printStackTrace();
       }
    }
    
}
