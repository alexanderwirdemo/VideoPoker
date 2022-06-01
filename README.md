#Introduction
This reports covers the procedures and result of a software project to create a Java version of Video poker. As a version handling tool, github was used. As IDE, IntelliJ was used. 

#Purpose
The purpose of this project was to build a Video poker game in Java. Video poker is a classical game found in most casinos, often as slot machines. The player pays credit to the machine, and each round costs a certain amount of credits to play. The player is then dealt a five-card hand, selects which cards to keep/discard and 0-5 new cards are then dealt based on the player’s decision. The final hand is evaluated and the player is given credits depending on the hand’s value. 

The hands are:
One pair – two cards of the same value (e.g. two queens)
Two pair – two cards of the same value and two cards of another value (e.g. two jacks and two kings)
Three of a kind – three cards of the same value (e.g. three tens)
Straight – five cards that increases in value by one (1) each time (e.g. seven-eight-nine-ten-jack)
Flush – five cards of the same suit (all spades, diamonds, cloves or hearts)
Full house – three cards of one value and two cards of another value (e.g. three fours and two treys)
Four of a kind – four cards of the same value (e.g. four deuces)
Straight flush – five cards that increases in value by one (1) each time, all in the same suit (e.g. four of hearts, five of hearts, six of hearts, seven of hearts, eight of hearts)
Royal flush – a straight flush that starts with a ten and ends with an ace (e.g. ten of spades, jack of spades, queen of spades, king of spades, ace of spades).

Depending on the rarity of the hand, one pair being the most common hand (except having no hand at all) and royal flush the rarest, the player gains credits. This particular project did not focus on creating a graphical interface, nor did it focus on winning real money, but rather textual representations of the cards printed in the console and used only play money.

More specifically, the following functionalities were required. The game should have a user interface where the player can load credits, start a new game and exit the game. Once a game has been started, the game should be able to create a new deck of cards, shuffle the virtual deck and deal five cards to the player. The player should be able to keep up to five of the cards, be able to discard the rest and receive new cards. The game should then be able to evaluate the hand and give corresponding credits to the player’s account.

#Procedures
The creation of a game deck was solved in the following way. A Card-class was introduced with class variables cardNo, suit, value and faceValue. cardNo is a generic value 1-52 only used for creation of the deck, suit is of type enum and can be DIAMONDS, SPADES, HEATS or CLOVES, and value is the value of the card. Facevalue is a string representation of the value (2-“TWO”, 11-“JACK”, for example). This class was then used in the Deck-class, which creates all cards needed in a Deck and is used in the game engine. The deck class can also shuffle the cards using a simple nextInt()-function from the Random-library. Based on this deck, hands can be dealt.

The evaluation of hands was solved in the following way. A PokerHand-class was created. To evaluate the hand, the cards of the hand was categorized by creating a generic HashMap with the face value as key and number of cards with the same face value as value (if there are no cards, the value will be zero). The map was then built and used to evaluate hands. The map is used to group cards of the same value and store them in local group variables, where each group represents how many cards of the same value there are in the group (if there are three cards of the same value, the variable sameCardGroupOne will be 3, for example). 

Once the grouping is complete, certain conditions of the grouping was checked. If, for example the two groups contained exactly two cards each, the string “Two pairs” was returned. To check for straight, the help-function checkStraight was used if both groups were zero, indicating no cards of the same value. checkStraight sorts the hand by value and checks the difference in value between one card and the next. If the difference is exactly one (1) for every step, true is returned, otherwise false. To check for flush, a similar help-function was used, checkFlush. The function returns true if all cards are of the same suit by checking each card against the next, otherwise false.

 
#Discussion
After running through the game a few iterations, it is reasonable to conclude that the program works as intended. The player can play the game through a user interface, where the player can load credits, play a hand and exit the game. Every time a hand is played, a deck is shuffled and the top five cards are given to the player. The player can then discard up to five cards and be dealt new cards. The game then correctly assesses the hand and rewards the player accordingly. Thus, it is reasonable to conclude that the purpose of the game was been fulfilled.



