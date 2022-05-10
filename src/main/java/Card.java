public class Card {
    int cardNo; // this variable representents one of the 52 cards and is unique for each card
    Suits suit; // this variable represents the card's suit (HEARTS,CLOVES,DIAMONDS,SPADES)
    int value; // this variable represents the card's value (2-10, Jack, Queen, King, Ace, where 11-Jack, 12-Queen, 13-King and 14-Ace)

    public Card(int cardNo, Suits suit, int value) {
        this.cardNo = cardNo;
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
