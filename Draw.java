import java.util.*;

public class Draw{
  private static ArrayList<Card> hold;
  private static ArrayList<Card> deck;
  private Random rng = new Random();
  private static Hand hand;
  private static Scanner in = new Scanner(System.in);

  public void Draw(Hand x)
  {
   //user input how many cards, call metthod with user input
   System.out.print("How many cards do you want to return to deck? > ");
   int t = in.nextInt();
   //in that method call the card select
   deck = this.deck;
   hand = x;
   drawSimple(t);
  }
  public void drawSimple(int n)//They get cards and send their's back thus no chance of redraw
  {
    hold = new ArrayList<Card>(n);
    for(int i=0; i<n; i++)
    {
      hold.add(deck.remove(rng.nextInt(deck.size()-1)));
    }

    System.out.println("Card name style: Values are 1-13\n\tsuits are h,s,d,c");
    for(int i=0; i<n; i++)
    {
      System.out.println(hand);
      drawSelect();//call the select method, deck.add(hand.remove(rng.nextInt(hand.size()-1)));
    }

    for(int i=0; i<n; i++)
    {
      hand.add(hold.remove(rng.nextInt(hold.size()-1)));
    }
  }

  private void drawSelect()//They get to pick which cards to send back
  {
      System.out.print("Which card do you wish to return to deck?\nValue > ");
      int val = in.nextInt();
      System.out.print("\nSuit > ");
      String st = in.nextLine();
      Card chose = new Card(val, st);
      if(!hand.contains(chose)){
        System.out.println("This card is not in your hand, try again.");
        drawSelect();
      }
      else
      {
        deck.add(chose);
        hand.remove(chose);
      }
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
