class Person_Order{
    //varaible declaration
    String OrderID;
    String starter;
    String main;
    String dessert;
    String drink;
    String price; 
    

   
      public Person_Order(){///constructor
      
         
      
      }
      
      
      //getters and setters
      public String getOrderID(){
          return OrderID;
      }
      public String getStarter(){
      
         return starter;
      
      }
      
      public String getMain(){
      
         return main;
      
      }
      
      public String getDessert(){
      
         return dessert;
      
      }
      
      public String getDrink(){
      
         return drink;
      }
      
      public String getPrice(){
          return price;
      }
      
      
      
      public void setOrderId(String iOrderID){
          this.OrderID = iOrderID;
      }
      
      
      public void setStarter(String iStarter)
      {
         this.starter = iStarter;
      }
      
      public void setMain(String iMain){
      
           this.main = iMain;
      }
      
         public void setDessert(String iDessert){
      
           this.dessert = iDessert;
      }
      
         public void setDrink(String iDrink){
      
           this.drink = iDrink;
      }
         
         public void setPrice(String iPrice){
             
           this.price = iPrice;  
         }
         
        




}
