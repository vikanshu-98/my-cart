<%-- 
    Document   : index
    Created on : Jul 7, 2020, 6:31:20 PM
    Author     : shivani chauhan
--%>
 
<%@page import="com.org.entities.product"%>
<%@page import="com.org.dao.addProducts"%>
<%@page import="com.org.entities.category"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.AddCategory"%>
<%@include file="component/navbar.jsp" %>
<%@page import="com.org.mycart.CountWords" %>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.org.helper.getFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>my cart</title>
        
    </head>
    <body>
     
        
        <div class="container-fluid">
            <%@include file="component/message.jsp" %>
            <div class="row mt-3">
                <div class="col-md-2 ">
                    <div class="list-group">
 <a href="index.jsp?category=all" class="list-group-item list-group-item-action  text-light custom-bg">All Products</a> 

 <%
            //boolean b=false;
         List<product>li2=null;
        addProducts p1=new addProducts(getFactory.getSessionFactory());
         String ca=request.getParameter("category");
         if(ca==null){
        li2=p1.getAllproducts();
         }
         else if(ca.equals("all")){
               li2=p1.getAllproducts();
         }
         else{
         int ids=Integer.parseInt(ca);
         li2=p1.getAllProductById(ids);
         
         
         }
         
         
         AddCategory cat=new AddCategory(getFactory.getSessionFactory());
       List<category> li1= cat.getAllCategory();
     
        %>
   <%
       
   for(category ct:li1){
       
%>
<a href="index.jsp?category=<%= ct.getCatID()%>" class="list-group-item list-group-item-action"><%=ct.getCatType() %></a> 


                    <%}
                    %></div>
                </div>
                 
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-12"> 
                            
                            <div class="card-columns">
                            <%
   for(product ct:li2)
   {
       
%>  
                                
  <div class="card cd">
      <div class="container text-center">
           <img class="card-img-top mt-2"    src="image/products/<%=ct.getPImage() %>" style="width:auto; max-width:100%" alt="Card image cap">
   
      </div>
      <div class="card-body">
      <h5 class="card-title"><%=ct.getpName() %></h5>
      <p class="card-text">
          <%= CountWords.getcount10words(ct.getPDescription())  %>
      </p>
    
   </div>
      <div class="card-footer">
          <button class="btn custom-bg text-light" onclick="addtocart(<%=ct.getpId() %>,'<%= ct.getpName() %>',<%=CountWords.getDiscount(ct.getpPrice(), ct.getpDiscount())  %> )">Add Cart</button>
          <button class="btn btn-outline-success disable"> <i class="fa fa-rupee"></i> <%= ct.getpPrice() %><i>/-</i> 
          <strike class="text-dark "><small class="text-danger"><i class="fa fa-rupee"></i><%= CountWords.getDiscount(ct.getpPrice(), ct.getpDiscount()) %></strike>  <b>    <i class="text-danger"><%=ct.getpDiscount()%>% off</i></b></small>
              
      </button>
      </div>
  </div>
 
          
                                <%}

%>
<%
if(li2.size()==0){
%>
   <script>
 swal("No Products Found....!!!!");  
</script>  

<%}
%>
</div>
                        
                
                            
                            
                        </div>
                    </div>
                </div>
                             
                
                
                
            </div>
        </div>
        </div>
  
</body>
   
</html>
