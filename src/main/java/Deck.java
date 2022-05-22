import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Deck {
    // Constants
    static final int NOOFCARDS = 52; // This variable represents the number of cards in the deck

    // Variables
    static ArrayList<Card> allCards=new ArrayList<>(); // This variable represents all cards
    static ArrayList<Integer> unshuffledDeck = new ArrayList<>(); // This variable holds the representation of all cards, unshuffeled
    static ArrayList<Integer> shuffledDeck = new ArrayList<>(); // This variable holds the representation of all cards, shuffeled
    static ArrayList<Integer> playerHand=new ArrayList<>(); // RamaBito: Player Hand cards.
    static Random random = new Random();

    /**
     * @description main function of Deck-class. Creates new deck of cards, prints it, shuffles it and prints it again.
     * @test NA
     * @param args program arguments
     * @todo: 2022-05-11 This function will eventually be removed
     */
    public static void main(String[] args){
    gameEngine();
         
        
        
		
    }
    
   /** 
     * @author: Rama Bito
     * @description API used to run the game whole game
     * 
     **/
    public static void gameEngine()
    {
        generateDeck();
        shuffledDeck = shuffleDeck(unshuffledDeck);
        playerHand=creationOfPlayerHand();
        printDeck(playerHand);
        switchOfPlayerHand();
        printDeck(playerHand);
        
        /* ُevaluaion methods */
        
        
        
        
        
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
        allCards.get(0).setValue(14);
        allCards.get(13).setValue(14);
        allCards.get(26).setValue(14);
        allCards.get(39).setValue(14);
    }

    /**
     * @description This function prints the cards in the deck on screen
     * @test NA
     * @param shuffledDeck an ArrayList of Integers, each representing the Card-object's cardNo
     */
    public static void printDeck(ArrayList<Integer> shuffledDeck){
        for (Integer integer : shuffledDeck) {
            System.out.print(allCards.get(integer - 1).toString() + "\n");
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
	
    
    /** 
     * @author: Rama Bito
     * @description API used to create the player hand randomly through randomizing 5 times and remove the output card from the shuffled deck
     * @return Array list the player hand.
     **/
	public static ArrayList<Integer> creationOfPlayerHand()
	{
		ArrayList<Integer> temp=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			int randomCard = random.nextInt(shuffledDeck.size());
			temp.add(shuffledDeck.get(randomCard));
			shuffledDeck.remove(randomCard);
		}
		return temp;
	}
        
     /** 
       * @author: Rama Bito
       * @description API used to make the user replace the cards he want to replace through inertacting with him
       **/
	public static void switchOfPlayerHand()
	{
            int hold=0, replace=0, cardNo=0;
            boolean wrongInput=true;
            Scanner scan = new Scanner(System.in);
            ArrayList<Integer> temp=new ArrayList<>();
            
            
            /* the the number of the cards the user want to replace */
            System.out.println("Enter the number of cards you want to replace or enter 0 if you don't want to replace any card: ");
            while(wrongInput == true)
            {
                 try{
                    replace=scan.nextInt();
                    if(replace >= 0 && replace <=5){
                            wrongInput=false;
                          
                    }
                    else
                              System.out.print("Wrong input enter the number from 0 to 5");
                    }
                    catch(Exception e){
                             System.out.print("Wrong Input, Please enter a number between 1 and 5: ");
                      }
            
            }
            
            /* take the IDs of the cards the user want to replace */
            for(int i=0;i<replace;i++)
            { 
                System.out.println("Enter the card Id you want to replace (1-5): ");
                cardNo=scan.nextInt();
                shuffledDeck.add(playerHand.get(cardNo-1));
                playerHand.remove(cardNo-1);
                int randomCard = random.nextInt(shuffledDeck.size());
                playerHand.add( cardNo-1, shuffledDeck.get(randomCard));
		shuffledDeck.remove(randomCard);
                
                
            }
	}
	
        
		
		
}
