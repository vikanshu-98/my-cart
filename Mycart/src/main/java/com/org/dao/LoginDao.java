 
package com.org.dao;

 
import com.org.entities.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
 
public class LoginDao {
private SessionFactory factory;
    public LoginDao(SessionFactory factory) {
        this.factory=factory;
    System.out.print(this.factory);
    }
    public user getEmailAndPassword(String email,String password){
    user user=null;
    Session session = this.factory.openSession();
 String qu="from user where userEmail=:e and userPassword=:p";
    Query query = session.createQuery(qu);
   query.setParameter("e", email);
   query.setParameter("p",password);
   user= (user)query.uniqueResult();
    return user; 
    }
 


}