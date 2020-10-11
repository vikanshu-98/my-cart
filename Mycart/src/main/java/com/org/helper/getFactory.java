 
package com.org.helper;

 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class getFactory {
   private  static SessionFactory factory;
   public static SessionFactory getSessionFactory(){
   try{
   if(factory==null)
   factory=    new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   
   
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  return factory; 
   }
   public static void isClosed(){
   if(!factory.isClosed())
  factory.close();
       }
   
   
    
}
