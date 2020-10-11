 
package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

 @Entity(name = "product_detail")
public class product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "product_id")
private    int pId;
     @Column(name = "product_name")
private String pName;
@Column(length = 3000,name = "product_description")

private String PDescription;
@Column(name = "product_price")

private int pPrice;
@Column(name = "product_quantity")
private int pQuantity;
@Column(name = "product_discount")
private int pDiscount;
@Column(name="product_image")
private String PImage;
@ManyToOne
private category category;

    public product(int pId, String pName, String PDescription, int pPrice, int pQuantity, int pDiscount, String PImage) {
        this.pId = pId;
        this.pName = pName;
        this.PDescription = PDescription;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
        this.pDiscount = pDiscount;
        this.PImage = PImage;
    
        
    }

    public product(String pName, String PDescription, int pPrice, int pQuantity, int pDiscount, String PImage,category catetory) {
        this.pName = pName;
        this.PDescription = PDescription;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
        this.pDiscount = pDiscount;
        this.PImage = PImage;
        this.category=catetory;
    }

    public product() {
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getPDescription() {
        return PDescription;
    }

    public int getpPrice() {
        return pPrice;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public String getPImage() {
        return PImage;
    }

    public category getCategory() {
        return category;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public void setPImage(String PImage) {
        this.PImage = PImage;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public void setCategory(int cat_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
