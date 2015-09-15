public class MenuClass {
    
    //varaibl declaration     
    private String Main, MainPrice, Dessert, DessertPrice, Drink, DrinkPrice;
     
     public MenuClass(){//constructor
         
     }
     
     
     //getters and setters
     public String getMain()
      {
         return Main;
      }
     
     public String getMainPrice()
      {
         return MainPrice;
      }
     
     public String getDessert()
      {
         return Dessert;
      }
     
     public String getDessertPrice()
      {
         return DessertPrice;
      }
     
     public String getDrink()
      {
         return Drink;
      }
     
     public String getDrinkPrice()
      {
         return DrinkPrice;
      }
     
     
     
     protected void setMain(String iMain)
      {
         this.Main = iMain;
      }
     
     protected void setMainPrice(String iMainPrice)
      {
         this.MainPrice = iMainPrice;
      }
     
     protected void setDessert(String iDessert)
      {
         this.Dessert = iDessert;
      }
     
     protected void setDessertPrice(String iDessertPrice)
      {
         this.DessertPrice = iDessertPrice;
      }
     
     protected void setDrink(String iDrink)
      {
         this.Drink = iDrink;
      }
     
     protected void setDrinkPrice(String iDrinkPrice)
      {
         this.DrinkPrice = iDrinkPrice;
      }
}
