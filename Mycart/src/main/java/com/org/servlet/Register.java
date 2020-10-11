 
package com.org.servlet;

import com.org.entities.user;
import com.org.helper.getFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

 
public class Register  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
try{
PrintWriter out=resp.getWriter();
String name=req.getParameter("name");
String email=req.getParameter("email");
String password=req.getParameter("password");
String mobile=req.getParameter("phone");
 
String address=req.getParameter("address"); 

HttpSession session1 = req.getSession();
if(name.isEmpty()){
session1.setAttribute("message","Please!! Enter The Name");
  resp.sendRedirect("register.jsp");

    return;
}
else if(email.isEmpty()){
session1.setAttribute("message","Please!!! Enter The Email");
  resp.sendRedirect("register.jsp");

    return;
}
else if(password.isEmpty()){
session1.setAttribute("message","Please!! Enter The Password");
  resp.sendRedirect("register.jsp");

    return;
}
else if(mobile.isEmpty()){
session1.setAttribute("message","Please!! Enter The Phone Number");
  resp.sendRedirect("register.jsp");

    return;
}
else if(address.isEmpty()){
session1.setAttribute("message","Please!!! Enter The Address");
  resp.sendRedirect("register.jsp");

    return;
}
else{
user ob1=new user(name, email, password, mobile, "default.jpg", address,"normal");
       Session session=getFactory.getSessionFactory().openSession();
       session.beginTransaction();
       
       session.save(ob1);
       session.getTransaction().commit();
   session.close();
   
if(ob1==null)
{
session1.setAttribute("message", "please try again!!!");
  resp.sendRedirect("register.jsp");
     
return;

}
else{   
 session1.setAttribute("message", "Register Successfully!!");
   resp.sendRedirect("register.jsp");
return;
}}}
    catch(Exception e)
    {
    e.printStackTrace();
    }}
    
}
