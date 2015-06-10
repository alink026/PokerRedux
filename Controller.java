import java.util.*;
import java.io.*;
import java.awt.*;

public class Controller
{
   private static Deck deck;
   private static Hand hand1;
   private static Hand hand2;
   private static Draw draw1;
   private static Scanner in = new Scanner(System.in);
   public static int ante = 0;
   public static double players = 0;
   public static String hand = "";


   public static void main(String[] args)
   {
      System.out.print("Do you want to pracitce holding/drawing against \n a computer opponent (p), or get the edge in a real poker game (r)");
      String reply = in.nextLine();
      if(reply.equalsIgnoreCase("p"))
      {
         practice();
      }
      else
      {
         play();      
      }
   }
   public static void practice()
   {
      deck = new Deck();
      //System.out.println(deck);
      hand1 = new Hand();
      hand2 = new Hand();

      dealHands(5);
      //System.out.println(hand1);
      //System.out.println(hand2);

      hand1.sortHand();
      hand2.sortHand();
      System.out.println(hand1);
      System.out.println(hand2);
      
      Draw fix = new Draw(hand1, deck);
      System.out.println("\nNext player:\n");
      Draw fix2 = new Draw(hand2, deck);

      hand1.sortHand();
      hand2.sortHand();
      System.out.println(hand1);
      System.out.println(hand2);
      System.out.println("Best Hand: " + hand1.handValue());
      System.out.println("Best Hand: " + hand2.handValue());
      System.out.println(findWinner());   
   }
   public static void play()
   {
      System.out.println("What is the ante for this game?");
      ante = in.nextInt();
      System.out.println("Excluding yourself, how many other players are there?");
      players = in.nextInt();
      inputHand();
   }  
   public static void List()
   {
      System.out.println("Royal Flush");
      System.out.println("Straight Flush");
      System.out.println("Four of a Kind");
      System.out.println("Full House");
      System.out.println("Flush");
      System.out.println("Straight");
      System.out.println("Three of a Kind");
      System.out.println("Two Pairs");
      System.out.println("One Pair");
      System.out.println("High Card");
   }
   public static void inputHand()
   {
      System.out.println("What is your hand? (press A for list of choices).");
      in.nextLine();
      hand = in.nextLine();
      if(hand.equalsIgnoreCase("A"))
      {
         List();
      }
      else if(hand.equalsIgnoreCase("Royal Flush") || hand.equalsIgnoreCase("Straight Flush") || hand.equalsIgnoreCase("Four of a Kind") || hand.equalsIgnoreCase("Full House") || hand.equalsIgnoreCase("Flush") || hand.equalsIgnoreCase("Straight") || hand.equalsIgnoreCase("Three of a Kind") || hand.equalsIgnoreCase("Two Pair") || hand.equalsIgnoreCase("One Pair") || hand.equalsIgnoreCase("High Card")) //if entry is valid
      {
         setBet(calculateProbability(hand, players), ante);   
      }
      else
      {
         System.out.println("I didn't know reading was so hard. Perhaps poker isn't the game for you.");
         inputHand();
      }
   }
   public static double calculateProbability(String hand, double players)
   {
      double card = 1;
      double odds = 0;
      double prob = 0.11;
      System.out.println("Calculating Probability");
      if(hand.equalsIgnoreCase("high card"))
      {
         System.out.println("What is the high card? (2-14)");
         card = in.nextDouble();
         odds = ((50.13479/13)*(card-1))/100;
         prob = (double)Math.pow(odds,players);
         System.out.println("your probability of winning this game is " + prob + "It is reccommended that you fold.");
         return prob;
      }
      else if(hand.equalsIgnoreCase("one pair"))
      {
         System.out.println("a pair of...?");
         card = in.nextDouble();
         odds = (50.13479 + (42.25/13)*(card-1))/100;
         prob = (double)Math.pow(odds,players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      } 
      else if(hand.equalsIgnoreCase("two pair"))
      {
         double p1 = 0.0;
         double p2 = 0.0;
         System.out.println("what is your highest pair?");
         p1 = in.nextDouble();
         System.out.println("what is your lowest pair?");
         p2 = in.nextDouble();
         odds = ((92.38479) + (4.4/13)*(p1-1) + (.35/13)*(p2-1))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      }
      else if(hand.equalsIgnoreCase("three of a kind"))
      {
         double t = 0;
         System.out.println("What number is three of a kind?");
         t = in.nextDouble();
         odds = ((97.13479)+ (2.1/13)*(t-1))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob; 
      } 
      else if(hand.equalsIgnoreCase("Straight"))
      {
         double s = 0;
         System.out.println("What is the highest card in the straight?");
         s = in.nextDouble();
         odds = ((99.23479) + (0.4/13)*(s-1))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob; 
      }
      else if(hand.equalsIgnoreCase("Flush"))
      {
         double f =0;
         System.out.println("What is the highest card in the flush?");
         f = in.nextDouble();
         odds = ((99.63479) + (0.2/13)*(f-1))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      }
      else if(hand.equalsIgnoreCase("Full House"))
      {
         double t3 = 0;
         double p2 = 0;
         System.out.print("What is the value of the three of a kind?");
         t3 = in.nextDouble();
         System.out.print("What is the value of the pair?");
         p2 = in.nextDouble();
         odds = ((99.83479) + (.13/13)*(t3-1) + (.015/13)*(p2-1))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      }
      else if(hand.equalsIgnoreCase("Four of a Kind"))
      {
         double fofk = 0;
         System.out.print("What is the value of the four of a kind?");
         fofk = in.nextDouble();
         odds = ((99.965)+ (.02/13)*(fofk))/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
         
      }
      else if(hand.equalsIgnoreCase("Straight Flush"))
      {
         double sf = 0;
         System.out.print("What is the value of the highest card?");
         sf = in.nextDouble();
         odds = ((99.985) + (.012/13)*sf)/100;
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      }
      else if(hand.equalsIgnoreCase("Royal Flush"))
      {
         double r = 0;
         odds = ((99.9985)/100);
         prob = (double)Math.pow(odds, players);
         System.out.println("Your probability of winning this game is " + prob);
         return prob;
      }
      return 0.5; 
   }
   public static void setBet(double prob, int ante)
   {
      System.out.println("press enter to determine advice");
      in.nextLine();
      in.nextLine();
      if(prob<=.5)
      {
         System.out.print("if anyone tries to bet anything over the ante, you are advised to fold.");
      }
      else if(prob<=0.65)
      {
         System.out.print("you are advised to call bets so long as the pot \n is no larger than " + (ante*players) + " dollars. If this occurs, \n you should carefully consider folding, though if you \n have been forced to invest over this limit but \n under " + (ante*players*2) + " dollars then \n it is advisable to call.");
      }
      else if(prob<=0.85
      )
      {
         System.out.print("you are advised to get the pot to a size of at \n least " + (ante*players) + " dollars, rasing if needed. \n Under no circumstances, however, should you raise by \n more than 50% more than the player before, in order \n to discourage others from folding. It is best that the pot not get \n larger than " + (ante*players*2.4) + " dollars if possible.");
      }
      else
      {
         System.out.print("Short of an all-in situation, you are not advised to fold. \n Raise judiciously, up to 50% more than the person before you. \n The goal is to get the pot to at least " + (ante*players*3) + " dollars,\n though one should avoid other's folding.");
      }
   }
   public static void dealHands(int x){
      //TODO: Deal x cards to each player, Done
      for(int i=0; i<x; i++)
      {
        hand1.add(deck.remove());
        hand2.add(deck.remove());
      }
   }

   public static String findWinner(){//Done
      int result = hand1.compareTo(hand2);
      if(result>0)
        return "You are the Winner!";
      else if(result<0)
        return "I win!";
      else
        return "It is a tie.";
   }
}
