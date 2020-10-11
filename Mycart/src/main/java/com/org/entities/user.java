 
package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
   @Column(length=100,name = "user_id")
    private int userId;
@Column(length = 100 ,name = "user_name")
   private String userName;
@Column(length = 100 ,name = "user_email")

   private String userEmail;
@Column(length = 100 ,name = "user_password")

   private String userPassword;
@Column(length =13 ,name = "user_mobile")

private String userMobile;
@Column(length =2000,name = "user_picture")

   private String userPic;
   @Column(length = 2000 ,name = "user_address")
   private String userAddress;
   @Column(name = "user_type")
private String userType;
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public String getUserPic() {
        return userPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public user(int userId, String userName, String userEmail, String userPassword, String userMobile, String userPic, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userPic = userPic;
        this.userAddress = userAddress;
    }

    public user(String userName, String userEmail, String userPassword, String userMobile, String userPic, String userAddress,String userType) {
        
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userPic = userPic;
    
        
        this.userAddress = userAddress;
    this.userType=userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public user() {
    }
    
    
   
    
    
}
