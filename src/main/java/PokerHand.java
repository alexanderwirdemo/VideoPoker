import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PokerHand implements Comparator<Card>{

    public static String checkPair(Card[] hand) {

        getHandData(hand);

        Arrays.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return Math.max(card1.value, card2.value);
            }
        });





        for(int index=0; index<hand.length; index++){
            int firstCardValue = hand[index].value;
            int cardsOfTheSameValue = 1;
            for(int index2=index+1; index2<hand.length; index2++){
                int nextCardValue = hand[index2].value;
                //System.out.println("Values to compare: "+firstCardValue+" "+nextCardValue);
                if(firstCardValue==nextCardValue){
                    //System.out.println("Match!");
                    cardsOfTheSameValue++;
                }
            }
            System.out.println("Iteration "+(index+1)+": "+cardsOfTheSameValue+" "+firstCardValue);
        }
        return "Poker hand";
    }

    private static void getHandData(Card[] hand) {
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

        for(String key:handValues.keySet()){
            int value = handValues.get(key);
            System.out.println(key+" "+value);
        }

    }

    @Override
    public int compare(Card card1, Card card2) {
        return Math.max(card1.value, card2.value);
    }

}
