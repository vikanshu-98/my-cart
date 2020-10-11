/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.dao;

import com.org.entities.product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

 
public class addProducts {
 private SessionFactory factory;

    public addProducts(SessionFactory factory) {
        this.factory = factory;
    }
 
    public boolean  saveProduct(product  p){
  boolean res=false;
        
        try{
   
       Session session = this.factory.openSession();
   session.beginTransaction();
       session.save(p);
     session.getTransaction().commit();
res=true;
     session.close();
   }
   catch(Exception e)
   {
       res=false;
      e.printStackTrace();
   }
    
   return res; 
  }
    public List<product> getAllproducts()
    {
        List<product>pro=null;
        try{
            Session session = this.factory.openSession();
            Query query = session.createQuery("from product_detail");
            pro  = query.list();
        }
        catch(Exception e){
        e.printStackTrace();
        }
        return pro;
    }
public List<product> getAllProductById(int id){
List<product>li=null;
try{
    Session session = this.factory.openSession();
String query="from product_detail as s where s.category.catID=:id";
    Query query1 = session.createQuery(query);
query1.setParameter("id", id);
    li  = query1.list();

}
catch(Exception e)
{
e.printStackTrace();}

return li;
}    
    
}
