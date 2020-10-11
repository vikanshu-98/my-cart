/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.dao;

import com.org.entities.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author shivani chauhan
 */
public class updateUserInformation {
   private SessionFactory factory;
private Session session;
    public updateUserInformation(SessionFactory factory) {
        this.factory = factory;
    }
 public user informationUpdatedOfUser(int id){
 user user=null;
     try{
       session = this.factory.openSession();
      user = session.get(user.class, id); 
  
  
 session.close();
 }
 catch(Exception e)
 {
 e.printStackTrace();}
 
 return user;
 
 }
 public boolean  saveUser(user user){
boolean flag=false;
  session   = this.factory.openSession();
  session.beginTransaction();
 
session.update(user);
session.getTransaction().commit();
 flag=true;
 
    return flag;
}
}