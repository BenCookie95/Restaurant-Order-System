
class Dessert {
    public Dessert()//constructor
    {
        
    }
    
    private String Dessert, DessertPrice;//variable declaration
    
    
    //getters and setters
    public String getDessert()
      {
         return Dessert;
      }
     
    public String getDessertPrice()
      {
         return DessertPrice;
      }
    
      protected void setDessert(String iDessert)
      {
         this.Dessert = iDessert;
      }
     
     protected void setDessertPrice(String iDessertPrice)
      {
         this.DessertPrice = iDessertPrice;
      }
     
    
}

