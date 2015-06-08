import java.util.*;

public class Draw{
  private static Hand hold;
  private static Deck deck;
  private static Hand hand;
  private ArrayList<Integer> ints = new ArrayList<Integer>();
  private static Scanner in = new Scanner(System.in);

  public Draw(Hand x, Deck d)
  {
   System.out.print("How many cards do you want to return to deck? > ");
   int t = in.nextInt();
   System.out.println();//attempt to get code to work
   deck = new Deck();
   hand = new Hand();
   hold = new Hand();
   deck = d;
   hand = x;
   drawSimple(t);
  }
  public void drawSimple(int n)//They get cards and send their's back thus no chance of redraw
  {
    for(int i=0; i<n; i++)
    {
      hold.add(deck.remove());
    }

    System.out.println("Card name style: \nValues are 1-13; A=1, J=11, Q=12, K=13\nsuits are h,s,d,c\n");
    for(int i=0; i<n; i++)
    {
      System.out.println(hand);
      drawSelect();//call the select method
    }
    for(int i=0; i<y; i++)
    {
      Card c = hold.get(i);
      hand.set(ints.get(i), c);//now adds card to hand from hold
    }
  }

  private void drawSelect()//They get to pick which cards to send back
  {//want to have it re ask if any info is miss typed and or if card chosen is not one in hand
      System.out.print("Which card do you wish to return to deck?\nValue > ");
      int val = in.nextInt();
      System.out.print("");
      System.out.print("Suit > ");
      String st = in.next();
      for(int i=0; i<5; i++)
      {
         if(hand.get(i).value==val&&hand.get(i).suit.equals(st))
         {
            Card c = hand.get(i);
            deck.add(c);
            ints.add(i);
         }
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
