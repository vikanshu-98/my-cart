/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.servlet;

import com.org.dao.AddCategory;
import com.org.dao.addProducts;
import com.org.entities.category;
import com.org.entities.product;
import com.org.helper.getFactory;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.org.apache.bcel.internal.generic.F2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author shivani chauhan
 */
@MultipartConfig
public class AddCategories  extends HttpServlet{

    @Override
   
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String detailsofchoice = req.getParameter("Details");
        
        HttpSession session=req.getSession();
         
        if(detailsofchoice.equals("category")){
 
        
        String type_cat = req.getParameter("category-type");
        String desc_cat = req.getParameter("category-description");
            AddCategory add=new AddCategory(getFactory.getSessionFactory());
        boolean addCategory = add.addCategory(type_cat, desc_cat);
         if(addCategory)
         {
            session.setAttribute("message"," Hey!!!   Categories Added Successfully!!!");
         resp.sendRedirect("admin.jsp");
         return;
         }
         else
            session.setAttribute("message","Categories Not Added.. Try Again!!!");
         resp.sendRedirect("admin.jsp");
         return;
                }
        else if (detailsofchoice.trim().equals("products")){
        String p_name = req.getParameter("product-name");
        int p_price = Integer.parseInt(req.getParameter("product-price")); 
        int p_quantity = Integer.parseInt(req.getParameter("product-quantity"));
        int p_discount = Integer.parseInt(req.getParameter("product-discount"));
        String p_desciption = req.getParameter("product-description");
        Part p_pic = req.getPart("product-image");
        int cat_id = Integer.parseInt(req.getParameter("addcategory"));
        
            product pd1=new product();
            pd1.setpName(p_name);
            pd1.setpPrice(p_price);
            pd1.setpQuantity(p_quantity);
            pd1.setpDiscount(p_discount);
            pd1.setPDescription(p_desciption);
            pd1.setPImage(p_pic.getSubmittedFileName());
           AddCategory ob1=new AddCategory(getFactory.getSessionFactory());
       category cat = ob1.categoryName(cat_id);
         pd1.setCategory(cat);
        addProducts p1=new addProducts(getFactory.getSessionFactory());
        
boolean result = p1.saveProduct(pd1);
try{
String realPath = req.getRealPath("image")+File.separator+"products"+File.separator+p_pic.getSubmittedFileName();
 //out.print(realPath);
FileOutputStream fo=new FileOutputStream(realPath);
        InputStream is = p_pic.getInputStream();
        byte[] by=new byte[is.available()];
        //out.print(is.available());
        is.read(by);
        fo.write(by);

}
catch(Exception e)
{e.printStackTrace();
}    
       if(result){
        session.setAttribute("message", "Products Added Successfully!!!!");
        resp.sendRedirect("admin.jsp");
        }
        else{
        session.setAttribute("message","oops,product Not Added!!! try again....");
        resp.sendRedirect("admin.jsp");
        }
         
        }
 }
    
}
