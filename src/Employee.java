public class Employee {
    //varaible declarations
      private String firstName, lastName, PPSN, position, wage;
      private int employeeID;
   
   
   
   public Employee()//constructor
   {
      
   }

    
   //getters and setters
    public int getEmployeeID()
      {
         return employeeID;
      }


    public String getFirstName()
      {
         return firstName;
      }

    public String getLastName()
      {
         return lastName;
      }
      
      
    public String getPPSN()
      {
         return PPSN;
      }


    public String getWage()
      {
         return wage;
      }


    public String getPosition()
      {
         return position;
      }
     
    protected void setEmployeeID(int iEmployeeID)
      {
         this.employeeID = iEmployeeID;
      }

      
      
    protected void setFirstName(String iFirstName)
      {
         this.firstName = iFirstName;
      }


    protected void setLastName(String iLastName)
      {
          this.lastName = iLastName;
      }


    protected void setPPSN(String iPPSN)
      {
         this.PPSN = iPPSN;
      }


    protected void setWage(String iWage)
      {
         this.wage = iWage;
      }


     protected void setPosition(String iPosition)
      {
         this.position = iPosition;
      }
}
