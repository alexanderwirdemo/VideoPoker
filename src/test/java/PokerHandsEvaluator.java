import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsEvaluator {

    @Test
    public void onePair() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card seconCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(15, Suits.DIAMONDS, 2);
        Card fifthCard = new Card(26, Suits.DIAMONDS, 13);
        Card[] onePairHand = new Card[5];
        onePairHand[0]=firstCard;
        onePairHand[1]=seconCard;
        onePairHand[2]=thirdCard;
        onePairHand[3]=forthCard;
        onePairHand[4]=fifthCard;
        assertEquals("One pair", PokerHand.checkHand(onePairHand));
    }

    @Test
    public void twoPair() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card seconCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(15, Suits.DIAMONDS, 2);
        Card fifthCard = new Card(16, Suits.DIAMONDS, 3);
        Card[] twoPairsHand = new Card[5];
        twoPairsHand[0]=firstCard;
        twoPairsHand[1]=seconCard;
        twoPairsHand[2]=thirdCard;
        twoPairsHand[3]=forthCard;
        twoPairsHand[4]=fifthCard;
        assertEquals("Two pair", PokerHand.checkHand(twoPairsHand));
    }



}
