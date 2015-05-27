import java.util.*;

public class Draw{
  private static ArrayList<Card> hold;
  private static ArrayList<Card> deck;
  private Random rng = new Random();
  private static ArrayList<Card> hand;

  public Draw()
  {
   //hold = new ArrayList<Card>(n)
   deck = this.deck;
   hand = this.hand;
   //which one we will use
  }
  public void drawSimple(int n)//They get cards and send their's back thus no chance of redraw
  {
    hold = new ArrayList<Card>(n);
    for(int i=0; i<n; i++)
    {
      hold.add(deck.remove(rng.nextInt(deck.size()-1)));
    }
    for(int i=0; i<n; i++)
    {
      deck.add(hand.remove(rng.nextInt(hand.size()-1)));
    }
    for(int i=0; i<n; i++)
    {
      hand.add(hold.remove(rng.nextInt(hold.size()-1)));
    }
  }

  /*public void drawSelect(int n)//They get to pick which cards to send back
  {
    hold = new ArrayList<Card>(n);
    for(int i=0; i<n; i++)
    {
      hold.add(deck.remove());
    }
    for(int i=0; i<n; i++)
    {
      //some how: select in hand, send to deck, remove specified from hand
      //mabey by location otherwise by value and suit, must check that they have card though
      //deck.add(hand.remove());
    }
    for(int i=0; i<n; i++)
    {
      hand.add(hold.remove());
    }
  }*/

  public void drawRedraw(int n)//They send cards back first risking to redraw their card
  {
    for(int i=0; i<n; i++)
    {
      deck.add(hand.remove(rng.nextInt(hand.size()-1)));
    }
    for(int i=0; i<n; i++)
    {
      hand.add(deck.remove(rng.nextInt(deck.size()-1)));
    }
  }
}
/*
method (Number){
// can they pick which cards to send back?
// can they end up redrawing the cards they had?
// if not
make card holding variable of number size
get that many cards form deck
put Number of cards from hand to deck//if pick then have the user recursive loop here
then put card holder cards to hand
//end
}
*/
