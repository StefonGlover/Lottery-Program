/**
*Programming Project 5: Chapter 6 Lottery Game
*
*This program uses a combination of methods, variabless, loops, conditional statements
*and arrays to create a lottery game.
*@author Stefon Glover
*version 11/13/19
*/

import java.util.Scanner;
import java.util.Arrays;

public class LotteryGame
{
   static final int NUM_DIGITS = 5;
   public static void main(String[] args)
   {
      //Call method for greetings
      greetUser();     
      
      //Call method for lottery numbers
      int[] lottery_Numbers = getLotteryNumbers(); 
      
      //Call method for user's picks
      int[] user_Picks = getUserPicks();
      
      //Call method for matches
      int count = findMatches(lottery_Numbers, user_Picks);
      
      //Output Lottery Numbers header
      System.out.print("\nLottery Numbers: ");
      
      //Loop to output numbers on a single line
      for (int number: lottery_Numbers)
      {
         
         System.out.print(number+" ");
      }
      
      //Number of matches
      System.out.println("\nNumber of matching digits: "+count+"");
      
      //Conditional statement to verify matches
      if (count == NUM_DIGITS)
      {
         System.out.println("GRAND PRIZE WINNER!");
      }
      else
      {
         System.out.println("Sorry, you didn't win.");
      } 
      
      //Test to confirm matches
      System.out.println(Arrays.toString(lottery_Numbers));
      System.out.print(Arrays.toString(user_Picks));
   
      
   }
   
   /**
      Prints greetings to user
      @param does not take any parameters
      @return nothing 
   */
   public static void greetUser()
   {
      System.out.println("       Welcome to the Lottery Game");
      System.out.println("You will pick 5 numbers (0-9) and we will");
      System.out.println("see if you are the Grand Prize Winner!");
      System.out.println();
   }
   
   /**
      Generates random numbers
      @param does not take any parameters
      @return an Array of Int data type 
   */
   public static int[] getLotteryNumbers()
   {
      
      //Declare an Arrray to hold lottery numbers
      int[] lottery_Numbers = new int[NUM_DIGITS];
       
      //Loop to fill the array 
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         lottery_Numbers[i] = (int)(Math.random() * (11 - 1));
      }
      
      //Sorting array and return
      Arrays.sort(lottery_Numbers);
      return lottery_Numbers;
   }
   
   /**
      Obtain numbers from user
      @param does not take any parameters
      @return an Array of Int data type 
   */
   public static int[] getUserPicks()
   {
      //Scanner object for read input
      Scanner in = new Scanner(System.in);
      
      //Array to hold user's number picks
      int[] user_Picks = new int[NUM_DIGITS];
      
      //Loop to prompt user to numbers
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         System.out.print("Enter pick "+(i + 1)+" (0-9): ");
         user_Picks[i] = in.nextInt();
         
         //Validating user's input
         while (user_Picks[i] < 0 || user_Picks[i] > 9)
         {
            System.out.print("ERROR. Please enter a number (0-9): ");
            user_Picks[i] = in.nextInt();
         }
      }
      
      //Sorting and returning picks
      Arrays.sort(user_Picks);
      return user_Picks;
   }
    /**
      Find matches
      @param of two Int[] Arrays
      @return an Int for number of digits
   */
   public static int findMatches(int[] lottery_Numbers, int[] user_Picks)
   {
      //Variable to hold count of matching numbers
      int count = 0;
      
      //Loop for matching
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         //Conditional statements
         if (lottery_Numbers[i] == user_Picks[i])
         {
            count++;
         }
      }
      return count;
   }
}