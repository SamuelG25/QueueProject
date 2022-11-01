
package project;

import java.util.*;


public class StockLedger {
    
    Queue<StockPurchase > ledger = new  LinkedList();
    
    protected void buy(int sharesBought, int pricePerShare)
    {
            //Creates a new purchase and sets the amount and cost
            StockPurchase purchase = new StockPurchase();
            purchase.amount = sharesBought;
            purchase.cost = pricePerShare;
            ledger.add(purchase);
        
    }
    
    protected int sell(int sharesSold, int pricePerShare)
    {
        int capital = 0;
        int sharesAmount = 0;
        
        //Checks to see if the ledger if empty
        if (!ledger.isEmpty())
        {
        sharesAmount = ledger.peek().amount;
        }
        else 
        {
            return capital;
        }
        
        //if the shares sold is less than the current total amount
        //subtract shares sold from amount
        if(sharesSold < sharesAmount && sharesAmount != 0)
        {
            
                capital = ((pricePerShare * sharesSold)- (ledger.peek().cost * sharesSold));
                ledger.peek().amount -= sharesSold;
                sharesSold -= 0;
        }
        /* 
        if the shares sold is greater than current amount subtract all 
        that is needed and remove the that stock purchase until shares sold
        is at 0.
        */
        if (sharesSold >= sharesAmount)
        {
            
            while(sharesSold != 0 && !ledger.isEmpty())
            {
                int amount = 0;
                if (ledger.peek().amount < sharesSold)
                {
                    amount = ledger.peek().amount ;
                }
                else if(ledger.peek().amount == sharesSold)
                {
                    amount = sharesSold;
                }
                
                int totalCost = (ledger.peek().cost * (amount));
                int totalSell = (amount * pricePerShare);
                
                capital += (totalSell - totalCost);
                
                sharesSold -= amount;
                ledger.peek().amount -= amount;
                
                if (ledger.peek().amount <= 0)
                 ledger.remove();
                        
            }
        }
            return capital;
            }
        }
        
        
    
    
   
    
   

    
    

