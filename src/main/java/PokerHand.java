import java.util.HashMap;
import java.util.Map;

public class PokerHand {

    /**
     * @description This function evaluates the player's poker hand and returns a String representation of the hand (e.g. "Two pairs", "Full house" etc)
     * @test PokerHandEvaluator: onePair(), twoPairs(), threeOfAKind()
     * @param hand, an Array of five (5) Card objects
     * @return String pokerHand, a String representation of the returned Poker hand
     */
    public static String checkHand(Card[] hand) {
        // Variables
        String sameCardGroupOneFacevalue = "", sameCardGroupTwoFacevalue = ""; // These variables represents the face value of groups of card with the same value, e.g. Fours
        int sameCardGroupOne = 0, sameCardGroupTwo = 0; // This variable represents the number of cards of the respective groups, i.e. how many of the same face value there are in each group
        Map<String, Integer> handValues; // This variable contains how many cards of each face value the player's hand contains, e.g. how many Kings, Tens etc.

        // First off, the handValues variable is built using the getHandData-function
        handValues = getHandData(hand);

        // Secondly, the handValues varaible is examined, key by key (each key representing a specific face value), and the number of cards evaluated, to create groups
        for(String key:handValues.keySet()){
            int cardsWithSameValue = handValues.get(key);
            // If there are two or more cards of the same variable, the cards are grouped into one of the two sameCard-groups
            if(cardsWithSameValue>=2){
                // If the first group of sameCards is empty, it is used
                if(sameCardGroupOne==0){
                    sameCardGroupOne=cardsWithSameValue;
                    sameCardGroupOneFacevalue=key;
                    System.out.println(sameCardGroupOne+" "+sameCardGroupOneFacevalue);
                }
                // If the first group is already allocated, the second group is used
                else{
                    sameCardGroupTwo=cardsWithSameValue;
                    sameCardGroupTwoFacevalue=key;
                    System.out.println(sameCardGroupTwo+" "+sameCardGroupTwoFacevalue);
                }
            }
        }
        // Once the card groups have been established, this part of the program evaluates the actual hand
        // If there is only one group allocated, and it contains exactly one pair, One pair is returned
        if(sameCardGroupOne==2 && sameCardGroupTwo==0){
            return "One pair";
        }
        // If both groups are allocated, and both contain exactly two (2) cards each, Two pair is returned
        if(sameCardGroupOne==2 && sameCardGroupTwo==2){
            return "Two pairs";
        }
      
        // If only one group is allocated and it contains exactly three (3) cards, Three of a kind is returned
        if(sameCardGroupOne==3 && sameCardGroupTwo==0){
            return "Three of a kind";
        }
        return "Poker hand";
    }

    /**
     * @description This function examines the player's hand and groups all cards in the hand together, indicating how many of each there are
     * @test NA
     * @param hand, an Array of five (5) Card objects
     * @return HashMap<String, Integer> handValues, a representation of each of the Cards face values (key), and how many of each there are in the hand (value)
     */
    private static Map<String, Integer> getHandData(Card[] hand) {
        // Variable
        Map<String, Integer> handValues = new HashMap<>(); // This variable is a representation of each of the Cards face values and how many of each there are in the hand
        // First off, the handValues is built and keys inserted, with the default value 0
        handValues.put("TWO",0);
        handValues.put("THREE",0);
        handValues.put("FOUR",0);
        handValues.put("FIVE",0);
        handValues.put("SIX",0);
        handValues.put("SEVEN",0);
        handValues.put("EIGHT",0);
        handValues.put("NINE",0);
        handValues.put("TEN",0);
        handValues.put("JACK",0);
        handValues.put("QUEEN",0);
        handValues.put("KING",0);
        handValues.put("ACE",0);

        // Secondly, the hand is examined card by card, and the value incremented by one (1)
        for(Card card:hand){
            handValues.put(card.getFaceValue(),handValues.get(card.getFaceValue())+1);
        }
        return handValues;
    }

}
