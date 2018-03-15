//Alexandru Lapsin
import java.util.*;
public class paycheck_2 
{ 
   public static final double HOUR_RATE = 26, OVERTIME_MULTIP = 1.5,
                              SS_TAX = 0.06, FED_TAX = 0.15, STATE_TAX = 0.065, 
                              UNION = 11, HEALTH_INS = 35; 
  
   public static void main(String[] args) 
   {  
      Scanner input = new Scanner(System.in);
      
      int depend;
      double grossPay, netPay = 0, num_hours, overtime ;
      char exit;
         
      do{    
         do {
             //Asking user for hours
             System.out.print("\n*******************************\n" +
                                "How many hours this week? >>  ");
             num_hours = input.nextDouble();
            
             //Asking user for dependents 
             System.out.print("How many dependents do you have? >>  ");
             depend = input.nextInt();
             
             //Checking and if any, displaying invalid input
             if(num_hours < 0 || num_hours > 100)
                System.out.println("\n" + num_hours + " is invalid number of hours!!! Please try again.\n");
             if(depend < 0 || depend > 20)
                System.out.println("\n" + depend + " is invalid number of dependents!!! Please try again.\n");
            }
         while(num_hours < 0 || num_hours > 100 || depend < 0 || depend > 20);   //Validating input for hours and dependents     
         
         //Displaying info
         System.out.println("\nHours this week: " + num_hours + "   Hourly rate: $" + HOUR_RATE);
         
         grossPay = num_hours * HOUR_RATE;//calculating gross income
         
         //Checking and calculating overtime
         if (num_hours > 40) 
         {  
            overtime = (num_hours - 40)*(OVERTIME_MULTIP * HOUR_RATE);
            grossPay += overtime;                                       //update gross income
            System.out.println("\nOvertime: $" + overtime +
                                  "\nTOTAL GROSS INCOME: $" + grossPay + 
                                  "\n----------------------------");
         }
         else 
         {
            System.out.println("\nNo overtime recorded" +
                                  "\nTOTAL GROSS INCOME: $" + grossPay+
                                  "\n----------------------------");
         }
           
         double ss =  (grossPay * SS_TAX),  //Calculating taxes
                 fed = (grossPay * FED_TAX),
                 state = (grossPay * STATE_TAX);
                 
         //Displaying witholding amounts
         System.out.println("\nSocial Security TAX: $" + ss + 
                            "\nFederal Income TAX: $" + fed +
                            "\nState Income TAX: $" + state +
                            "\nUnion Fee: $" + UNION);
        
        
         //Calculating the net income
         netPay = grossPay - ss - fed - state - UNION;
         
         //Checking dependents
         if (depend >= 2)
         {
            netPay -= HEALTH_INS; //update net income
            System.out.println("Dependents: " + depend + 
                              "\nHealth insurance extra fee: "+ HEALTH_INS +
                              "\n--------------------------------\n" + 
                                "WEEK NET INCOME: " + netPay);
         }       
         else   
            System.out.println("\n-------------------------------\n" + 
                               "WEEK NET INCOME: " + netPay);
      
         System.out.println("\n\nSIGN OUT? Press >> y/n <<");
         exit = input.next().charAt(0);
      }       
      while( exit != 'y');   
   }  
}