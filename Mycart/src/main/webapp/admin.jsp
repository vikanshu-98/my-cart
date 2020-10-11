
<%@page import="java.util.Iterator"%>
<%@page import="com.org.entities.category"%>
<%@page import="java.util.List"%>
<%@page import="com.org.helper.getFactory"%>
<%@page import="com.org.dao.AddCategory"%>
<%@page import="com.org.entities.user"%>
<%
user user=(user)session.getAttribute("current-user");
if(user==null)
{
    session.setAttribute("message","you are not login !!! please login first");
response.sendRedirect("LogIn");
return;
}
else{
if(user.getUserType().equals("normal")){
    session.setAttribute("message","you are not admin!! do not access this page");
response.sendRedirect("LogIn");
return;
    
}}

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="container text-center">
            <%@include file="component/message.jsp" %>
            <div class="row mt-3">
                <div class="col-md-4">
                    <div class="card cd">
                        <div class="card-body">
                            <img src="image/users.png" class="img img-fluid" style="max-width:15vh;border-radius: 50%" />
                         <h3 class="text-uppercase font-weight-bold text-muted">Users</h3>
                                 <h3 class="text-uppercase font-weight-bold  text-muted">4544545</h3>
                                      
                        </div>
                    </div>
                </div>
                  <div class="col-md-4">
          <div class="card cd">
        <div class="card-body">
            <img src="image/category.png"  class="img img-fluid" style="max-width:15vh;border-radius: 50%" />
                    <h3 class="text-uppercase font-weight-bold text-muted">Categories</h3>
                                 <h3 class="text-uppercase font-weight-bold  text-muted">4544545</h3>
                                           
                        </div>
  
                    </div>
                </div>  
                <div class="col-md-4">
          <div class="card cd">
      <div class="card-body">
          <img src="image/product.png" class="img img-fluid" style="max-width:15vh;border-radius: 50%" />
                        <h3 class="text-uppercase font-weight-bold text-muted">Products</h3> 
                                 <h3 class="text-uppercase font-weight-bold  text-muted">4544545</h3>
                                         
                        </div>

                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <div class="card cd"  data-toggle="modal" data-target="#Addcategory">
                        <div class="card-body">
                            <img src="image/addcategory.png" class="img img-fluid" style="max-width:15vh;border-radius: 50%" />
                         <h3 class="text-uppercase font-weight-bold text-muted">Add categories</h3>
                                 <h3 class="text-uppercase font-weight-bold  text-muted">4544545</h3>
                                       
                        </div>
                    </div>
                </div>
              <div class="col-md-6">
                  <div class="card cd"  data-toggle="modal" data-target="#AddProducts">
                      <div class="card-body click">
                          <img src="image/product (1).png" class="img img-fluid" style="max-width:15vh;border-radius: 50%" />
                         <h3 class="text-uppercase font-weight-bold text-muted">Add Products</h3>
                                 <h3 class="text-uppercase font-weight-bold  text-muted">4544545</h3>
                                         
                      </div>
                      
                  </div>
                </div>
            </div>
        
        <!-- Button trigger modal -->
 


        </div>
        
        
        <!--add category-->
<!-- Modal -->
<div class="modal fade" id="Addcategory" tabindex="-1" role="dialog" aria-labelledby="Addcategory" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg text-light">
        <h5 class="modal-title" id="exampleModalLabel">Add Categories Here</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <!--start of modal body-->
      <div class="modal-body">
          <!--start of form of modal of add catgory-->
          <form action="Category" method="post">
                  <input type="hidden" name="Details" value="category" />
  <div class="form-group">
    <label for="Category Type">Type Of Category</label>
 
    <input type="text" class="form-control" id="category" name="category-type" aria-describedby="emailHelp" placeholder="Enter the type of category">

  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Category Description</label>
    <textarea  class="form-control"  style="height:25vh;" name="category-description" placeholder="Enter the category description"></textarea>   
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary custom-bg">Add Category</button>
  </div>
         </form>
      </div>
        <!start of modal-footer-->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
<!--end of add category-->

 
 
<!-- start of add products-->

<div class="modal fade" id="AddProducts" tabindex="-1" role="dialog" aria-labelledby="Addproducts" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content ">
      <div class="modal-header custom-bg">
        <h5 class="modal-title custom-bg text-light" id="exampleModalLabel">Add Products Here </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        
        
        
        
        
        
      <div class="modal-body">
        
          
          
          
          
          <!--start of form of modal of add catgory-->
         
        <form action="Category" method="post" enctype="multipart/form-data">
             <input type="hidden" name="Details" value="products" />
  <div class="form-group">
   
      
    <input type="text" class="form-control" id="p-name" name="product-name" aria-describedby="emailHelp" placeholder="Enter the tittle of product">

  </div>
  
         
       <div class="form-group">
    <!--<label for="Category Type">Product Price</label>
    -->
    <input type="number" class="form-control" id="p-price" name="product-price" aria-describedby="emailHelp" placeholder="Enter the Price of product">

  </div>       
              
              <div class="form-group">
    <!--<label for="Category Type">Product Quantity</label>
     -->
     <input type="number" class="form-control" id="p-quantity" name="product-quantity" aria-describedby="emailHelp" placeholder="Enter the Quantity of product">

  </div>  
             
                  <div class="form-group">
    <!--<label for="exampleInputPassword1">Product Description</label>
    -->
    
    <textarea  class="form-control"  style="height:20vh;" name="product-description" placeholder="Enter the description of product"></textarea>   
  </div>    
              
             <div class="form-group">
 <%
AddCategory ob=new AddCategory(getFactory.getSessionFactory());
 List<category> cat1=ob.getAllCategory();
 
%>

                     <!--<label for="Category Type">Product Category</label>
                      -->
                      
                 <select class="form-control" name="addcategory"  >
                     <%
                     for(category cat:cat1)
                     { %>
                     <option    value="<%=cat.getCatID() %>"><%=cat.getCatType() %> </option>      
                 <%}%>
                 
                 </select>
                   
                 
             </div>
             
              
              <div class="form-group">
    <!--<label for="Category Type">Product Discount</label>
     -->
     <input type="number" class="form-control" id="p-discount" name="product-discount" aria-describedby="emailHelp" placeholder="Enter the Discount on product">

  </div>        
              
              
      
                 <div class="form-group">
    <label for="Category Type">select the picture of product</label>
    <br>
    <input type="file"  name="product-image" />
  </div>     
              
              
              
  <div class="container text-center">
  <button type="submit" class="btn btn-primary custom-bg">Add Products</button>
  </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<!-- end of add products-->
        
    </body>
</html>
