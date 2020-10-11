 
package com.org.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 

 @Entity
public class category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cat_id")
private int catID;
@Column(name ="cat_type" )
 private String catType;
@Column(name = "cat_description" , length = 1000)
private String catDescription;
@OneToMany(mappedBy = "category")
private List<product>product;
    public category(int catID, String catType, String catDescription) {
        this.catID = catID;
        this.catType = catType;
        this.catDescription = catDescription;
    }

    public category(String catType, String catDescription,List<product>product) {
        this.catType = catType;
        this.catDescription = catDescription;
    this.product=product;
    }

    public int getCatID() {
        return catID;
    }

    public String getCatType() {
        return catType;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public List<product> getProduct() {
        return product;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public void setCatType(String catType) {
        this.catType = catType;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public void setProduct(List<product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "category{" + "catID=" + catID + ", catType=" + catType + ", catDescription=" + catDescription + ", product=" + product + '}';
    }

    public category() {
    }


}
