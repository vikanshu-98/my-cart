<%@page import="com.org.entities.user"%>
<%
user user=(user)session.getAttribute("current-user"); 
 if(user==null){
 session.setAttribute("message","you are not login... please Login first!!!!");
 response.sendRedirect("LogIn");
 return;
 }
 else if(user.getUserType().equals("admin")){
 session.setAttribute("message","you are not able to access this account...!!!!");
 response.sendRedirect("LogIn");
 return;
 }
%> 


<%@include file="component/common_nav_css_js.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Normal Jsp</title>
     <script>
         swal("Good job!", "Login Success..!!!", "success");  
        </script>
    </head>
    <body>
        
        <%@include file="index.jsp" %>
         </body>
</html>
