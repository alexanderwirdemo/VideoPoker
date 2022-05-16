import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PokerHand {

    public static String checkHand(Card[] hand) {
        String sameCardGroupOneFacevalue, sameCardGroupTwoFacevalue;
        int sameCardGroupOne = 0, sameCardGroupTwo = 0;

        Map<String, Integer> handValues = getHandData(hand);

        for(String key:handValues.keySet()){
            int cardsWithSameValue = handValues.get(key);
            if(cardsWithSameValue>=2){
                if(sameCardGroupOne==0){
                    sameCardGroupOne=cardsWithSameValue;
                    sameCardGroupOneFacevalue=key;
                    System.out.println(sameCardGroupOne+" "+sameCardGroupOneFacevalue);
                }
                else{
                    sameCardGroupTwo=cardsWithSameValue;
                    sameCardGroupTwoFacevalue=key;
                    System.out.println(sameCardGroupTwo+" "+sameCardGroupTwoFacevalue);
                }
            }
        }

        if(sameCardGroupOne==2 && sameCardGroupTwo==0){
            return "One pair";
        }
        if(sameCardGroupOne==2 && sameCardGroupTwo==2){
            return "Two pairs";
        }
        if(sameCardGroupOne==3 && sameCardGroupTwo==0){
            return "Three of a kind";
        }
        return "Poker hand";
    }

    private static Map<String, Integer> getHandData(Card[] hand) {
        Map<String, Integer> handValues = new HashMap<>();
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

        for(Card card:hand){
            handValues.put(card.getFaceValue(),handValues.get(card.getFaceValue())+1);
        }
        return handValues;
    }

}
