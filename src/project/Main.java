//Samuel Goldthreate
package project;
import java.util.Scanner;  

public class Main {
  
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StockLedger ledger = new StockLedger();
        
        int choice = 3;
        
       do 
       {
           System.out.println("Please Make a Selection");
           System.out.println("2: Buy\n1: Sell\n0: Quit");
           System.out.println("Your Choice:");
           choice = in.nextInt();
           
           switch(choice)
           {
               case 2 : 
               {
                   System.out.println("\nHow many stocks would you like to buy");
                   int amount = in.nextInt();
                   System.out.println("What is the price of each Stock");
                   int price = in.nextInt();
                   
                   ledger.buy(amount, price);
                   
                   System.out.println("\n" + amount + " stocks of $" + price + " each were added to ledger\n");
                   
                  break; 
               } 
               case 1 :
               {
                   int capital = 0;
                   
                   System.out.println("\nHow many stocks would you like to sell");
                   int amount = in.nextInt();
                   System.out.println("What is the price of each Stock");
                   int price = in.nextInt();
                    
                        capital = ledger.sell(amount, price);
                    
                   
                   if (capital > 0)
                    {
                       System.out.println("\nYou made a capital gain of $" + capital + "\n");
                    }
                   else if (capital < 0)
                    {
                       System.out.println("\nYou took a loss of " + capital + "\n");
                    }
                   else
                   {
                       System.out.println("\nYou did not make any gain or take loss\n");
                   }
                   
                   break;
               }
               case 0 :
               {
                   System.out.println("\nGoodbye\n");
                   break;
               }
               default:
               {
                   System.out.println("\nYour choice was not an asnwer!\n");
                   break;
               }
               
           }   
       }while (choice != 0);
       
       
       
    }
}
