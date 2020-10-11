/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.servlet;

import com.org.dao.updateUserInformation;
import com.org.entities.user;
import com.org.helper.getFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shivani chauhan
 */
public class updateInformation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
   try{
       int id_user = Integer.parseInt(req.getParameter("user")); 
   
       String name = req.getParameter("username");
       String email = req.getParameter("email");
       String mobile = req.getParameter("mobile");
       String password = req.getParameter("password");
      String address = req.getParameter("address");
     // out.print(id_user);
  //out.print(name+" "+id_user+" "+mobile+" "+password);  
//  int user_id = Integer.parseInt(req.getParameter("user_id"));
updateUserInformation ob1=new updateUserInformation(getFactory.getSessionFactory());
       user user = ob1.informationUpdatedOfUser(id_user);
user.setUserName(name);
user.setUserEmail(email);
user.setUserMobile(mobile);
user.setUserPassword(password);
user.setUserAddress(address);
     boolean saveUser = ob1.saveUser(user);
       HttpSession session = req.getSession();
     
if(saveUser){
           
 session.setAttribute("message", "Profile Successfully updated.....");
    
 resp.sendRedirect("index.jsp");

}
else{ 
    session.setAttribute("message", "Profile not updated!! Try Again!!.....");
    resp.sendRedirect("index.jsp");
            
}

   }
   catch(Exception e){
   e.printStackTrace();
   }
    
    
    
    }
    
}
