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
 public static int result = 0;
 public static double result2 = 0.0;
 public static boolean done = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     while(!done)
      {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number.");
        String str = input.nextLine();
        int firstNum = Integer.valueOf(str);
        System.out.println("Enter second number.");
        str = input.nextLine();
        int secondNum = Integer.valueOf(str);
        System.out.println("Enter the operator, +, -, *, /, %, ^.");
        str = input.nextLine();
        System.out.println("first number is " + firstNum);
        System.out.println("second number is " + secondNum);
        System.out.println("the operator selected is " + str); 
        if(str.equals("/"))
         {
            result2 = calculateDbl(firstNum, secondNum, str); 
            if(result >= Double.POSITIVE_INFINITY)
            {
             System.out.println("Undefined");
            }
            else
            {
             System.out.println(result2);
            }
         }
        else if(str.equals("^"))
         {
            result = calculatePwr(firstNum, secondNum, str);
            if(result == 0)
             {
              System.out.println("Are you trying to crash me?");
              str = input.nextLine();
              if(str.equals("yes") || str.equals("Yes"))
               {
                System.out.println("Fine I\'ll shut down.");
                break;  
               }
             }
            else
             {
              System.out.println(result);
             }
         } 
        else
         {
          result = calculateInt(firstNum, secondNum, str);
          System.out.println(result);
         } 
        System.out.println("Are you done?");
        str = input.nextLine();
        if(str.equals("yes") || str.equals("Yes"))
        {
          done = true;  
        }
      }
    }
    public static int calculateInt(int a, int b, String operator)
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
     public static double calculateDbl(double a, double b, String operator)
    {
     result2 = (a / b);
     return result2;
    }
    public static int calculatePwr(int a, int b, String operator)
    {
     result = 1;
     for(int j = 0; j < b; j++)
     {
      result *= a;
     }
     return result;
    }
}