import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static org.junit.Assert.*;

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

    @Test
    public void straight() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(6, Suits.CLOVES, 6);
        Card thirdCard = new Card(42, Suits.SPADES, 3);
        Card forthCard = new Card(5, Suits.CLOVES, 5);
        Card fifthCard = new Card(4, Suits.CLOVES, 4);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] straightHand = new Card[5];
        straightHand[0]=firstCard;
        straightHand[1]=secondCard;
        straightHand[2]=thirdCard;
        straightHand[3]=forthCard;
        straightHand[4]=fifthCard;
        assertEquals("Straight", PokerHand.checkHand(straightHand));
        straightHand[4]=oddCard;
        assertNotEquals("Straight", PokerHand.checkHand(straightHand));
    }

    @Test
    public void flush() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(6, Suits.CLOVES, 6);
        Card fifthCard = new Card(13, Suits.CLOVES, 13);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] flushHand = new Card[5];
        flushHand[0]=firstCard;
        flushHand[1]=secondCard;
        flushHand[2]=thirdCard;
        flushHand[3]=forthCard;
        flushHand[4]=fifthCard;
        assertEquals("Flush", PokerHand.checkHand(flushHand));
        flushHand[4]=oddCard;
        assertNotEquals("Flush", PokerHand.checkHand(flushHand));
    }

    @Test
    public void fullHouse() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(15, Suits.CLOVES, 2);
        Card forthCard = new Card(16, Suits.DIAMONDS, 3);
        Card fifthCard = new Card(42, Suits.SPADES, 3);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] fullHouseHand = new Card[5];
        fullHouseHand[0]=firstCard;
        fullHouseHand[1]=secondCard;
        fullHouseHand[2]=thirdCard;
        fullHouseHand[3]=forthCard;
        fullHouseHand[4]=fifthCard;
        assertEquals("Full house", PokerHand.checkHand(fullHouseHand));
        fullHouseHand[4]=oddCard;
        assertNotEquals("Full house", PokerHand.checkHand(fullHouseHand));
    }

    @Test
    public void fourOfAKind() {
        Card firstCard = new Card(3, Suits.CLOVES, 3);
        Card secondCard = new Card(16, Suits.DIAMONDS, 3);
        Card thirdCard = new Card(29, Suits.CLOVES, 3);
        Card forthCard = new Card(42, Suits.SPADES, 3);
        Card fifthCard = new Card(2, Suits.CLOVES, 2);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] fourOfAKindHand = new Card[5];
        fourOfAKindHand[0]=firstCard;
        fourOfAKindHand[1]=secondCard;
        fourOfAKindHand[2]=thirdCard;
        fourOfAKindHand[3]=forthCard;
        fourOfAKindHand[4]=fifthCard;
        assertEquals("Four of a kind", PokerHand.checkHand(fourOfAKindHand));
        fourOfAKindHand[3]=oddCard;
        assertNotEquals("Four of a kind", PokerHand.checkHand(fourOfAKindHand));
    }

    @Test
    public void straightFlush() {
        Card firstCard = new Card(2, Suits.CLOVES, 2);
        Card secondCard = new Card(3, Suits.CLOVES, 3);
        Card thirdCard = new Card(4, Suits.CLOVES, 4);
        Card forthCard = new Card(5, Suits.CLOVES, 5);
        Card fifthCard = new Card(6, Suits.CLOVES, 6);
        Card oddCard = new Card(25, Suits.DIAMONDS, 12);
        Card[] straightFlushHand = new Card[5];
        straightFlushHand[0]=firstCard;
        straightFlushHand[1]=secondCard;
        straightFlushHand[2]=thirdCard;
        straightFlushHand[3]=forthCard;
        straightFlushHand[4]=fifthCard;
        assertEquals("Straight flush", PokerHand.checkHand(straightFlushHand));
        straightFlushHand[3]=oddCard;
        assertNotEquals("Straight flush", PokerHand.checkHand(straightFlushHand));
    }

}
