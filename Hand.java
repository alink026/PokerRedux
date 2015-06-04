import java.util.*;
import java.util.HashMap;

public class Hand implements Comparable {
   private ArrayList<Card> hand;

   public Hand(){
      hand = new ArrayList<Card>();

   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }

   /*
   BEST
   Royal Flush
   Straight Flush
   Four of a Kind
   Full House
   Flush
   Straight
   Three of a Kind
   Two Pair
   One Pair
   High Card
   WORST
   */


   public String handValue() {
     //return "TODO: String of Best Hand; may need helper methods";
     return valueHelper();
   }
   public String valueHelper()
   {
     HashMap<Integer, Integer> numinHand = new HashMap<Integer, Integer>();
     int t = 0;
     String handSuit = "a";
     //for(Card x : this.hand)
     for(int x = 0; x < this.hand.size(); x++)
     {
      if(t == 0)
         handSuit = this.hand.get(x).suit;
      else
      {
         if(handSuit.equals(this.hand.get(x).suit))
            {}
         else
            handSuit = "differnt";
      }
      t++;
      
       if(numinHand.containsKey(this.hand.get(x).value))
       {
         int temp = numinHand.get(this.hand.get(x).value);
         numinHand.put(this.hand.get(x).value, ++temp);
       }
       else
       {
         numinHand.put(this.hand.get(x).value, 1);
       }
     }
     if(handSuit.equals("differnt"))
     {
         //Four of a Kind
         if(numinHand.containsValue(4))
            return "FK";
         //Full House
         if(numinHand.containsValue(3) && numinHand.containsValue(2))
            return "FH";
         //Straight
         for(int x: numinHand.keySet())
            if(numinHand.containsKey(x+5) && numinHand.containsKey(x+4) && numinHand.containsKey(x+3) && numinHand.containsKey(x+2) && numinHand.containsKey(x+1) || numinHand.containsKey(x-5) && numinHand.containsKey(x-4) && numinHand.containsKey(x-3) && numinHand.containsKey(x-2) && numinHand.containsKey(x-1))
               return "NS";
         //Three of a Kind
         if(numinHand.containsValue(3))
            return "TK";
         //Two Pair and One Pair
         String temp = "OP";
         String temp2 = "TP";
         if(numinHand.containsValue(2))
         {
            for(int x: numinHand.keySet())
            {
               if(numinHand.get(x) == 2 && temp.length() == 2)
               {
                  temp = temp + x;
                  temp2 = temp2 + x;  
               }
               else if(numinHand.get(x) == 2 && temp.length() > 2)
                  temp2 = temp2 + x;
            }
            if(temp.length() == temp2.length())
               return temp;
            else
               return temp2;
         }
         else
         {
            
         }
        
      }
      else
      {
      
         //Royal Flush
         if(numinHand.containsKey(14) && numinHand.containsKey(13) && numinHand.containsKey(12) && numinHand.containsKey(11) && numinHand.containsKey(10))
         {
           return "RF";
         }
         //Straight Flush
         else if(numinHand.containsKey(10) && numinHand.containsKey(9) && numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) || numinHand.containsKey(9) && numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) || numinHand.containsKey(8) && numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) || numinHand.containsKey(7) && numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) || numinHand.containsKey(6) && numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) && numinHand.containsKey(2) || numinHand.containsKey(5) && numinHand.containsKey(4) && numinHand.containsKey(3) && numinHand.containsKey(2) && numinHand.containsKey(1))
         {
           return "SF";
         }
         //Flush
         else
            return "NF";
      
            
      }

      return "HC" + this.hand.get(this.hand.size()-1).value;
   }

   public int score(Hand x)
   {
      String m = x.handValue().substring(0,2);
      if(m.equals("RF"))
         return 10;
      else if(m.equals("SF"))
         return 9;
      else if(m.equals("FK"))
         return 8;
      else if(m.equals("FH"))
         return 7;
      else if(m.equals("NF"))
         return 6;
      else if(m.equals("NS"))
         return 5;
      else if(m.equals("TK"))
         return 4;
      else if(m.equals("TP"))
         return 3;
      else if(m.equals("OP"))
         return 2;
      else
         return 1;         
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      if(score(this) > score(other))
         return 1;
      else if(score(other) > score(this))
         return -1;
      //tie breakers
      else
      {  
         int temp1 = 0;
         int temp2 = 0;
         if(this.handValue().length() > 2)
         {
            temp1 = Integer.parseInt(this.handValue().substring(2));
         }
         if(other.handValue().length() > 2)
         {
            temp2 = Integer.parseInt(other.handValue().substring(2));
         }
         if(this.handValue().length() > other.handValue().length())
            return 1;
         else if(this.handValue().length() < other.handValue().length())
            return -1;
         else if(temp1 >  temp2)
            return 1;
         else if(temp2 > temp1)
            return -1;
         else
         {
            if(this.hand.get(0).value > other.hand.get(0).value)
               return 1;
            else
               return -1;
         }
      }
      //player #1 wins print 1 player #2 -1
      //TODO: Compare hands by ordering above; return -1, 1, or 0
   }
}
