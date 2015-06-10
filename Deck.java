import java.util.*;

public class Deck {
   private ArrayList<Card> deck;
   private Random rng = new Random();

   public Deck(){
      deck = new ArrayList<Card>();
      //TODO: Add a card (2-14) of each suit (h,s,d,c), done
      for(int i=2; i<15; i++)
      {
        Card w= new Card(i,"h");
        deck.add(w);
        Card x= new Card(i,"s");
        deck.add(x);
        Card y= new Card(i,"d");
        deck.add(y);
        Card z= new Card(i,"c");
        deck.add(z);
      }
   }

   public Card remove(){
      int rand = rng.nextInt(deck.size()-1);
      return deck.remove(rand);
   }

   public String toString(){
      return deck.toString();
   }
   public void add(Card c){
      deck.add(c);
   }
}
