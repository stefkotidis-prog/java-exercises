import java.util.Random;

// 1. Η κλάση Card (ΔΕΝ είναι public για να μπει στο ίδιο αρχείο)
class Card {
    private final String face; 
    private final String suit; 

    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public String toString() {
        return face + " of " + suit;
    }
}

// 2. Η κύρια κλάση (Πρέπει να έχει το ίδιο όνομα με το αρχείο .java)
public class DeckOfCards {
    private Card[] deck; 
    private int currentCard; 
    private static final int NUMBER_OF_CARDS = 52; 
    private static final Random randomNumbers = new Random(); 

    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
                          "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        deck = new Card[NUMBER_OF_CARDS]; 
        currentCard = 0; 

        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }

    // 3. Η main μέθοδος για να το τρέξεις και να δεις αν δουλεύει
    public static void main(String[] args) {
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.shuffle(); // Ανακάτεμα

        System.out.println("Μοίρασμα 5 καρτών:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-20s\n", myDeck.dealCard());
        }
    }
}