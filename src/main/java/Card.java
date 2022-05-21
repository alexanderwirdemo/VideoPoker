public class Card implements Comparable<Card>{
    int cardNo; // this variable representents one of the 52 cards and is unique for each card
    Suits suit; // this variable represents the card's suit (HEARTS,CLOVES,DIAMONDS,SPADES)
    int value; // this variable represents the card's value (2-10, Jack, Queen, King, Ace, where 11-Jack, 12-Queen, 13-King and 14-Ace)
    String faceValue;

    public Card(int cardNo, Suits suit, int value) {
        this.cardNo = cardNo;
        this.suit = suit;
        this.value = value;
        if(value==1){
            this.faceValue="ACE";
        }
        if(value==2){
            this.faceValue="TWO";
        }
        if(value==3){
            this.faceValue="THREE";
        }
        if(value==4){
            this.faceValue="FOUR";
        }
        if(value==5){
            this.faceValue="FIVE";
        }
        if(value==6){
            this.faceValue="SIX";
        }
        if(value==7){
            this.faceValue="SEVEN";
        }
        if(value==8){
            this.faceValue="EIGHT";
        }
        if(value==9){
            this.faceValue="NINE";
        }
        if(value==10){
            this.faceValue="TEN";
        }
        if(value==11){
            this.faceValue="JACK";
        }
        if(value==12){
            this.faceValue="QUEEN";
        }
        if(value==13){
            this.faceValue="KING";
        }
        if(value==14){
            this.faceValue="ACE";
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Suits getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    @Override
    public String toString() {
        return faceValue + " of " +suit;
    }

    @Override
    public int compareTo(Card card) {
        if (this.value != card.getValue()) {
            return this.value - card.getValue();
        }
        return 0;
    }
}
