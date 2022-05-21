import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PokerHandsEvaluator {

    @Test
    public void onePair() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(15, Suits.DIAMONDS, 2);
        Card fifthCard = new Card(26, Suits.DIAMONDS, 13);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] onePairHand = new Card[5];
        onePairHand[0]=firstCard;
        onePairHand[1]=secondCard;
        onePairHand[2]=thirdCard;
        onePairHand[3]=forthCard;
        onePairHand[4]=fifthCard;
        assertEquals("One pair", PokerHand.checkHand(onePairHand));
        // Non-one pair hand introduced
        onePairHand[3]=oddCard;
        assertNotEquals("One pair", PokerHand.checkHand(onePairHand));
    }

    @Test
    public void twoPairs() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(15, Suits.DIAMONDS, 2);
        Card fifthCard = new Card(16, Suits.DIAMONDS, 3);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] twoPairsHand = new Card[5];
        twoPairsHand[0]=firstCard;
        twoPairsHand[1]=secondCard;
        twoPairsHand[2]=thirdCard;
        twoPairsHand[3]=forthCard;
        twoPairsHand[4]=fifthCard;
        assertEquals("Two pairs", PokerHand.checkHand(twoPairsHand));
        twoPairsHand[3]=oddCard;
        assertNotEquals("Two pairs", PokerHand.checkHand(twoPairsHand));
    }

    @Test
    public void threeOfAKind() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(16, Suits.DIAMONDS, 3);
        Card fifthCard = new Card(42, Suits.SPADES, 3);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] threeOfAKindHand = new Card[5];
        threeOfAKindHand[0]=firstCard;
        threeOfAKindHand[1]=secondCard;
        threeOfAKindHand[2]=thirdCard;
        threeOfAKindHand[3]=forthCard;
        threeOfAKindHand[4]=fifthCard;
        assertEquals("Three of a kind", PokerHand.checkHand(threeOfAKindHand));
        threeOfAKindHand[4]=oddCard;
        assertNotEquals("Three of a kind", PokerHand.checkHand(threeOfAKindHand));
    }



}
