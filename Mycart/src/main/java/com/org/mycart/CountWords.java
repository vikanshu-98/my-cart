/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.mycart;

/**
 *
 * @author shivani chauhan
 */
public class  CountWords {
   public static String getcount10words(String description) {
   String s=" ";
   
   try{String st[]=description.split(" ");
   if(st.length>10){
   for(int i=0;i<=9;i++){
   s+=st[i]+" ";
   
   }
    
   }
   else{
            for(int i= 0;i<st.length;i++){
                  s+=st[i];        
            
           }
           
           }
   }
   catch(Exception e){
   e.printStackTrace();
   }
    s+=".......";
 return s;
   }
   public  static int getDiscount(int n,int disc){
   int d=0;
       try{
  d= n*100/disc;
   
  
   }
   catch(Exception e){
   e.printStackTrace();}
   
   return d;
   }

   public static String getcount10wordsOfPName(String Pname) {
   String s=" ";
   
   try{
       
       
       String st[]=Pname.split(" ");
   if(st.length>8){
   for(int i=0;i<=7;i++){
   s+=st[i]+" ";
   
   }
    
   }
   else{
            for(int i= 0;i<st.length;i++){
                  s+=st[i];        
            
           }
           
           }
   }
   catch(Exception e){
   e.printStackTrace();
   }
   
 return s;
   }

}
