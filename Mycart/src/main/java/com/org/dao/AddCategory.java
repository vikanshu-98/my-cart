 
package com.org.dao; 

import com.org.entities.category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AddCategory {
  private static  SessionFactory factory;

    public AddCategory(SessionFactory factory) {
    this.factory=factory;
    }
    public boolean addCategory(String cat_type,String cat_Desc){
    boolean flag=false;
        try{
        Session session = this.factory.openSession();
        if(cat_type.isEmpty() ||cat_Desc.isEmpty() )
        {
        flag=false;
       
        }
        else{           category cat=new category();
            cat.setCatType(cat_type);
            cat.setCatDescription(cat_Desc);
            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
            flag=true;
            session.close();
        }}
    catch(Exception e){
    e.printStackTrace();
    }
    return flag;
    }
    public List<category> getAllCategory(){
  List<category>list=null;
        try{
      Session session = this.factory.openSession();
      Query query = session.createQuery(" from category");
       list  = query.list();
   }
    catch(Exception e){
    e.printStackTrace();
    
    }
   return  list;
    
    }
    
    
  public category categoryName(int id){
    category  category=null;
    try{
      Session session = this.factory.openSession();
      Query query = session.createQuery("from category where catID=:v");
    query.setParameter("v",id);
      category uniqueResult = (category)query.uniqueResult();
  category=uniqueResult;
    }
    catch(Exception e){
    e.printStackTrace();}
    return category;
    
    }
    
  
    
}
