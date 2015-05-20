import java.util.*;

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
   Royal Flush        five in row of same suit(10-A)
   Straight Flush     five in row of same suit
   Four of a Kind     four of a kind
   Full House         a three of a kind + a two of a kind
   Flush              five cards of the same suit
   Straight           five in a row suit doesn't matter
   Three of a Kind    three of a kind
   Two Pair           two sets of two of a kind
   One Pair           one set of two of a kind
   High Card          anything else
   WORST
   */

   public int score(){
     //chech for all card types listed above, How do you compare cards?
    if(){//inorder
      if(){//all one suit
        if()//royal flush //inorder from 10 to A
          return 1;
        else if()//straight flush //inorder
          return 2;
        else//flush //not inorder
          return 5;
      }
      else//Straight //all inorder
        return 6;
    }
    else if()//four of same #
      return 3;
    else if(){//if three of same #
      if()//Full House //also two of same #
        return 4;
      else//Three of kind
        return 7;
    }
    else if(){//has set of two
      if()//two pair //also second set of two
        return 8;
      else//one pair
        return 9;
    }
    else//high card
      return 10;
   }

   public String handValue() {
     if(score()==1)
      return "Royal Flush";
     else if(score()==2)
      return "Straight Flush";
     else if(score()==3)
      return "Four of a Kind";
     else if(score()==4)
      return "Full House";
     else if(score()==5)
      return "Flush";
     else if(score()==6)
      return "Straight";
     else if(score()==7)
      return "Three of a Kind";
     else if(score()==8)
      return "Two Pair";
     else if(score()==9)
      return "One Pair";
     else
      return "High Card";
     //TODO: String of Best Hand; may need helper methods", Done
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      if(other.score()<this.score())
        return 1;
      else if(this.score()<other.score())
        return -1;
      return 0;//TODO: Compare hands by ordering above; return -1, 1, or 0, Done
   }
}
