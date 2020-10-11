<%-- 
    Document   : navbar
    Created on : Jul 7, 2020, 10:31:17 PM
    Author     : shivani chauhan
--%>
<%@page import="com.org.entities.category"%>
<%@page import="java.util.List"%>
<%@page import="com.org.helper.getFactory"%>
<%@page import="com.org.dao.AddCategory"%>
<%@page import="com.org.entities.user"%>
<%@include file="common_nav_css_js.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Shop</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark custom-bg">
            <div class="container">
                 <a class="navbar-brand" href="index.jsp">MyShop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
     
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
Categories
        </a>
          <%
          AddCategory ob1=new AddCategory(getFactory.getSessionFactory());
          List<category> l1=ob1.getAllCategory();
          
          
          %>
          
          
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <%
        for(category c:l1){
        
        %>
        <a class="dropdown-item" href="index.jsp?category=<%=c.getCatID()%>"><b><%=c.getCatType()  %></b></a>
            
        <%}%>
        </div>
      </li>
       
    </ul><%
 user user1=(user)session.getAttribute("current-user");
 
    if(user1==null){
    %>
                <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
                 <a class="nav-link" href="LogIn">Login</a>
            </li>
        <li class="nav-item active">
                 <a class="nav-link" href="register.jsp">Register</a>
            </li>
        
      </ul>
    <%
        }
else{
if(user1.getUserType().equals("admin"))
{
 %>
 
 <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
                 <a class="nav-link text-uppercase"   href="admin.jsp"><%=user1.getUserName()  %></a>
            </li>
        <li class="nav-item active">
                 <a class="nav-link" href="logout"> LogOut</a>
            </li>
        
      </ul>
 
 
<%
}
else{
    %>
 <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
                 <a class="nav-link text-uppercase" data-toggle="modal" data-target="#exampleModal" href="#"><%=user1.getUserName()  %></a>
            </li>
        <li class="nav-item active">
                 <a class="nav-link" href="logout"> LogOut</a>
            </li>
        
      </ul>
 
      
      
      
      <%}
}%>       </div>
                  
            
  
                
            </div>
</nav>
     <!-- Button trigger modal -->
 
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h5 class="modal-title text-light " id="exampleModalLabel">Your Profile is......!!!</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action=" " method="post"> 
          <table class="table">
  
  <tbody>
      <% 
      if(user1!=null){
      %>
  <tr>
       <th>Name</th>
       <td><input readonly  type="text" class="form-control" value="<%=user1.getUserName()%>"   name="username" ></td>
       
    </tr>
    <tr>
        <th>Email</th>
        <td><input type="text" readonly  class="form-control" name="email" value="<%=user1.getUserEmail() %>"/></td>
        
    </tr>
    <tr>
        <th>Mobile Number</th>
        <td><input type="text" readonly  class="form-control" name="email" value="<%=user1.getUserMobile()%>"/></td>
        
    </tr>
    <tr>
        <th>Address</th>
        <td><textarea name="address" style="height: 100px" class="form-control" readonly><%=user1.getUserAddress() %></textarea> </td>
        
    </tr>
    
    
    
    
    
     <%}%>
  </tbody>
  
</table>
  <div class="container text-center">
      <a class="btn btn-outline-success" href="#" data-toggle="modal" data-target="#UpdateModal">Want to Update The Detail</a>
  </div>  
          </form>       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       </div>
    </div>
  </div>
</div>
  
  <!--second modal for update the information-->
  
  <!-- Button trigger modal -->
 
<!-- Modal -->
<div class="modal fade" id="UpdateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h5 class="modal-title text-light" id="exampleModalLabel">Update The Information here.....!!!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action="Updatedetailsofuser" method="post">
          <table class="table">
  <thead>
    <tr>
       
      <th scope="col">Details</th>
      <th scope="col">Chages information</th>
    
    </tr>
  </thead>
 
  <tbody>
      <% if(user1 !=null)  {%>
    <tr>
       <input type="hidden" value="<%=user1.getUserId() %>" name="user"/>
        <th>Name</th>
      <td><input    type="text" class="form-control" value="<%=user1.getUserName() %>"   name="username" ></td>
       
     </tr>
     <tr>
      
        <th>Email</th>
      <td><input    type="text" class="form-control" value="<%=user1.getUserEmail() %>"   name="email" ></td>
       
     </tr>
     <tr>
      
        <th>Mobile Number</th>
      <td><input    type="number" class="form-control" value="<%=user1.getUserMobile() %>"   name="mobile" ></td>
       
     </tr>
     <tr>
      
        <th>Password</th>
      <td><input    type="text" class="form-control" value="<%=user1.getUserPassword() %>"   name="password" ></td>
       
     </tr>
     <tr>
      
        <th>Address</th>
        <td> <textarea name="address"  style="height:150px" required class="form-control"><%=user1.getUserAddress() %></textarea></td>
       
     </tr>
    
 <%}%>
  </tbody>
</table>  
        <div class="container text-center">
            <button class="btn btn-outline-success">Update Details</button>
        </div>
        
        
          </form>        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
         
      </div>
    </div>
  </div>
</div>
  
  
  
  
  
    </body>
</html>
