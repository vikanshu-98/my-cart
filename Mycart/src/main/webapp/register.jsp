<%-- 
    Document   : register
    Created on : Jul 7, 2020, 10:54:20 PM
    Author     : shivani chauhan
--%>
<%@include file="component/navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-md-4 offset-md-4">
                    
                    <div class="card custom-border ">
                        <%@include file="component/message.jsp" %>
  <div class="card-body">
      
      <center> <img  src="image/signup.png" style="max-height: 90px"> <h4>Sign Up here!!!</h4></center>
      <form action="sign-up" method="post">
  <div class="form-group">
    <label for="Name">User Name</label>
    <input type="text" class="form-control" id="Name" name="name" placeholder="Enter Name" aria-describedby="emailHelp">
     </div>
          <div class="form-group">
    <label for="exampleInputEmail1"> User Email </label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter Email" aria-describedby="emailHelp">
     </div>
  <div class="form-group">
    <label for="exampleInputPassword1"> User Password</label>
    <input type="password" class="form-control"placeholder="Enter Password" name="password" id="exampleInputPassword1">
  </div>
 <div class="form-group">
    <label for="phone">User Phone</label>
    <input type="text" class="form-control" id="Phone"   name="phone" placeholder="Enter Phone" />
     </div>
 <div class="form-group">
    <label for="address">User Address</label>
   
    <textarea class="form-control" style="height: 200px" name="address" placeholder="Enter your Address"></textarea>
 </div>
                   
          <div class="container mt-2 text-center">
              <button class="btn btn-outline-success">Register</button>
              &nbsp;&nbsp;
            <input type="reset" class="btn btn-outline-danger"></input>
               
              
          </div>
</form>
     
      
      
      
      
       </div>
</div>
                    
                </div>
            </div>
                 
        </div> 


    </body>
</html>
