
public class Starter {
    
    public Starter(){//constructor
        
    }
    //variable declarations
    private String Starter, StarterPrice;
    
    //getters and setters
    public String getStarter()
      {
         return Starter;
      }
     
     public String getStarterPrice()
      {
         return StarterPrice;
      }
     
     protected void setStarter(String iStarter)
      {
         this.Starter = iStarter;
      }
     
     protected void setStarterPrice(String iStarterPrice)
      {
         this.StarterPrice = iStarterPrice;
      }
}
