import java.util.*;

public class Draw{
  private static Hand hold;
  private static Deck deck;
  private Random rng = new Random();
  private static Hand hand;
  private static Scanner in = new Scanner(System.in);

  public Draw(Hand x)
  {
   //user input how many cards, call metthod with user input
   System.out.print("How many cards do you want to return to deck? > ");
   int t = in.nextInt();
   System.out.println();//attempt to get code to work
   //in that method call the card select
   deck = new Deck();
   hand = new Hand();
   hold = new Hand();
   deck = this.deck;
   hand = x;
   drawSimple(t);
  }
  public void drawSimple(int n)//They get cards and send their's back thus no chance of redraw
  {
    for(int i=0; i<n; i++)
    {
      hold.add(deck.remove());
    }

    System.out.println("Card name style: Values are 1-13\n\tsuits are h,s,d,c");
    for(int i=0; i<n; i++)
    {
      System.out.println(hold);
      System.out.println(hand);//gives index out of bounds error
      drawSelect();//call the select method, deck.add(hand.remove(rng.nextInt(hand.size()-1)));
    }

    for(int i=n; i>0; i--)
    {
      //Card temp = new Card(hold.get(i).value, hold.get(i).suit);
      hand.add(hold.remove(i));//need to get card unit from hold
    }
  }

  private void drawSelect()//They get to pick which cards to send back
  {
      System.out.print("Which card do you wish to return to deck?\nValue > ");
      int val = in.nextInt();
      System.out.print("");
      System.out.print("Suit > ");
      String st = in.next();
      Card chose = new Card(val, st);
      deck.add(chose);
      hand.remove(chose);//why does it not remove from hand
  }
}
/*
method (Number){
// can they pick which cards to send back?  Yes
// can they end up redrawing the cards they had?  No
// if not
make card holding variable of number size
get that many cards form deck
put Number of cards from hand to deck//if pick then have the user recursive loop here
then put card holder cards to hand
//end
}
*/