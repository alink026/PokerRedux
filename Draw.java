import java.util.*;

public class Draw{
  private static ArrayList<Card>  Hold;

  public hand drawSimple(int n)//They get cards and send their's back thus no chance of redraw
  {
    Hold = new ArrayList<Card>(n);
    for(int i=0; i<n; i++)
    {
      Hold.add(deck.remove());
    }
    for(int i=0; i<n; i++)
    {
      deck.add(hand.remove());
    }
    for(int i=0; i<n; i++)
    {
      hand.add(Hold.remove());
    }
  }

  /*public hand drawSelect(int n)//They get to pick which cards to send back
  {
    Hold = new ArrayList<Card>(n);
    for(int i=0; i<n; i++)
    {
      Hold.add(deck.remove());
    }
    for(int i=0; i<n; i++)
    {
      //some how: select in hand, send to deck, remove specified from hand
      //deck.add(hand.remove());
    }
    for(int i=0; i<n; i++)
    {
      hand.add(Hold.remove());
    }
  }*/

  public hand drawRedraw(int n)//They send cards back first risking to redraw their card
  {
    for(int i=0; i<n; i++)
    {
      deck.add(hand.remove());
    }
    for(int i=0; i<n; i++)
    {
      hand.add(deck.remove());
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
