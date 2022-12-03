/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;
/**
 *
 * @author Seth Montgomery
 */
public class Main 
{
 public static double result = 0.0;         //Constant use varriables
 public static boolean looped = false;
 public static boolean done = false;
 public static boolean calculating = true;
 public static String str;
 public static String op;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     while(!done)   //Interactive loop with user
      {
        Scanner input = new Scanner(System.in);
        double num;
        System.out.println("WARNING no order of operations"); 
         while(calculating) //Loop to calcualte single calculation
         {
            while(true) //Error handling loop
            {
                System.out.println("Please enter a number.");
                str = input.nextLine();
                try
                {
                num = Double.parseDouble(str);
                break;
                }
                catch(NumberFormatException ignore)
                {
                    System.out.println("Invalid input");
                }
            }
            if(looped) //Requirements are different the first loop because "result" is initalized to 0.
            {
                if(op.equals("="))
                {
                    calculating = false;
                }
                else if(op.equals("/"))
                {
                    calculateDiv(result, num);
                }
                else if(op.equals("^"))
                {
                    calculatePwr(result, num);
                }
                else
                {
                    calculateDbl(result, num, op);
                }                
            }       
            while(true) //error handling loop
            {
                System.out.println("Enter the operator, +, -, *, /, %, ^, =."); // % is used as "mod" which shows the remainder of division
                str = input.nextLine();
                if(str.equals("+") | str.equals("-") | str.equals("*") | str.equals("/") | str.equals("%") | str.equals("^") | str.equals("="))
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input");
                }
            }
            op = str;
            if(!looped) //Checks to see if calculation should end
            {
                if(op.equals("="))
                {
                    result = num;
                    calculating = false;
                }
                else
                {
                    result = num;
                }    
                looped = true;   
            }
            else //Checks to see if calculation should end
            {
                if(op.equals("="))
                {
                    calculating = false;
                }
            }
         }
        System.out.println(result);
        System.out.println("Do you want to calculate again?");
        str = input.nextLine();
        if(!(str.equals("yes") || str.equals("Yes"))) //Checks to see if user wants to preform another calculation
        {
           done = true; 
        }
        calculating = true; //Resets constants for next calculation
        result = 0;
        looped = false;
      }
    }
    public static double calculateDbl(double a, double b, String operator) //Used to calcuate basic operations
    {
     if(operator.equals("+"))
     {
       result = (a + b);  
     }
     if(operator.equals("-"))
     {
       result = (a - b);  
     }
     if(operator.equals("*"))
     {
       result = (a * b); 
     }
      if(operator.equals("%"))
     {
       result = (a % b);  
     }
     return result;
    }
     public static double calculateDiv(double a, double b) //Used to calculate division
    {
     result = (a / b);
     return result;
    }
    public static double calculatePwr(double a, double b) //Used to calcuate powers
    {
     result = 1;
     for(int j = 0; j < b; j++)
     {
      result *= a;
     }
     return result;
    }
}