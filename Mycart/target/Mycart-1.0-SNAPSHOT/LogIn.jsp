
<%@include file="component/navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-3">
                <div class="col-md-4 offset-md-4">
                    <div class="card cust">
                        
                       <div class="card-head custom-bg">
                           
                            <center><img src="image/login (1).png" style="max-width: 40px;" /><h4 class="text-light">LogIn Here!!!</h4></center>
                      </div>
                            <div class="card-body">
                            <%@include file="component/message.jsp" %>
                            <form action="login" method="post"> 
                      <div class="form-group">
    <label for="exampleInputEmail1"> User Email </label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter Email" aria-describedby="emailHelp">
     </div>
  <div class="form-group">
    <label for="exampleInputPassword1"> User Password</label>
    <input type="password" class="form-control"placeholder="Enter Password" name="password" id="exampleInputPassword1">
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
