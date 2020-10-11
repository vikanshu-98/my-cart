 function addtocart(id,name,price){
     let cart=localStorage.getItem("cart");
     if(cart==null){
         product=[]
         var products={"pID":id,"Pname":name,"Pprice":price,"pquantity":1}
    product.push(products)
    localStorage.setItem("cart",JSON.stringify(product));
         
         
     }
     else{
         var c;
         let s1=localStorage.getItem("cart")
         s1.forEach((item)=>{
             if(item.pID==id)
               c=true;  
         });
         if(c){
             document.write("available")
         }
         
         
         
     }
     
     
 }