// File by Ben, DO NOT CHANGE

import java.util.*;

public class Card implements Comparable {
   public int value;
   public String suit;
   public Card(int val, String s){
      value = val;
      suit = s;
   }

   public String toString(){
      String s = "" + value;
      if(value == 11){s = "J";}
      if(value == 12){s = "Q";}
      if(value == 13){s = "K";}
      if(value == 14 || value == 1){s = "A";}
      return s + suit;
   }

   public int compareTo(Object x){
      Card other = (Card)x;
      return this.value - other.value;
   }
}
