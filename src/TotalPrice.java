public class TotalPrice {
    //variable declarations
    String OrderID;
    String TableNum;
    String Employee;
    String TotalPrice;
    
    //constructor
    public TotalPrice(){
        
    }
    
    //getters and setters
    public String getOrderID(){
          return OrderID;
      }
      public String getTableNum(){
          return TableNum;
      }
      public String getEmployee(){
          return Employee;
      }
      public String getTotalPrice(){
          return TotalPrice;
      }
      
      public void setOrderId(String iOrderID){
          this.OrderID = iOrderID;
      }
      
      public void setTableNum(String iTableNum){
          this.TableNum = iTableNum;
      }
      public void setEmployee(String iEmployee){
          this.Employee = iEmployee;
      }
      public void setTotalPrice(String iTotalPrice){
             
           this.TotalPrice = iTotalPrice;  
         }
}
