import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // Constants
    static final int NOOFCARDS = 52; // This variable represents the number of cards in the deck

    // Variables
    static ArrayList<Card> allCards=new ArrayList<>(); // This variable represents all cards
    static ArrayList<Integer> unshuffledDeck = new ArrayList<>(); // This variable holds the representation of all cards, unshuffeled
    static ArrayList<Integer> shuffledDeck = new ArrayList<>(); // This variable holds the representation of all cards, shuffeled
    static Random random = new Random();

    /**
     * @description main function of Deck-class. Creates new deck of cards, prints it, shuffles it and prints it again.
     * @test NA
     * @param args program arguments
     * @todo: 2022-05-11 This function will eventually be removed
     */
    public static void main(String[] args){
        generateDeck();
        printDeck(unshuffledDeck);
        shuffledDeck = shuffleDeck(unshuffledDeck);
        System.out.println();
        printDeck(shuffledDeck);
    }

    /**
     * @description This function creates a deck of cards consisting of 52 Card-objects
     * @test NA
     */
    public static void generateDeck(){
        for (int cardNo=1;cardNo<=NOOFCARDS;cardNo++){
            if(cardNo<=13) {
                Card card = new Card(cardNo, Suits.CLOVES, cardNo);
                allCards.add(card);
                unshuffledDeck.add(cardNo);
            }
            else if(cardNo<=26){
                Card card = new Card(cardNo, Suits.DIAMONDS, cardNo-13);
                allCards.add(card);
                unshuffledDeck.add(cardNo);
            }
            else if(cardNo<=39){
                Card card = new Card(cardNo, Suits.HEARTS, cardNo-26);
                allCards.add(card);
                unshuffledDeck.add(cardNo);
            }
            else {
                Card card = new Card(cardNo, Suits.SPADES, cardNo-39);
                allCards.add(card);
                unshuffledDeck.add(cardNo);
            }
        }
    }

    /**
     * @description This function prints the cards in the deck on screen
     * @test NA
     * @param shuffledDeck an ArrayList of Integers, each representing the Card-object's cardNo
     */
    public static void printDeck(ArrayList<Integer> shuffledDeck){
        for (Integer integer : shuffledDeck) {
            System.out.print(allCards.get(integer - 1).suit + " " + allCards.get(integer - 1).value + "\n");
        }
    }

    /**
     * @description This function shuffles the deck of cards by re-arranging the cardNo variable of the unshuffeledDeck
     * @test NA
     * @param unshuffledDeck an ArrayList of Integers, each representing the Card-object's cardNo
     * @return ArrayList<Integer> shuffeledDeck
     */
    public static ArrayList<Integer> shuffleDeck(ArrayList<Integer> unshuffledDeck){ //Denna metod blandar kortleken
        for(int cardIndex=0;cardIndex<NOOFCARDS;cardIndex++) {
            int randomCard = random.nextInt(unshuffledDeck.size());
            shuffledDeck.add(unshuffledDeck.get(randomCard));
            unshuffledDeck.remove(randomCard);
        }
        return shuffledDeck;
    }
}
